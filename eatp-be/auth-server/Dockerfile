# Dockerfile-auth-server

# STAGE 1 : BUILD TO JAR FILE
FROM maven:3.9.9-eclipse-temurin-17 AS builder
WORKDIR /eatp
COPY . .
RUN mvn -pl auth-server -am clean package -DskipTests

# STAGE 2 : RUN
FROM eclipse-temurin:17-jre-jammy
WORKDIR /eatp
COPY --from=builder /eatp/auth-server/target/*.jar eatp.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","eatp.jar"]