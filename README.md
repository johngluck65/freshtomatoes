*Fresh Tomatoes*

This is a homework assignment.  

*Requirements*
* Maven
* Java 8
* curl

*Instructions for service*

1. Clone the repository
2. run mvn clean package (executes the tests)
3. run java -jar target/gs-accessing-data-rest-0.1.0.jar 

*Instructions for adding data*
At this point, you can add data with curl from the command lin

`curl -i -X POST -H "Content-Type:application/json" -d '{  "name" : "Monty Python and the holy grail",  "rating" : "good" }' http://localhost:8080/api/movies --user username:password` 

Note: I exposed the password.

*Reasons I did what I did*
* I chose to implement in Spring Boot because I am more familiar with Java than Ruby, though in  long run, I think Ruby might have been easier. This is my first Spring Boot REST service implementation.
* I chose to implement the HAL standard in HATEOAS since that is my understanding of what is the 'state of the art'.  I have not worked with this standard before so there was a bit of a learning curve.
* I chose not implement my tests in Cucumber.  Had I more time, I'd have done so. The RestAssured client has some GWT built into it.  Unfortunately, I couldn't figure out how to get it work with all my tests so some of my tests use restTemplate.
* I chose to document all of the the short comings of my code with a TODO and documented where I ripped code from.  I think this is usually good policy.
* I chose to implement Basic Auth security.  This is less than ideal, particularly when there are plain text passwords getting checked into the repo.
* For the purposes of ease-of-use for this assignment, I implemented the project as jar as opposed to a war.
* Ultimately, I wanted to provide something that worked and that represented a broad swath of all the features requested plus some bonuses which seemed to me to be important.  
* For the front-end, I chose Angular. I originally thought React.js would be best but it doesn't have templates and there was a bonus for having templates.  Of course, I ran out of time, so no templates. 
* It seemed complicated to try to get bower or npm to work with maven so I stayed with script imports and wro, which seems to be an outdated method but it worked
* I got really stuck on importing the libraries in Angular.  I'm clearly out of my element here but I've got something mostly working so I'm checking in at the moment



