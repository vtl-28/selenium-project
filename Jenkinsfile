pipeline {
    agent any
    
    tools {
        // Define Maven and Java versions - Update these names to match your Jenkins configuration
        maven 'Maven'  // Replace with your Jenkins Maven installation name
        jdk 'JDK21'    // Replace with your Jenkins JDK installation name (JDK 11 or higher required)
    }
    
    environment {
        // Environment variables for the pipeline
        MAVEN_OPTS = '-Dmaven.test.failure.ignore=false'  // Pipeline fails if tests fail
        BROWSER = 'chrome'  // Default browser for Selenium tests
        TEST_SUITE = 'testng.xml'  // TestNG suite file
    }
    
    // Trigger pipeline automatically on code changes
    triggers {
        pollSCM('H/5 * * * *')  // Poll repository every 5 minutes for changes
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Checking out repository from GitHub..."
                checkout scm
                
                
            }
        }
        
        stage('Build') {
            steps {
                echo "Building the Selenium Maven project..."
                
                // Clean and compile the project
                bat 'mvn clean compile'
                
                // Validate project dependencies
                bat 'mvn dependency:tree'
                
                echo "Build completed successfully!"
            }
            post {
                failure {
                    echo "Build stage failed!"
                }
            }
        }
        
        stage('Test') {
            steps {
                echo "Running Selenium test cases against Amazon India website..."
                echo "Test Suite: ${TEST_SUITE}"
                echo "Browser: ${BROWSER}"
                
                
                 script {
                    def testngFile = 'testng.xml' // change if in a subfolder
                    if (fileExists(testngFile)) {
                        bat "mvn clean test -DsuiteXmlFile=${testngFile}"
                    } else {
                        error "TestNG suite file '${testngFile}' not found!"
                    }
                }
                
            }
            post {
                always {
                    echo "Processing test results..."
                }
                success {
                    echo "All tests passed successfully!"
                }
                failure {
                    echo "Some tests failed! Check the reports for details."
                }
                unstable {
                    echo "Tests completed but some are unstable."
                }
            }
        }
        
        
        stage('Cleanup') {
            steps {
                echo "Starting cleanup process..."
                
                // Clean Maven build artifacts
                bat 'mvn clean'
                
                echo "Cleanup completed successfully!"
            }
        }
    }
    
    post {
        always {
            echo "Pipeline execution completed."
            echo "Build Number: ${env.BUILD_NUMBER}"
            echo "Build Duration: ${currentBuild.durationString}"
            
            // Clean workspace to free up disk space
            cleanWs()
        }
        
        success {
            echo "Pipeline executed successfully!"
            echo "All stages completed without errors."
            
      
        }
        
        failure {
            echo "Pipeline failed! Please check the logs."
            echo "Check the console output and test reports for details."
        }
        
        unstable {
            echo "Pipeline completed but some tests are unstable."
            echo "Check test reports for flaky or failing tests."
        }
        
        aborted {
            echo "Pipeline was aborted."
        }
    }
}