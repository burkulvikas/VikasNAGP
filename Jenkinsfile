
pipeline {
            agent any
            Stages{
                Stage("Clone the code") {
                    steps{
                git branch: 'master', url: 'https://github.com/burkulvikas/VikasNAGP.git'                    }
                      }
                }
                Stage("Build") {
                    Steps{
                        // Run Maven clean
                        bat 'mvn clean test'
                    }
                }
                Stage("SonarQube Analysis") {
                    agent any
                    Step{
                    withSonarQubeEnv('Test_SonarQube'){
                    sh 'mvn clean package sonar:sonar'
                    }
                }
            }
            post {
                always{
                    // Clean up or notify if needed
                    echo 'Cleaning up...'
                }
                success{
                    echo 'Pipeline completed successfully!'
                }
                failure{
                    echo 'Pipeline failed!'
                }
            }
        }
