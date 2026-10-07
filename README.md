Java Servlet JDBC CRUD Application

A web-based CRUD (Create, Read, Update, Delete) application developed using Java Servlets, JDBC, MySQL, HTML, and Apache Tomcat.

The application allows users to insert, retrieve, update, and delete records from a MySQL database through HTML forms and Java Servlets.

Technologies Used
Java
Java Servlets
JDBC
MySQL
HTML
Apache Tomcat
Eclipse IDE
ServletContext
web.xml
PreparedStatement
Features
Insert records into MySQL
Retrieve records from MySQL
Update existing records
Delete records
HTML forms for user input
Servlet-based request processing
JDBC database connectivity
MySQL database integration
PreparedStatement for SQL operations
Database configuration using ServletContext and web.xml
Application Flow
                         BROWSER
                            │
                            ▼
                        Index.html
                            │
             ┌──────────────┼──────────────┐
             │              │              │
             ▼              ▼              ▼
          Insert          Retrieve        Update
             │              │              │
             ▼              ▼              ▼
      InsertServlet   RetriveServlet   UpdateServlet
             │              │              │
             └──────────────┼──────────────┘
                            │
                            ▼
                       Delete
                            │
                            ▼
                     DeleteServlet
                            │
                            ▼
                     ServletContext
                            │
                            ▼
                         web.xml
                            │
                    Database Details
                            │
                            ▼
                      JDBC Driver
                            │
                            ▼
                       Connection
                            │
                            ▼
                  PreparedStatement
                            │
                            ▼
                          MySQL
Project Structure
Dynamic_Web_CRUD
│
├── src
│   └── main
│       ├── java
│       │   └── crudoOperations
│       │       ├── DeleteServlet.java
│       │       ├── InsertServlet.java
│       │       ├── RetriveServlet.java
│       │       └── UpdateServlet.java
│       │
│       └── webapp
│           ├── META-INF
│           │
│           ├── WEB-INF
│           │   ├── lib
│           │   │   └── mysql-connector-j-9.7.0.jar
│           │   └── web.xml
│           │
│           ├── Delete.html
│           ├── Index.html
│           ├── Insert.html
│           ├── Retrive.html
│           └── Update.html
│
└── README.md
CRUD Operations
Operation	Servlet	HTML Page	Purpose
Create	InsertServlet	Insert.html	Insert a new record
Read	RetriveServlet	Retrive.html	Retrieve records
Update	UpdateServlet	Update.html	Modify an existing record
Delete	DeleteServlet	Delete.html	Delete a record
Database Connectivity

The application uses JDBC to communicate with MySQL.

The basic flow is:

Servlet
   ↓
ServletContext
   ↓
Database Configuration
   ↓
JDBC Driver
   ↓
Connection
   ↓
PreparedStatement
   ↓
MySQL Database

Database configuration is managed through web.xml and accessed using ServletContext.

Important: Do not upload your actual MySQL username/password to GitHub. Use placeholder values in the public repository.

How to Run
Prerequisites

Install the following:

JDK
Eclipse IDE
Apache Tomcat
MySQL Server
MySQL Connector/J
Steps
Clone or download this repository.
Import the project into Eclipse as a Dynamic Web Project.
Configure Apache Tomcat.
Create the required MySQL database and table.
Configure your database URL, username, and password.
Make sure the MySQL Connector/J driver is available to the project.
Start the Apache Tomcat server.
Open the application in a browser.

Example:

http://localhost:8080/Dynamic_Web_CRUD/
Concepts Practiced

Through this project, I practiced:

HTTP request handling using Servlets
doGet() and doPost()
HTML form submission
Servlet mapping
ServletContext
web.xml
JDBC
JDBC Driver
Database Connection
PreparedStatement
ResultSet
CRUD operations
MySQL integration
Running a Java web application using Apache Tomcat
Future Improvements
Add input validation
Improve exception handling
Add a better user interface
Add search functionality
Add DAO layer
Add connection pooling
Add authentication and authorization
Migrate the application to Spring Boot
Author

THANIKONDA NARENDRA

B.Tech — Electronics and Communication Engineering

Skills: Java | JDBC | Servlets | MySQL | HTML | CSS | JavaScript