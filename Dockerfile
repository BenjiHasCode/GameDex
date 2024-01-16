# Use an official Maven image as a build environment
FROM maven:3.8.4-openjdk-11-slim AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project file
COPY pom.xml .

# Download and cache Maven dependencies
RUN mvn dependency:go-offline

# Copy the application source code
COPY src src

# Build the application
RUN mvn clean package

# Use an official OpenJDK runtime as a base image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app
#TEST

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/GameDex-0.0.1-SNAPSHOT.jar /app/

# Expose the port that your Spring Boot app will run on
EXPOSE 8080

# Specify the command to run on container start
CMD ["java", "-jar", "GameDex-0.0.1-SNAPSHOT.jar"]
