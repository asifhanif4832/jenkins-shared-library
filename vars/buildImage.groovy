#!/user/bin/env groovy
def call(ImageName){
    withCredentials([usernamePassword(credentialsId:'jenkins-pipeline', passwordVariable:'PASS', usernameVariable:'USER')]){
        sh "docker build -t $ImageName ."
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh "docker push $ImageName"
    }
}