FROM openjdk:17-jdk-slim
LABEL authors="noj2304"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-order.jar
ENTRYPOINT ["java", "-jar","/ms-order.jar"]