FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/spring-boot-scheduler-0.0.1-SNAPSHOT.jar /app/spring-boot-scheduler-0.0.1-SNAPSHOT.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "/app/spring-boot-scheduler-0.0.1-SNAPSHOT.jar"]