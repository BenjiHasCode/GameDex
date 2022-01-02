FROM adoptopenjdk/openjdk11:jre-11.0.8_10-alpine
WORKDIR /
ADD "/target/*.jar" "GameDex-0.0.1-SNAPSHOT.jar"
CMD ["java","-jar","./GameDex-0.0.1-SNAPSHOT.jar"]