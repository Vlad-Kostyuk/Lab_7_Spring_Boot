FROM mysql:8
VOLUME ["/docker-spring-boot/db", "/var/lib/mysql"]
ENV MYSQL_DATABASE iot_test_db
COPY ./db/ /docker-entrypoint-initdb.d/

FROM openjdk:8
ADD target/docker-spring-boot.jar  docker-spring-boot.jar 
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]
