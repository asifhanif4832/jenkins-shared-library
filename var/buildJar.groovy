#!/user/bin/env groovy
def call(){
    echo 'building the jar file'
    sh 'mvn package'
}