#!/user/bin/env groovy
def call(){
    withCredentials([usernamePassword(credentialsId:'jenkins-pipeline', passwordVariable:'PASS', usernameVariable:'USER')]){
        sh 'docker build -t asifhanif01/java-maven-app:jma-1.2 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push asifhanif01/java-maven-app:jma-1.2'
    }
}