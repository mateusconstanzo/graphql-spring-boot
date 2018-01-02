FROM openjdk:8-jdk-alpine

ADD build/libs/graphql-spring-boot-0.1.0.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]