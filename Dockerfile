FROM openjdk:11
EXPOSE 8088
ADD target/DEVOPS-0.3.jar DEVOPS-0.3.jar
ENTRYPOINT ["java", "-jar", "/DEVOPS-0.3.jar" ]