#About Project

This module is part of shopping cart application where we are trying to 
calculate the discount for different types of customer based on their purchase. We have discount
defined for each slab based on the customer type.

#Some important points about the project

1. I have used property files to loosely couple any addition of benefits related to slab and discount.

2. I have used factory Design Pattern, to loosely couple the dependency of adding any new customer in future.

3. The abstract class is used to hide the implementation of the core calculate discount method.

4. Created separate class for each customer type(Regular,Premium) which will extend 
	the Abstract class Customer, this shows the usage of Inheritance.
	
5. The abstract method is implemented in the extended class, which shows usage of Method overriding
	which is example of Polymorphism.
	
6. In the core logic, I have used LinkedHashMap and also dynamically added the key which is the range
	and value which is discount of each slab. LinkedHashMap is used to get the list in insertion order
	and also in key value pair.
	
7. I have used Singleton Design Pattern for ConfigReader class, because the configuration 
	needs to be loaded only at once, which will not create unnecessary object each time method is invoked.
	
8. I have used some variables as static as they will be used at class level.

9. There are some assumption made while adding the value in property file like MAX for 
   last slab for upper limit of range.
	
10. I have used Log4j to output the logs into one file which is located at /logs/output.log.

11. As there are less number of jars, I have added them in lib folder in project, If there were more
	number of jars, we can use Maven to load the dependencies.

12. Created Test cases to test each core method using JUnit.
