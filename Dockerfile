FROM amazoncorretto:17

WORKDIR /app

COPY target/toyporj-0.0.1-SNAPSHOT.jar /app/app.jar
COPY entrypoint.sh /app/entrypoint.sh

RUN chmod +x /app/entrypoint.sh

ENTRYPOINT ["/app/entrypoint.sh"]