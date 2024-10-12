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

        stage('Build') {
            steps {
                // Clean and package the application using Maven (Windows command)
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Run tests using Maven (Windows command)
                bat 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                // sonarqube analysis
                echo 'SonarQube Analysis going on...'
                withSonarQubeEnv('Test_SonarQube') {
                bat 'mvn clean package sonar:sonar'
                }
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
