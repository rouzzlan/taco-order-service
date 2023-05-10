pipeline {
    agent any
    tools {
        jdk 'jdk-11.0.17'
    }
    stages {
        stage('Setup') {
            steps {
                sh '''
                    ./gradlew clean build
                '''
            }
        }
        stage('Build Docker') {
            steps {
                sh '''
                    docker login harbour.739.net -u="rouslan" -p="50m9FiD3"
                    ./gradlew bootBuildImage --publishImage
                '''
            }
        }
    }
}