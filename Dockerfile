FROM openjdk:11
EXPOSE 8088
ADD target/DEVOPS-1.3.jar DEVOPS-1.3.jar
ENTRYPOINT ["java", "-jar", "/DEVOPS-1.3.jar" ]