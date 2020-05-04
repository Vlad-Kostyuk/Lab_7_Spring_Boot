FROM openjdk:8
ADD target/docker-spring-boot.jar  docker-spring-boot.jar 
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]

FROM mysql:5.6
ENV MYSQL_DATABASE iot_test_db
COPY /docker-spring-boot/Lab_7_Spring_Boot/db/ /docker-entrypoint-initdb.d/
