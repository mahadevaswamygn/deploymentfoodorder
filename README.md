# FoodOrderApplication
* This is a Java and SpringBoot based Apllication project.which is used ordering food in online and it helpfull for developer . it also have a swagger ui.in this project i designed 3 Models

# Data Flow

# Cotroller
*Request make from postman or swagger ui cpme to the Controller class and based on request tye and endpoints to call methods in controller

# Service
* from the Controller class service class methods are colled. Serviceis the class where we write the business logic . all the bussiness sre availble here

# Repository
* From service class repository interface methods are colled. This is methods are mainly JPA repository and Curd repository methods but JPA repository is extend by repository interface

# Operations/Methods with its url and endpoints
*for user class
User/adduser: http://localhost:8080/swagger-ui/index.html#/user-controller/adduser
* for food class
-> addfood: http://localhost:8080/swagger-ui/index.html#/food-controller/addfood
->  getfood: http://localhost:8080/swagger-ui/index.html#/food-controller/getallfoods
-> updateFood: http://localhost:8080/swagger-ui/index.html#/food-controller/updatefood
-> deleteFood : http://localhost:8080/swagger-ui/index.html#/food-controller/deletfood
* for order class
-> orderfood : http://localhost:8080/swagger-ui/index.html#/order-controller/orderfood
-> get order by user id : http://localhost:8080/swagger-ui/index.html#/order-controller/getOrdersbyId



# Build 
* I/we use MVC architecture for Design the projrct. 
* I/we use MYSQL database in this project.
* I/we use List dataStructure in this project.
*I/we use Swagger ui in this project.
