pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'jdk17'
    }

    environment {
        IMAGE_NAME = "poc19-demo"
        IMAGE_TAG = "latest"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                url: 'https://github.com/CKShetty4/poc19-branching-cicd.git'
            }
        }

        stage('Build Application') {
            steps {
                sh 'mvn clean package'
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
                docker rm -f poc19-container || true
                docker run -d -p 8085:8081 --name poc19-container $IMAGE_NAME:$IMAGE_TAG
                '''
            }
        }
    }
}
