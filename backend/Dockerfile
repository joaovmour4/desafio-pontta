# Usa a imagem do OpenJDK 11
FROM openjdk:11-jdk-slim

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR gerado pelo Maven para o contêiner
COPY target/*.jar app.jar

# Expõe a porta 8080
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
