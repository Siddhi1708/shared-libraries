def call(String ProjectName,String ImageTag,String DockerHubUser)
{
  sh "docker build -t ${DockerHubUser}/${ProjectName}:${ImageTag}"
  withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        echo "Logging in to Docker Hub as ${dockerHubUser}"
        sh 'echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin'
        echo "Pushing Docker image to Docker Hub"
        sh "docker push ${dockerHubUser}/${projectName}:${imageTag}
}
