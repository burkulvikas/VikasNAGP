pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the repository
                git 'https://github.com/burkulvikas/VikasNAGP.git'
            }
        }

        stage('Build') {
            steps {
                // Clean and package the application using Maven
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Run tests using Maven
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                // Deploy the application (this is a placeholder step)
                echo 'Deploying the application...'
                // You can add deployment commands here, like uploading to a server
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
