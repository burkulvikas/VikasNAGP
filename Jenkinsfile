
pipeline {
            agent none

            stages {

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
