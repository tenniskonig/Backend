FROM frolvlad/alpine-java
ADD maven/backend-0.0.1-SNAPSHOT.jar app.jar
#RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=fidocle:/dev/./urandom -jar /app.jar" ]