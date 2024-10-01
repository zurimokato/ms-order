FROM ubuntu:latest
LABEL authors="noj23"
FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-order.jar
ENTRYPOINT ["java", "-jar","/ms-order.jar"]