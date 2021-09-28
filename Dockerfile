
FROM openjdk:11
VOLUME /tmp
ARG WAR_FILE=target/*.war
COPY ${WAR_FILE} app.war
EXPOSE 8080
EXPOSE 8081
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.war"]