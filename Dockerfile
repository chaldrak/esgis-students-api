# Étape de construction avec Maven
FROM maven:3.8.3-openjdk-17-slim AS build
WORKDIR /app

# Copier uniquement les fichiers nécessaires à la construction
COPY pom.xml .
COPY src ./src

# Construire l'application
RUN mvn clean package -DskipTests

# Étape finale d'exécution
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copier le JAR construit de l'étape précédente
COPY --from=build /app/target/*.jar app.jar

# Exposer le port de l'application
EXPOSE 8080

# Point d'entrée pour lancer l'application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]