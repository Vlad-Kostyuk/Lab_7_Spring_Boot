FROM openjdk:8
FROM mysql:5.6
ADD target/docker-spring-boot.jar  docker-spring-boot.jar 
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]
