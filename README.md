# SkyrimMC - minimal setup:

## Dependencies:

Java 8 Development Kit 241 or earlier

## Testing changes:

./gradlew runClient                -> test mod in minecraft

./gradlew --rerun-task runClient   -> test mod in minecraft after no changes to source code

## Exporting mod:

change mod version in build.gradle and src/main/java/com/horus/skyrimmc/SkyrimMC.java

./gradlew build                    -> create mod jar in build/libs/
