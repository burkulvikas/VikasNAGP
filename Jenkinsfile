pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the repository, only on the master branch
                script {
                    def branch = env.GIT_BRANCH
                    if (branch != 'origin/master') {
                        error "Not on master branch: ${branch}"
                    }
                }
                git branch: 'master', url: 'https://github.com/burkulvikas/VikasNAGP.git'
            }
        }
        stage('Build & SonarQube Analysis') {
                    steps {
                        // sonarqube analysis & Clean and package the application using Maven (Windows command)
                        echo 'SonarQube Analysis going on...'
                        withSonarQubeEnv('Test_SonarQube') {
                        bat 'mvn clean package sonar:sonar'
                        }
                    }
                }
        stage('Deploy') {
            steps {
                rtMavenDeployer(
                   id: 'deployer',
                   serverId: '3190785@artifactory',
                   releaseRepo: 'nagp.assignment2024',
                   snapshotRepo: 'nagp.assignment2024'
                )
                rtMavenRun(
                   pom:'pom.xml',
                   goals: 'mvn clean install',
                   deployerId:'deployer'
                )
                rtPublishBuildInfo(
                   serverId: '3190785@artifactory',
                )
            }
        }
    }

    post {
        success {
            // Actions to perform on success
            echo 'Pipeline completed successfully!'
        }
        failure {
            // Actions to perform on failure
            echo 'Pipeline failed.'
        }
    }
}
