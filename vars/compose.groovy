def call(String composeDir = '.') {
    echo 'Deploying application with Docker Compose...'
    dir(composeDir) {
        sh 'docker-compose up -d'
    }
    echo 'Application deployed successfully.'
}
