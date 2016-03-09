*Fresh Tomatoes*

This is a homework assignment.  

*Requirements*
* Maven
* Java 8

*Instructions for service*

1. Clone the repository
2. run mvn clean package (executes the tests)
3. run java -jar target/gs-accessing-data-rest-0.1.0.jar 

*Reasons I did what I did*
* I chose to implement in Spring Boot because I am more familiar with Java than Ruby, though in  long run, I think Ruby might have been easier. This is my first Spring Boot REST service implementation.
* I chose to implement the HAL standard in HATEOAS since that is my understanding of what is the 'state of the art'.  I have not worked with this standard before so there was a bit of a learning curve.
* I chose not implement my tests in Cucumber.  Had I more time, I'd have done so. The RestAssured client has some GWT built into it.  Unfortunately, I couldn't figure out how to get it work with all my tests so some of my tests use restTemplate.
* I chose to document all of the the short comings of my code with a TODO and documented where I ripped code from.  I think this is usually good policy.
* I chose to implement Basic Auth security.  This is less than ideal, particularly when there are plain text passwords getting checked into the repo.
* For the purposes of ease-of-use for this assignment, I implemented the project as jar as opposed to a war.
* Ultimately, I wanted to provide something that worked and that represented a broad swath of all the features requested plus some bonuses which seemed to me to be important.  At this point, I'm still working on standing up a front end.



