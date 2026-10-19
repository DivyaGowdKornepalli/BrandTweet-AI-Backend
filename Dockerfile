
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN chmod +x mvnw && ./mvnw clean package -DskipTests
EXPOSE 8080
CMD ["sh", "-c", "java -jar target/brandtweet-backend-0.0.1-SNAPSHOT.jar --server.port=${PORT:-8080}"]
