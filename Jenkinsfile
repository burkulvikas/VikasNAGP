
pipeline {
            agent any

            tools {
                maven 'Maven'
            }

            stages {
                stage('Clone Code') {
                    steps {
                git branch: 'master', url: 'https://github.com/burkulvikas/VikasNAGP.git'                    }
                      }
                }
                stage('Build code') {
                    steps {
                        // Run Maven clean
                        bat 'mvn clean'
                    }
                }
                 stage('Run Test') {
                    steps {
                       // Run Maven test
                            bat 'mvn test'
                      }
                 }

                stage('SonarQube Analysis') {
                    steps {
                     withSonarQubeEnv('Test_SonarQube'){
                        bat 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:4.0.0.4121:sonar'
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
