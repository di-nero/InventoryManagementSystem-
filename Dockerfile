# Step 1: Use OpenJDK base image
FROM openjdk:17-jdk-slim

# Step 2: Set the working directory
WORKDIR /app

# Step 3: Copy the jar file into the container
COPY target/*.jar app.jar

# Step 4: Expose port 8080
EXPOSE 8080

# Step 5: Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]