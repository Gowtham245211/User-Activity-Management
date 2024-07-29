FROM amazoncorretto:17

LABEL maintainer="gowthamravichandran47@gmail.com"

WORKDIR /app

COPY target/User-Activity-Management-0.0.1-SNAPSHOT.jar /app/User-Activity-Management.jar

ENTRYPOINT ["java", "-jar", "User-Activity-Management.jar"]