pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo "Checking out repository..."
                checkout scm
            }
        }
        stage('Build') {
            steps {
                echo "Building the project..."
                bat 'echo Hello from Jenkins!'
            }
        }
    }
}
