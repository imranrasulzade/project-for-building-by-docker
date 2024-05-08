FROM openjdk:21-jdk-slim
WORKDIR /app
COPY build/libs/project-for-building-by-docker-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]