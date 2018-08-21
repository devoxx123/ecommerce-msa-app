FROM openjdk:8
MAINTAINER Hari Kishore
ADD target/*.jar /msa-api-gateway.jar
RUN bash -c 'touch /msa-api-gateway.jar'
CMD ["java","-Dspring.profiles.active=docker","-jar","/msa-api-gateway.jar"]
EXPOSE 8888