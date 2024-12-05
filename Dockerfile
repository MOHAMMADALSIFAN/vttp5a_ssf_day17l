# First Stage - Build
FROM openjdk:23-jdk-oracle AS builder
ARG COMPILE_DIR=/compiledir
WORKDIR ${COMPILE_DIR}
COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .
COPY .mvn .mvn
COPY src src
RUN ./mvnw clean package -DskipTests

# Second Stage - Runtime
FROM openjdk:23-jdk-oracle
ARG WORK_DIR=/app
WORKDIR ${WORK_DIR}
COPY --from=builder /compiledir/target/day17lecture-0.0.1-SNAPSHOT.jar vttp5b-ssf-day17l.jar
ENV SERVER_PORT=8080
EXPOSE ${SERVER_PORT}
ENTRYPOINT ["java", "-jar", "vttp5b-ssf-day17l.jar"]

# run
# docker build -t cihansifan/vttp5b-ssf-day17l:v0.0.1 .  

# container
# docker run -p 8085:8080 cihansifan/vttp5b-ssf-day17l:v0.0.1     