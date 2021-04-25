FROM openjdk:8
VOLUME /err
ADD carnation-alpha-0.1.jar run.jar
CMD ["nohup", "java", "-jar", "-Duser.timezone=GMT+08", "run.jar", ">", "apperr.log", "2>&1&"]
EXPOSE 9779
