FROM openjdk:8
VOLUME /err
ADD carnation-alpha-0.1.jar run.jar
ENTRYPOINT ["java", "-jar", "-Duser.timezone=GMT+08", "run.jar"]
EXPOSE 9779
