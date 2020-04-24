FROM openjdk:11
ADD build/libs/ArbinaTest3-1.0-SNAPSHOT.jar ArbinaTest3-1.0-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "ArbinaTest3-1.0-SNAPSHOT.jar" ]