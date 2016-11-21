
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
sudo apt-get install openjdk-8-jdk
sudo apt-get install maven
```

BUILD INSTRUCTIONS: In the main folder run
```
mvn clean package
```

the jar file then can be found in: /target
the test coverage statitics can be found in: /target/site/jacoco/index.html

---
RUN INSTRUCTIONS: In the base directory run

```
mvn spring-boot:run
```

---
Legal
All software in this repository is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation.

This Repository is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;without even the implied warranty of MERCHANTABILITY, or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Pulbic License for more details.

You should have recived a copy of the GNU General Public License along with the repository in the LICENSE file. If not, see http://www.gnu.org/licenses/

Copywrite Sean Gray 2016
