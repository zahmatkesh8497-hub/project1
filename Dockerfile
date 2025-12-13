FROM eclipse-temurin:25-jdk-noble
LABEL authors="omid"

WORKDIR /app

COPY Main.java .

RUN javac Main.java

CMD ["java", "Main"]