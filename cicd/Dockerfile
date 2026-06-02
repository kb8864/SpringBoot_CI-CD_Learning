# Mavenでjarを作る
FROM eclipse-temurin:21-jdk AS build

WORKDIR /workspace

COPY . .

RUN ./mvnw -B -DskipTests package

# 実行に必要なJREだけで起動する
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /workspace/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]