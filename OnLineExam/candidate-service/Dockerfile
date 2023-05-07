FROM openjdk:17
VOLUME /tmp
ADD target/user-service.jar candidate-service.jar
ENTRYPOINT [ "java","-jar","/candidate-service.jar" ]