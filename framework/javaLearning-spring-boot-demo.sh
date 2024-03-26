#!/usr/bin/zsh

: spring-boot-javaLearning;spring init \
--target https://start.spring.io \
--language java \
--boot-version 3.2.1 \
--java-version 17 \
--packaging jar \
--type maven-project \
--group-id org.oizehsgl.javaLearning \
--artifact-id javaLearning-spring-boot-demo \
--description javaLearning-spring-boot-demo \
--package-name org.oizehsgl.javaLearning.spring-boot-demo \
--name javaLearning-spring-boot-demo \
--version 1.0.0-SNAPSHOT \
--dependencies actuator,devtools,lombok,validation \
javaLearning-spring-boot-demo

: gitignore;wget -O ./javaLearning-spring-boot-demo/.gitignore https://www.toptal.com/developers/gitignore/api/java,maven,intellij+all
