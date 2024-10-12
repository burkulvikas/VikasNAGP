pipeline {
    agent any

    environment {
        // Set the SonarQube server URL and token
        SONAR_HOST_URL = 'http://your-sonarqube-server'
        SONAR_TOKEN = credentials('sqa_f6b2022a72283dd3ff13e436318c12a694c3f38f') // Replace with your credential ID
    }

    stages {
        stage('Clone Code') {
            steps {
                // Checkout the master branch
                git branch: 'master', url: 'https://github.com/burkulvikas/VikasNAGP.git'
            }
        }

        stage('Build and Test') {
            steps {
                // Run Maven clean and test
                bat 'mvn clean test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                // Run SonarQube analysis
                bat '''
                mvn sonar:sonar ^
                    -Dsonar.projectKey=your-project-key ^
                    -Dsonar.host.url=%ttp://localhost:9000/% ^
                    -Dsonar.login=%%
                '''
            }
        }
    }