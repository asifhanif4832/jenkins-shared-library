#!/user/bin/env groovy
package com.example
class Docker implements Serializable{
    def script
    Docker(script){
        this.script=script
    }
    def buildDockerImage(String ImageName){
        script.sh "docker build -t $ImageName ."
    }
    def dockerLogin(){
        script.withCredentials([script.usernamePassword(credentialsId:'jenkins-pipeline', passwordVariable:'PASS', usernameVariable:'USER')]){
            script.sh 'echo $PASS | docker login -u $USER --password-stdin'

        }
    }
    def dockerPush(String ImageName){
        script.sh "docker push $ImageName"
    }
}