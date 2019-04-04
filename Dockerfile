FROM openjdk:12-jdk

RUN mkdir /opt/mapp
WORKDIR /opt/mapp
COPY build/libs/mapp-service-1.0.0.RELEASE.jar /opt/mapp/
CMD java -jar mapp-service-1.0.0.RELEASE.jar
