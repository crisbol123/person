FROM public.ecr.aws/amazoncorretto/amazoncorretto:17
COPY target/people.jar people.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","people.jar"]