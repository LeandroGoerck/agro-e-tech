FROM openjdk:11.0-jdk as build-image
RUN mkdir -p /app/source
COPY . /app/source
WORKDIR /app/source
ENTRYPOINT ["./mvnw", "clean", "install"]

#FROM openjdk:11.0-jre
#COPY --from=build-image /app/source/target/*.jar /app/app.jar
#EXPOSE 8888
#ENTRYPOINT ["java", "-Dserver.port=8888", "-jar", "/app/app.jar"]
