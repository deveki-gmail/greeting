FROM openjdk:8
ADD target/greeting-0.0.1-SNAPSHOT.jar  greeting.jar
EXPOSE 8080
EXPOSE 8081
EXPOSE 8082
EXPOSE 8083
EXPOSE 8084
EXPOSE 8085
ENV PORT 8080
ENTRYPOINT ["java","-jar","-Dserver.port=${PORT}","greeting.jar"]