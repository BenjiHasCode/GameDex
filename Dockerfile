FROM adoptopenjdk/openjdk11:jre-11.0.8_10-alpine
COPY target/GameDex-0.0.1-SNAPSHOT.jar GameDex-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/GameDex-0.0.1-SNAPSHOT.jar"]