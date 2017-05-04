FROM openjdk:8

WORKDIR /opt

COPY build/libs/ui-demo-0.0.3.jar /opt/ui.jar

EXPOSE 8080
CMD java -jar ui.jar

