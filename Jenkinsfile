pipeline {
    agent any
    
    triggers {
        // Build every hour 
        // cron('H * * * *') 
        
        // Check GitHub every 5 mins; build  code changed
        pollSCM('H/5 * * * *')
    }
    
    environment {
        DOCKER_PATH = '/usr/local/bin/docker'
        APP_NAME = 'my-loan-app'
    }

    stages {
        stage('Maven Build') {
            tools {
                maven 'M3_HOME' 
            }
            steps {
                dir('ci_cd_loan_service') {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Docker Build') {
            steps {
                dir('ci_cd_loan_service') {
                    script {
                        sh "export PATH=\$PATH:/usr/local/bin && ${DOCKER_PATH} build -t ${APP_NAME}:${BUILD_NUMBER} -t ${APP_NAME}:latest ."
                    }
                }
            }
        }

        stage('Deploy Local') {
            steps {
                script {
                    echo "App is Built and Tagged as ${APP_NAME}:latest"
                }
            }
        }
    }
}
