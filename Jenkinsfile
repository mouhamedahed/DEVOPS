pipeline {
	agent any 
	
	environment { 
        registry = "ghassengataa/devops" 
        registryCredential = 'dockerHub'
        dockerImage = '' 
    }


	stages{
			
			stage('Clean Package Test'){
			
					steps{
						bat "mvn clean package"
						bat "mvn test"
					}				
				}
				
			stage('Sonar'){
            steps {
                bat "mvn sonar:sonar -DskipTests=true"
            }
        }

            stage('Nexus'){
            steps {
                bat "mvn clean package -Dmaven.test.failure.ignore=true deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=DEVOPS -Dversion=1.7-SNAPSHOT -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-snapshots/ -Dfile=target/DEVOPS-1.7-SNAPSHOT.jar"
            }
        }

			stage('Building Image'){
				steps{
					script{
						dockerImage = docker.build registry + ":$BUILD_NUMBER"
					}
				}				
			}

			stage('Deploy Image'){
				steps{
					script{
						docker.withRegistry( '', registryCredential ) 
                        {dockerImage.push()}
					}
				}
			}
							
		
			
		}
	} 
w