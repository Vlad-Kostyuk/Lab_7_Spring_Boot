FROM openjdk:latest
ADD target/spring-boot-vlad.jar spring-boot-vlad.jar 
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "spring-boot-vlad.jar"]
