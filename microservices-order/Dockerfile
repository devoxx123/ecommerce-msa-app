FROM openjdk:8
MAINTAINER Hari Kishore
ADD target/*.jar /msa-order.jar
RUN bash -c 'touch /msa-order.jar'
CMD ["java","-Dspring.profiles.active=docker","-jar","/msa-order.jar"]
EXPOSE 9082