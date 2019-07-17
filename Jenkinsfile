pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                git 'https://github.com/Palanatolich153/TrelloAPI.git'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Report') {
            steps {
                step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
            }
        }
         stage('Email') {
                env.ForEmailPlugin = env.WORKSPACE
                emailext mimeType: 'text/xml',
                body: '${FILE, path="**/testng-results.xml"}',
                subject: currentBuild.currentResult + " : " + env.JOB_NAME,
                to: '4Pavel.Chaika@gmail.com'
         }
    }
}