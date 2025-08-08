def call(String branch, String repo, String githubCreds) {
    stage('clone') {
        git branch: branch, credentialsId: githubCreds, url: repo
    }
}
