FROM openjdk:11

WORKDIR /home/aws_dev/demo
COPY /target/app.war .
EXPOSE 80
CMD [ "java", "-jar", "app.war" ]

