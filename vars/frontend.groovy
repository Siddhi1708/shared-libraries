def call(String projectName, String imageTag, String dockerHubUser, String credentialsId) {

    echo "Building Frontend Docker image: ${dockerHubUser}/${projectName}:${imageTag}"

    sh "docker build -t ${dockerHubUser}/${projectName}:${imageTag} ."
 
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {

        echo "Logging in to Docker Hub as ${DOCKER_USER}"

        sh 'echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin'
 
        echo "Pushing Frontend image to Docker Hub"

        sh "docker push ${dockerHubUser}/${projectName}:${imageTag}"

    }

}
