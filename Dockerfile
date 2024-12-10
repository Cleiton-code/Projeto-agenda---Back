FROM maven:3.8.4-openjdk-17-slim AS build
COPY . /home/app/Projeto-agenda---Back         
RUN mvn -v
RUN mvn -f /home/app/Projeto-agenda---Back/pom.xml clean package



FROM openjdk:17-slim
COPY --from=build /home/app/Projeto-agenda---Back/target/*.jar /usr/local/lib/Agenda.jar
VOLUME /tmp
EXPOSE 8080:8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/Agenda.jar"]