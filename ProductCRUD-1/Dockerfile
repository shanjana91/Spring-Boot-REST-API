#use base image openjdk with version(tag) :8
FROM openjdk:8

#add the jar resulted from maven build to app.jar of the container
ADD ./target/ProductCRUD-1-0.0.1-SNAPSHOT.jar app.jar

#expose this port in the container
EXPOSE 8081

#this the cmd to be executed when container runs
ENTRYPOINT ["java","-jar","app.jar"]