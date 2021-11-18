FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/DEVOPS-1.1.jar DEVOPS-1.1.jar
ENTRYPOINT ["java","-jar","/DEVOPS-1.1.jar"]
