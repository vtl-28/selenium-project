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
                
                // Run TestNG tests via Maven
                bat "mvn clean test -DsuiteXmlFile=${TEST_SUITE}"
            }
            post {
                always {
                    echo "Processing test results..."
                    
                    // Publish TestNG results
                    publishTestResults testResultsPattern: 'target/surefire-reports/*.xml'
                    
                    // Archive TestNG HTML reports
                    archiveArtifacts artifacts: 'test-output/**/*', allowEmptyArchive: true, fingerprint: true
                    
                    // Archive ExtentReports if they exist
                    archiveArtifacts artifacts: 'target/extent-reports/**/*', allowEmptyArchive: true, fingerprint: true
                    
                    // Archive screenshots captured on test failures
                    archiveArtifacts artifacts: 'screenshots/**/*', allowEmptyArchive: true, fingerprint: true
                    
                    // Publish HTML test reports
                    publishHTML([
                        allowMissing: true,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'target/extent-reports',
                        reportFiles: '*.html',
                        reportName: 'Selenium Test Report (ExtentReports)',
                        reportTitles: 'Amazon India Automation Test Results'
                    ])
                    
                    // Also publish TestNG HTML report
                    publishHTML([
                        allowMissing: true,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'test-output',
                        reportFiles: 'index.html',
                        reportName: 'TestNG Report',
                        reportTitles: 'TestNG Execution Results'
                    ])
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
        
        stage('Package') {
            when {
                // Only package if tests pass
                expression { currentBuild.currentResult == 'SUCCESS' }
            }
            steps {
                echo "Packaging the test automation suite..."
                
                // Create JAR file without running tests again
                bat 'mvn package -DskipTests'
                
                // Archive the built artifacts
                archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true, fingerprint: true
                
                echo "Packaging completed!"
            }
        }
        
        stage('Cleanup') {
            steps {
                echo "Starting cleanup process..."
                
                // Clean Maven build artifacts
                bat 'mvn clean'
                
                // Remove temporary files and directories that may have been created during test execution
                script {
                    // Clean up screenshots directory
                    if (fileExists('screenshots')) {
                        bat 'if exist screenshots rmdir /s /q screenshots'
                        echo "Removed screenshots directory"
                    }
                    
                    // Clean up logs directory  
                    if (fileExists('logs')) {
                        bat 'if exist logs rmdir /s /q logs'
                        echo "Removed logs directory"
                    }
                    
                    // Clean up test-output directory
                    if (fileExists('test-output')) {
                        bat 'if exist test-output rmdir /s /q test-output'
                        echo "Removed test-output directory"
                    }
                    
                    // Clean up any WebDriver temporary files
                    if (fileExists('chromedriver.log')) {
                        bat 'if exist chromedriver.log del chromedriver.log'
                    }
                    if (fileExists('geckodriver.log')) {
                        bat 'if exist geckodriver.log del geckodriver.log'
                    }
                }
                
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
            
            // You can add success notifications here
            // Example: Send email notification
            // emailext (
            //     subject: "✅ SUCCESS: Amazon Selenium Tests - Build #${env.BUILD_NUMBER}",
            //     body: """
            //         <h2>🎉 Build Successful!</h2>
            //         <p><strong>Project:</strong> ${env.JOB_NAME}</p>
            //         <p><strong>Build:</strong> #${env.BUILD_NUMBER}</p>
            //         <p><strong>Duration:</strong> ${currentBuild.durationString}</p>
            //         <p><strong>Status:</strong> All Selenium tests passed!</p>
            //         <p><a href="${env.BUILD_URL}">View Build Details</a></p>
            //     """,
            //     to: "your-email@example.com",
            //     mimeType: 'text/html'
            // )
        }
        
        failure {
            echo "Pipeline failed! Please check the logs."
            echo "Check the console output and test reports for details."
            
            // You can add failure notifications here
            // emailext (
            //     subject: "❌ FAILURE: Amazon Selenium Tests - Build #${env.BUILD_NUMBER}",
            //     body: """
            //         <h2>❌ Build Failed!</h2>
            //         <p><strong>Project:</strong> ${env.JOB_NAME}</p>
            //         <p><strong>Build:</strong> #${env.BUILD_NUMBER}</p>
            //         <p><strong>Duration:</strong> ${currentBuild.durationString}</p>
            //         <p><strong>Status:</strong> Pipeline failed - please investigate</p>
            //         <p><a href="${env.BUILD_URL}console">View Console Log</a></p>
            //         <p><a href="${env.BUILD_URL}testReport">View Test Report</a></p>
            //     """,
            //     to: "your-email@example.com",
            //     mimeType: 'text/html'
            // )
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