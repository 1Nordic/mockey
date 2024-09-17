FROM openjdk:21-jdk-slim as BuildJava
ARG JAR_FILE=build/libs/mockey.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]