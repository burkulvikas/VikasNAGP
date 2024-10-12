
pipeline {
            agent any
            stages {
               stage("Clone the code") {
                    steps {
                git branch: 'master', url:'https://github.com/burkulvikas/VikasNAGP.git'                    }
                      }
               }
                stage("Build The code") {
                    steps {
                        // Run Maven clean
                        bat 'mvn clean'
                    }
                }
                 stage("Run The Test") {
                    steps {
                       // Run Maven test
                            bat 'mvn test'
                      }
                 }
            }

            post {
                success {
                    echo 'Pipeline completed successfully!'
                }
                failure {
                    echo 'Pipeline failed!'
                }
            }
        }
