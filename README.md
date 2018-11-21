#Invillia recruitment challenge

The ACME company is migrating their monolithic system to a microservice architecture and you’re responsible to build their MVP (minimum viable product)  .
https://en.wikipedia.org/wiki/Minimum_viable_product

Your challenge is:
Build an application with those features described below, if you think the requirements isn’t enough described please leave a comment (portuguese or english) with the doubt you think it’s necessary to continue the development.

You can choose whatever feature you think it’s necessary for MVP,  IT’S NOT necessary build all the features, we strongly recommend to focus on quality and not implemented features quantity, you’ll be evaluated by the quality of completed tasks not the amount of completed tasks.

If you think something is really necessary but you don’t have enough time to implement please at least leave a comment describing how you’d implement.

## Tasks

Your task is to develop one (or more, feel free) RESTful service(s) to:
* Create a **Provider**
* Update a **Provider** information
* Retrieve a **Provider** by parameters
* Create an **Order** with items
* Create a **Payment** for an **Order**
* Retrieve an **Order** by parameters
* Refund **Order** or any **Order Item**

Fork this repository and submit your code with partial commits.

## Business Rules

* A **Provider** is composed by name and address
* An **Order** is composed by address, confirmation date and status
* An **Order Item** is composed by description, unit price and quantity.
* A **Payment** is composed by status, credit card number and payment date
* An **Order** just should be refunded until ten days after confirmation and the payment is concluded.

## Non functional requirements

Your service(s) must be resilient, fault tolerant, responsive. You should prepare it/them to be highly scalable as possible.

The process should be closest possible to "real-time", balancing your choices in order to achieve the expected
scalability.

## Optional features (describe or implement):
* Asynchronous processing
* Database
* Docker - https://www.docker.com/
* AWS propose - https://github.com/localstack/localstack
* Security
* Swagger - https://swagger.io/
