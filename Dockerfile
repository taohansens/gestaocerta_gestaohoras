FROM openjdk:22-jdk-slim
LABEL authors="taohs"

ARG JAR_FILE=target/micro-gestao.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]