FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
LABEL maintainer="Neyol Dilina"
WORKDIR /tmp/workdir
COPY target/demo-*.jar demo.jar
ENTRYPOINT ["java", "-jar", "demo.jar", "-Dexternal.param=${EXTERNAL_PARAM}"]
EXPOSE 80
