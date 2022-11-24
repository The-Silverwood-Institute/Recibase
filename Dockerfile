FROM sbtscala/scala-sbt:eclipse-temurin-17.0.4_1.8.0_2.13.10

WORKDIR /recibase
ADD . /recibase
CMD sbt run
