## Running the Ticket Tracker Web Application

This guide provides step-by-step instructions on how to run the Spring MVC and Hibernate web application. The project structure includes the necessary components for building a dynamic web application using Spring MVC, Hibernate, and JSP.

### Prerequisites

Before running the application, ensure that you have the following software installed on your machine:

* Java Development Kit (JDK) - version 8 or higher
* Apache Maven - for building the project
* Tomcat Server - for deploying and running the web application
* MySQL Database - for storing application data
### Download the project

#### Git Cloning
1. Open your terminal.
2. Run the following command to clone the repository:
    ```bash
    git clone https://github.com/your_username/TicketTrackerApplication.git
    ```
   Replace `your_username` with your actual GitHub username.

#### Or Downloading the repo
1. Visit the [repository page](https://github.com/your_username/TicketTrackerApplication).
2. Click on the "Code" button.
3. Select "Download ZIP" to download the repository as a ZIP file.

After downloading the project, navigate to the `TicketTrackerApplication` folder.


### Setting Up the Database

Open a MySQL client and execute the SQL script  `setup.sql`  located at the root of the project. This script creates the necessary database and table for the application.
```bash
mysql -u your_username -p < setup.sql
```
Enter your MySQL password when prompted.

### Configuring Database Connection

Open the file  `src/main/webapp/WEB-INF/classes/database.properties` .

Update the properties such as  `db.url` ,  `db.username` , and  `db.password`  with your MySQL database connection details.

### Building the Project

Open a terminal and navigate to the root of the project.

Run the following Maven command to build the project:
```bash
mvn clean install
```

### Deploying to Tomcat Server
* Eclipse
    1. Right Click the Application Folder
    2. Run on Server

### Controller Endpoints

This document provides details on the endpoints exposed by the  `TicketController`  class in the Spring MVC and Hibernate web application. The base URL for all endpoints is  `http://localhost:8080/admin/tickets` .

1. Home Page

URL:  `/` 

Method:  `GET` 

Description: Retrieves a list of all tickets and displays them on the home screen.

View:  `home-page.jsp` 

Exception View:  `error-page.jsp` 

2. Create a New Ticket

URL:  `/newTicket` 

a. Display the Form for Adding a New Ticket

Method:  `GET` 

Description: Displays the form for creating a new ticket.

View:  `create-ticket-page.jsp` 

Exception View:  `error-page.jsp` 

b. Save and Update Ticket

Method:  `POST` 

Description: Saves or updates the ticket based on whether it is a new ticket or an existing one.

View: Redirects to  `/tickets` 

Exception View:  `error-page.jsp` 

3. View Details of a Ticket

URL:  `/{id}` 

Method:  `GET` 

Description: Displays details of a specific ticket.

View:  `create-ticket-page.jsp` 

Exception View:  `error-page.jsp` 

4. Edit a Ticket

URL:  `/{id}/edit` 

a. Display the Form for Updating a Ticket

Method:  `GET` 

Description: Displays the form for editing an existing ticket.

View:  `create-ticket-page.jsp` 

Exception View:  `error-page.jsp` 

b. Update a Ticket

Method:  `POST` 

Description: Updates the details of an existing ticket.

View: Redirects to  `/tickets` 

Exception View:  `error-page.jsp` 

5. Delete a Ticket

URL:  `/{id}/delete` 

Method:  `GET` 

Description: Deletes a specific ticket.

View: Redirects to  `/tickets` 

Exception View:  `error-page.jsp` 

6. Search for Tickets

URL:  `/search` 

Method:  `GET` 

Description: Searches for tickets based on a query.

View:  `home-page.jsp` 

Exception View:  `error-page.jsp` 

Request Parameters

 `query`  (String): The search query.