FROM openjdk:latest
ADD target/spring-boot.jar  spring-boot.jar 
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "spring-boot.jar"]

