def call(String dockerhubCreds, String frontendImage, String frontendDir) {
    stage('Build & Push Frontend Image') {
        dir(frontendDir) {
            withDockerRegistry(credentialsId: dockerhubCreds, url: '') {
                sh "docker build -t ${frontendImage} ."
                sh "docker push ${frontendImage}"
            }
        }
    }
}
