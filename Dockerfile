FROM openjdk:21-slim
WORKDIR /app
COPY LoanSystem.jar .
ENTRYPOINT ["java", "-jar", "LoanSystem.jar"]
