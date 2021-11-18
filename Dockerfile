FROM openjdk:11
EXPOSE 8088
ADD target/DEVOPS-1.4.jar DEVOPS-1.4.jar
ENTRYPOINT ["java", "-jar", "/DEVOPS-1.4.jar" ]