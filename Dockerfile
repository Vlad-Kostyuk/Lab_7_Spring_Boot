FROM mysql:8
ARG MYSQL_DATABASE=iot_test_db
ARG MYSQL_USER=vlad
ARG MYSQL_PASSWORD=vlad771200
ARG MYSQL_ROOT_PASSWORD=vlad771200
ENV MYSQL_DATABASE=$MYSQL_DATABASE
ENV MYSQL_USER=$MYSQL_USER
ENV MYSQL_PASSWORD=$MYSQL_PASSWORD
ENV MYSQL_ROOT_PASSWORD=$MYSQL_ROOT_PASSWORD
VOLUME ["/docker-spring-boot/db"  "/docker-entrypoint-initdb.d"]
COPY ./db/ /docker-entrypoint-initdb.d/
EXPOSE 3036

FROM openjdk:8
ADD target/docker-spring-boot.jar  docker-spring-boot.jar 
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]
