# CNN

This was created with TestNG, Java, Maven.

You will need to have maven installed on your system to run the tests yourself, as well as Java 1.8.

You will need to download the repo, cd to the directory containing the pom.xml file in a bash window, and do the command:

mvn test -Dbrowser=Firefox
Or
mvn test -Dbrowser=Chrome

The test cases I created was one that uses UI (very basic test just to show using the webdrivers), and a few for API only tests.

There is a sample of the results that you can look at without running the tests yourself at test-output/emailable-report.html.
