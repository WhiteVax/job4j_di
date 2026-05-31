FROM maven:3.9.11-eclipse-temurin-21

RUN mkdir job4j_docker

WORKDIR /app

COPY . .

RUN mvn clean package dependency:copy-dependencies

CMD ["java", "-jar", "target/main.jar"]