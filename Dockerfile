FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} suba-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/suba-0.0.1-SNAPSHOT.jar"]
