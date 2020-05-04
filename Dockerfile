FROM openjdk:8
ADD target/docker-spring-boot.jar  docker-spring-boot.jar 
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]

FROM mysql:5.6
COPY ./db/ /docker-entrypoint-initdb.d/
