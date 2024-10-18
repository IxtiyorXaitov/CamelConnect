# Maven builder image
FROM maven:3.9.6-amazoncorretto-17 as builder

ENV HOME=/app

RUN mkdir -p $HOME
WORKDIR $HOME

COPY ./ ./

# Load environment variables from .env file
RUN export $(grep -v '^#' .env | xargs -d '\n')

# Build the project (clean and package)
RUN mvn -f $HOME/pom.xml clean -DskipTests
RUN mvn -f $HOME/pom.xml package -DskipTests

# Move the built JAR file to /app directory
RUN mv ./target/*.jar /app/app.jar

RUN ls -la

# Java runtime image
FROM eclipse-temurin:17-jdk

ENV TZ="Asia/Tashkent"

RUN mkdir /app

WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/app.jar /app/app.jar

RUN ls -la

# Set the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
