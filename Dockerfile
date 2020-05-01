FROM openjdk:latest
ADD target/rest-service-0.1.0.jar rest-service-0.1.0.jar 
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "rest-service-0.1.0.jar"]