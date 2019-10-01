# BoatClub

Instructions

This is a Java project meaning that you need to have Java installed to your system.
https://www.java.com/sv/download/

The project uses the build tool Maven.  https://maven.apache.org/. You will see a .pom file in the app directory. This is the config file with all dependencies. Maven has support in the most of the greater IDE:s (IntelliJ, Eclipse, Visual Studio (code))

Intellij: https://www.jetbrains.com/help/idea/maven-support.html

Eclipse: https://www.vogella.com/tutorials/EclipseMaven/article.html

Visual Studio code: https://code.visualstudio.com/docs/java/java-project

Create a new project with maven and import the .pom file.  Then you can build and run the application.
However, if you want to use a terminal (yes you want!)

Linux user:
$apt install maven

or

$dnf install maven

In the app directory:

$mvn package

$mv .\target\app-0.1.0.jar .

$java -jar app-0.1.0.jar

This commands will build the project from the source code, move the jar file to current directory and then run the application

MacOS Don’t know anything about mac but this guide seems suitable:

http://www.codebind.com/mac-osx/install-maven-mac-os/

In the app directory:

$mvn package

$mv .\target\app-0.1.0.jar .

$java -jar app-0.1.0.jar

These commands will build the project from the source code, move the jar file to current directory and then run the application

Windows user
Follow this guide: https://docs.wso2.com/display/IS323/Installing+Apache+Maven+on+Windows

You can  remove the environmental variable after you are done with maven.
Use powershell and following commands:
In the app directory:

>mvn package

>mv .\target\app-0.1.0.jar .

>java -jar app-0.1.0.jar

These commands will build the project from the source code, move the jar file to current directory and then run the application

Take a note of this:

Into the application:
If your system language is English: use  1.5 for double

If your system language is Swedish(or other language uses , instead of .) use 1,5 for double
To avoid errors.


Good luck!
