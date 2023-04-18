FROM openjdk:11
ADD target/GOT_memory_game.jar GOT_memory_game.jar
ENTRYPOINT ["java", "-jar","GOT_memory_game.jar"]got_memory_game.jar