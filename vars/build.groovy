def call(String dockerhubCreds, String backendImage) {
    stage('Build & Push Backend Image') {
        withDockerRegistry(credentialsId: dockerhubCreds, url: '') {
            sh "docker build -t ${backendImage} ."
            sh "docker push ${backendImage}"
        }
    }
}
