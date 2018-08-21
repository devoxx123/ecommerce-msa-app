FROM openjdk:8
MAINTAINER Hari Kishore
ADD target/*.jar /msa-content.jar
RUN bash -c 'touch /msa-content.jar'
CMD ["java","-Dspring.profiles.active=docker","-jar","/msa-content.jar"]
EXPOSE 9084