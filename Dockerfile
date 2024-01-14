FROM openjdk:17-alpine
EXPOSE 8080
ADD target/cloud-0.0.1-SNAPSHOT.jar cloud.jar
ENTRYPOINT ["java","-jar","/cloud.jar"]