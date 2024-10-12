
pipeline {
            agent any
            stages {
                stage("Clone the code") {
                    steps {
                git branch: 'master', url: 'https://github.com/burkulvikas/VikasNAGP.git'                    }
                      }
                }
                stage("Build") {
                    steps {
                        // Run Maven clean
                        bat 'mvn clean test'
                    }
                }
                stage("SonarQube Analysis") {
                    agent any
                    step{
                    withSonarQubeEnv('Test_SonarQube'){
                    sh 'mvn clean package sonar:sonar'
                    }
                }
            }
            post {
                always {
                    // Clean up or notify if needed
                    echo 'Cleaning up...'
                }
                success {
                    echo 'Pipeline completed successfully!'
                }
                failure {
                    echo 'Pipeline failed!'
                }
            }
        }
