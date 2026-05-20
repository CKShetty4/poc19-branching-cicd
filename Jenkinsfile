pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'jdk17'
    }

    environment {
        IMAGE_NAME = "poc8-demo"
        IMAGE_TAG = "latest"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                url: 'https://github.com/ckshetty4/poc8-sonarqube-demo.git'
            }
        }

        stage('Build Application') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh 'mvn sonar:sonar -Dsonar.projectKey=poc8-demo'
                }
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t $IMAGE_NAME:$IMAGE_TAG .'
            }
        }

        stage('Deploy Container') {
            steps {
                sh '''
                docker rm -f poc8-container || true
                docker run -d -p 8081:8081 --name poc8-container $IMAGE_NAME:$IMAGE_TAG
                '''
            }
        }
    }
}
