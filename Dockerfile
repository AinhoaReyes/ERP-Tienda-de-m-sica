FROM openjdk:17
ADD target/erp-springboot-docker.jar erp-springboot-docker.jar
ENTRYPOINT ["java","-jar","/erp-springboot-docker.jar"]