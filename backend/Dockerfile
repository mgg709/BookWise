# Etapa de construcción
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY . /app
RUN mvn -f /app/pom.xml clean package -DskipTests

# Etapa de ejecución
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar /app/backend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app/backend-0.0.1-SNAPSHOT.jar"]