#FROM anapsix/alpine-java
#MAINTAINER caodangtinh@gmail.com
#
#RUN mkdir /opt/drop_services
#EXPOSE 8080 8081
#
#ADD ../target/location-service.jar /opt/drop_services/location-service.jar
#ADD ../config.yml /opt/drop_services/config.yml
#
#WORKDIR /opt/drop_services
#CMD ["java", "-jar", "location-service.jar", "server", "config.yml"]



FROM openjdk:8-jdk
COPY config.yml /data/dropwizard-sample/config.yml
COPY target/location-service.jar /data/dropwizard-sample/location-service.jar

WORKDIR /data/dropwizard-sample

RUN java -version
RUN javac -version

CMD ["java","-jar","location-service.jar","server","config.yml"]

EXPOSE 8080-8081