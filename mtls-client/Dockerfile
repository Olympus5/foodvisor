# syntax=docker/dockerfile:1
ARG MAVEN_BUILDER=3-eclipse-temurin-21-alpine

FROM maven:${MAVEN_BUILDER}
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
CMD java -jar target/mtls-client-1.0.0-SNAPSHOT.jar
