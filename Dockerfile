FROM openjdk:8
EXPOSE 8080
ADD target/mail-buddy.jar mail-buddy.jar
ENTRYPOINT ["java","-jar","/mail-buddy.jar"]