#!/bin/bash
mvn clean package -DskipTests
java -jar -Dspring.data.mongodb.host=acme_db ./target/invillia-0.0.1-SNAPSHOT.jar
