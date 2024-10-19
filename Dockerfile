FROM openjdk:17-jdk-slim
LABEL authors="noj2304"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-order.jar
EXPOSE 8088
ENTRYPOINT ["java", "-jar","/ms-order.jar"]