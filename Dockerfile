# Use an official OpenJDK image as the base
FROM openjdk:11-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Java source code to the container
COPY ParkingSystem.java .

# Compile the Java source code
RUN javac ParkingSystem.java

# Command to run the Java application
CMD ["java", "ParkingSystem"]
