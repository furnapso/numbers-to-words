FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/numbers-to-words-backend-0.0.1-SNAPSHOT.jar /app/numbers-to-words-backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/numbers-to-words-backend.jar"]
