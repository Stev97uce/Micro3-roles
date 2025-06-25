
FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /app

COPY . /app/

RUN mvn clean package -DskipTests


FROM openjdk:17-slim

WORKDIR /app

COPY --from=build /app/target/roles-permissions-service-1.0.0.jar /app/roles-permissions-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/roles-permissions-service.jar"]
