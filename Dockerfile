FROM azul/zulu-openjdk:21.0.3

LABEL maintainer="jansenmarsonang@gmail.com"

EXPOSE 8085

ARG JAR_FILE=target/loan-app-1.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
