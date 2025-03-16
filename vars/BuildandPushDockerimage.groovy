#!usr/bin/env groovy
def call(String dockerHubCredentialsID, String repoName, String imageName) {
	withCredentials([usernamePassword(credentialsId: "${dockerHubCredentialsID}", usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
		sh """
                    docker build . -t ${USERNAME}/lab22-image:v1.0
                    docker login -u ${USERNAME} -p ${PASSWORD}
                    docker push ${USERNAME}/lab22-image:v1.0
                    docker rmi ${USERNAME}/lab22-image:v1.0
                    """
  }
}
