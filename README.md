
This is the public repositroy for:
CS445 Object Oriented Design Fall 2016 Final Project
Author: Sean Gray
Email sgray2@hawk.iit.edu


Project details can be found [here](http://www.cs.iit.edu/~virgil/cs445/mail.fall2016/HW-1/hw1.html)
---

PREREQUISITES:
```
openJDK-8-jdk

Maven 3.1
```
To aquire these prerequisites run the following commands

```
sudo apt-get update
sudo apt-get install openJDK-8-jdk
sudo apt-get install maven
```

BUILD INSTRUCTIONS: In the main folder run
```
mvn build package
```

the jar file then can be found in: /target
the test coverage statitics can be found in: /target/site/jacoco/index.html
---
RUN INSTRUCTIONS: In the base directory run

'''
mvn spring-boot:run
'''

