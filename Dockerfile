# Utiliza una imagen base de Java
FROM eclipse-temurin:17-jre-alpine

# Establece el directorio de trabajo en /app
WORKDIR /app

COPY target/huellitas_backend-*.jar huellitas_backend.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","huellitas_backend.jar"]