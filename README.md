#  Getir Case Study

## About
This project is prepared for "Getir". During the project, a structure where users buy books was modeled.

## Requirements and Tech Stack

Java 11, Spring, Spring Boot, Hibernate, JUnit and Intellij or Eclipse for development and run.

## API Details
Project has 4 controller and there are Customer, Book, Order and Statistics Controller.

#### Customer API
In Customer controller we can create new customer, get customer by given id and get customers all orders by given customer id.

Method: Post, URL: "/api/customer" -> Create new customer

Method: Get, URL: "/api/customer/{id}" -> Get customer

Method: Post, URL: "/api/customer/order" -> Get customer orders

#### Book API
In Book controller we can create new book, update book, get book by given id and update book stock.

Method: Post, URL: "/api/book" -> Create new book

Method: Put, URL: "/api/book" -> Update book

Method: Delete, URL: "/api/book/{id}" -> Delete book

Method: Put, URL: "/api/book/stock" -> Update book stock

#### Order API
In Order controller we can create new order, get order by given id and get orders from given date interval.

Method: Post, URL: "/api/order" -> Create new order

Method: Get, URL: "/api/order/{id}" -> Get order

Method: Post, URL: "/api/order/date" -> Get orders by given date interval

#### Statistics API
In Statistics controller we can get monthly statistics from given customers id.

Method: Get, URL: "/api/statistics/{id}" -> Get statistics for given customer id

## Download and Running Application

You can download this project with two way:
1) Click code and copy link then paste terminal  git clone https://github.com/ccanozerr/getir.git.

2) Click code and download as JAR.
Note: Practical way to start this app is right click the main class and run as java application. If you want to make executable jar please follow the steps below.

After get project cd to project folder then open terminal here and run the 
```mvn clean package``` 
command. If you are using STS/Eclipse IDE, then Right Click on your project » Run As » Maven build… » Goals: 
```clean package``` 
» Run. This will build our project and running tests after that create an executable JAR file of application and put it within the "targe"t folder.

For run application with jar, run this command in terminal;

```java -jar target/getir-code-challenge-0.0.1-SNAPSHOT.jar```

## Testing Application

This application has a swagger implementation for testing.
Just go to [Swagger Link](http://localhost:9521/swagger-ui.html#) after run the app. 
