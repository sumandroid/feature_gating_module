#Feature Gating Module
Evaluates a conditional expression to boolean for a given set of attributes. It decides whether a user is allowed to
access a particular feature given it's attributes for this particular use case
but can be easily extended for any other use case.

Currently any logical operator can be supported extending functionality for BETWEEN, ALLOF, NONEOF operators as well.
See classes under 'operators' directory for details of every operator.

Basic Idea behind the module is to take Infix expression and convert it to postfix for evaluation 
maintaining operators' precedence.

Each operator has following easily configurable attributes:
1.  precedence
2.  operand count
3.  symbols

Functional Requirements met:
1. Conditional expression supports any infix expression
2. Supported operators >, >=, <=, <, ==, !=, BETWEEN, ALLOF, NONEOF
3. Module is easily extendable for new attributes (user attributes in our case) and new operators.
    > Whenever user attribute is added we need to define getter and setter for the same to take into effect.
      After adding a new Operator class implementing Operating interface add it in populateOperationsSet() method of
      InfixToPostfix class                                                                                                                                                                                                                                                                                        
4. Data type supported Integer, Float, String, Boolean
> Assumed the ALLOF operator to be TRUE if operand1 matches all the other operands
operand1 ALLOF operand1 operand3 evaluates to TRUE if operand1==operand2 AND operand1==operand3
> Similarly, assumed NONEOF evaluates to TRUE if operand1!=operand2 AND operand1!=operand3

User Attributes:
>User: {
 name: suman saurabh
 email: sumansaurabh93s@gmail.com
 phone: 8505947133
 address: Sobha Mayflower, Bellandur, Bengaluru
 pincode: 560103
 gender: Male
 pastOrderAmount: 10000.0
 active: true
 }

Note:
>Use whitespace after every operator and operands including opening and closing brackets
>attributes in condition expression are case-insensitive
>Only the valid attributes of User/Person class can be used
>Unit Test Cases are written under test folder.

* To Compile/Build the project
```./gradlew clean build```
* To run project
```java -jar build/libs/heimdall-1.0-SNAPSHOT.jar```
 
