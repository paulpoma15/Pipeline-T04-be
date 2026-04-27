# Stage 1: Build with Maven
FROM paulpoma15/maven:3.9-amazoncorretto-17-alpine AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run with Java
FROM paulpoma15/eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]


# CONSTRUIR UNA IMÁGEN MEDIANTE UN Dockerfile EN UNA CARPETA
# docker build -t paulpoma15/webflux-nosql:3.0 -f dockerfile-paul/Dockerfile .

# EJECUTAR LA IMÁGEN GENERADA
# docker run -d --name webflux-nosql -p 8081:8081 paulpoma15/webflux-nosql:3.0

# SUBIR IMÁGEN GENERADA A DOCKERHUB
# docker push paulpoma15/webflux-nosql:3.0


# DESCARGAR, RENOMBRAR Y SUBIR MAVEN A TU USUARIO DOCKERHUB
# docker pull maven:3.9-amazoncorretto-17-alpine
# docker tag 4211aacbdabe paulpoma15/maven:3.9-amazoncorretto-17-alpine
# docker push paulpoma15/maven:3.9-amazoncorretto-17-alpine


# DESCARGAR, RENOMBRAR Y SUBIR JDK17 A TU USUARIO DOCKERHUB
# docker pull eclipse-temurin:17-jre-alpine
# docker tag 88c0002860cd paulpoma15/eclipse-temurin:17-jre-alpine
# docker push paulpoma15/eclipse-temurin:17-jre-alpine