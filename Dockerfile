FROM maven:3-jdk-11 as build

WORKDIR /app

COPY . ./

RUN mvn clean install



FROM openjdk:11

ARG JAR_FILE=app/target/*.jar

COPY --from=build ${JAR_FILE} /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]