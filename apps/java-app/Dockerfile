FROM eclipse-temurin

ARG message="Default Arg Message"
ENV MESSAGE $message

WORKDIR /app

COPY TestHttpServer.java TestHttpServer.java

RUN javac TestHttpServer.java

CMD ["java", "TestHttpServer"]