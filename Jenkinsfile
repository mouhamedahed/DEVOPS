pipeline {
agent any
stages{
stage('GIT'){
steps{
echo 'Pulling ...';
git branch: 'firas',url:'https://github.com/mouhamedahed/DEVOPS.git';
}
}
stage('Build et Test'){
steps{
bat "mvn clean install -DskipTests=true";
bat "mvn test";
}
}
stage('Sonar'){
steps{
bat "mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install
-DskipTests=true";
bat "mvn org.jacoco:jacoco-maven-plugin:prepare-agent clean install
-Pcoverage-per-test -DskipTests=true";
bat "mvn sonar:sonar -DskipTests=true";
}
}
stage('Nexus'){
steps{
bat "mvn clean package -Dmaven.test.failure.ignore=true deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet-spring-boot-core-data-jpa-mvc-REST-1 -Dversion=1.1 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.1.jar"
}
}
stage ('Docker') {
steps{
bat """
docker compose up -d --build --force-recreate
"""
}
}
}
post {
always {
emailext body: 'A Test EMail' ,subject: 'Timesheet logs', to:
'firas.masmoudi@esprit.tn'
}
success {
echo 'This will run only if successful'
}
failure {
mail bcc: '', body: "<b>Example</b><br>Project: ${env.JOB_NAME} <br>Build
Number: ${env.BUILD_NUMBER} <br> URL de build: ${env.BUILD_URL}", cc: '', charset:
'UTF-8', from: '', mimeType: 'text/html', replyTo: '', subject: "ERROR CI: Project name ->
${env.JOB_NAME}", to: "firas.masmoudi@esprit.tn";
}
unstable {
echo 'This will run only if the run was marked as unstable'
}
changed {
echo 'This will run only if the state of the Pipeline has changed'
echo 'For example, if the Pipeline was previously failing but is now successful'
}
}
}
