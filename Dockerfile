FROM amazoncorretto:21-alpine-jdk

COPY target/test-0.0.1-SNAPSHOT.jar /api-test.jar

ENTRYPOINT ["java", "-jar", "/api-test.jar"]