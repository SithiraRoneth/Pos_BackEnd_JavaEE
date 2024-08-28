# Pos System Back End

## Overview

This project is a Web-based Application designed to Manage customers, items and order form. It is built using Jakarta EE for the backend, MySQL for database management, and AJAX (or Fetch) for asynchronous operations in the frontend. The application follows a layered architecture to ensure modularity and maintainability.


## Technology Stack

- **Backend**: Jakarta EE (Servlets, EJB, JPA)
- **Frontend**: HTML, CSS, JavaScript, AJAX (or Fetch)
- **Database**: MySQL
- **Configuration**: JNDI for database configuration
- **Logging**: SLF4J with Logback (or Java Util Logging)

## Architecture

The application is designed with a layered architecture consisting of:

1. **Presentation Layer**: Handles the UI and user interaction using HTML, CSS, and JavaScript.
2. **Business Logic Layer**: Contains the core business logic and is implemented using Jakarta EE components like Servlets and EJBs.
3. **Data Access Layer**: Manages database operations using native SQL and JDBC, with connections configured via JNDI.
4. **Database Layer**: MySQL is used for data persistence.

## Usage 

### End points

1. GET /api/resource: Retrieves all resources.
2. POST /api/resource: Creates a new resource.
3. PUT /api/resource/{id}: Updates a resource by ID.
4. DELETE /api/resource/{id}: Deletes a resource by ID. 

## Logging
The application uses SLF4J with Logback (or Java Util Logging) for logging. The logging configuration can be found in the logback.xml file.

### Log levels 

 1. DEBUG: Detailed information on the flow through the system.
 2. INFO: Interesting runtime events (e.g., startup/shutdown).
 3. WARN: Use of deprecated APIs, poor use of API, 'almost' errors, other runtime situations that are undesirable or unexpected, but not necessarily "wrong".
 4. ERROR: Other runtime errors or unexpected conditions.

### Prerequisites

- Java Development Kit (JDK) 17 or later
- Jakarta EE compatible application server (e.g. Tomcat)
- MySQL database

### Steps

1. **Clone the repository**:
	https://github.com/SithiraRoneth/Pos_BackEnd_JavaEE.git
