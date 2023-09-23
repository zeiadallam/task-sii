# Use an official OpenJDK runtime as the base image
FROM bellsoft/liberica-openjdk-alpine:17.0.3

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container
COPY target/*.jar app.jar

# Expose the port that the Spring application listens on
#EXPOSE 8080

# Set the command to run the Spring application when the container starts
CMD ["java", "-jar", "app.jar"]
