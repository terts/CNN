# CNN

This was created with TestNG, Java, Maven.

You will need to have maven installed on your system to run the tests yourself, as well as Java 1.8.

You will need to download the repo, cd to the directory containing the pom.xml file in a bash window, and do the command:

<code>
mvn test -Dbrowser=Firefox
  
mvn test -Dbrowser=Chrome
</code>

The test cases I created was one that uses UI (very basic test just to show using the webdrivers), and a few for API only tests.

There is a sample of the results that you can look at without running the tests yourself at test-output/emailable-report.html.

If this was to be run via Jenkins, you would need to have it run <code>src/test/resources/testng.xml</code> and set up a Parameter of "browser" where you pass in the name of the browser you wish to run it against, which I only set up for Firefox and Chrome at this time.
