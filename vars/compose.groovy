def call() {
    stage('Deploy with Docker Compose') {
        echo 'Deploying application with Docker Compose...'
        sh 'docker-compose up -d'
        echo 'Application deployed successfully.'
    }
}
