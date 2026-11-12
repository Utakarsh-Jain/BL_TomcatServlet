# Java Servlet Practice – Login & Validation System

## Project Overview

This project demonstrates the fundamentals of Java Servlets and Java Server Pages (JSP) using Apache Tomcat. It covers creating and deploying servlets, handling HTTP requests, processing login forms, and implementing username and password validation.

The project is developed using Java, Jakarta Servlet API, HTML, JSP, Maven, and Apache Tomcat.

## Technologies Used

- **Programming Language:** Java
- **Web Technology:** Jakarta Servlets
- **Frontend:** HTML
- **Server-side Pages:** JSP
- **Build Tool:** Maven
- **Web Server:** Apache Tomcat 10.1
- **IDE:** IntelliJ IDEA
- **JDK:** Java 17 or above

## Project Structure

```text
ServletPractice/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── org/
│       │       └── example/
│       │           └── servlet/
│       │               ├── FirstServlet.java
│       │               └── LoginServlet.java
│       │
│       └── webapp/
│           ├── index.html
│           ├── login.html
│           └── LoginSuccess.jsp
│
├── pom.xml
└── README.md
```

## Use Cases Implemented

### UC1 – Create First Servlet

- Created a Maven-based Java web application.
- Configured Jakarta Servlet API dependency.
- Created `FirstServlet` by extending `HttpServlet`.
- Used the `doGet()` method to handle HTTP GET requests.
- Mapped the servlet using `@WebServlet("/first")`.
- Displayed a Hello World message in the browser.

**URL:**
```text
http://localhost:8080/ServletPractice/first
```

### UC2 – Login Application

- Created an HTML login form.
- Accepted username and password from the user.
- Used the HTTP POST method to submit form data.
- Retrieved form parameters using `request.getParameter()`.
- Compared entered credentials with predefined credentials.
- Forwarded successful login requests to `LoginSuccess.jsp`.
- Displayed an error message for invalid credentials.

**Login Credentials:**

| Field | Value |
|---|---|
| Username | Admin |
| Password | Admin123@ |

### UC3 – Username Validation

Implemented username validation with the following conditions:

1. Username must start with an uppercase letter.
2. Username must contain at least 3 characters.

**Examples:**

| Username | Validation |
|---|---|
| Admin | Valid |
| Utakarsh | Valid |
| Abc | Valid |
| admin | Invalid |
| Ab | Invalid |

### UC4 – Password Validation

Implemented password validation with the following conditions:

1. Password must contain a minimum of 8 characters.
2. Password must contain at least one uppercase letter.
3. Password must contain at least one digit.
4. Password must contain exactly one special character.

**Examples:**

| Password | Validation |
|---|---|
| Admin123@ | Valid |
| Abcdef1@ | Valid |
| abcdefgh1@ | Invalid – No uppercase letter |
| Abcdefgh@ | Invalid – No digit |
| Abcdefg1 | Invalid – No special character |
| Abcdef1@# | Invalid – Multiple special characters |

## Maven Dependency

The following dependency is used in `pom.xml`:

```xml
<dependency>
    <groupId>jakarta.servlet</groupId>
    <artifactId>jakarta.servlet-api</artifactId>
    <version>6.0.0</version>
    <scope>provided</scope>
</dependency>
```

The project uses WAR packaging for deployment on Apache Tomcat.

## How to Run the Project

### Prerequisites

- Java JDK 17 or above
- IntelliJ IDEA
- Apache Tomcat 10.1
- Maven

### Execution Steps

1. Clone the repository:

```bash
git clone https://github.com/Utakarsh-Jain/ServletPractice.git
```

2. Open the project in IntelliJ IDEA.

3. Load the Maven dependencies.

4. Configure Apache Tomcat 10.1 as the application server using Smart Tomcat or an equivalent Tomcat run configuration.

5. Set the deployment directory to:

```text
src/main/webapp
```

6. Set the context path to:

```text
/ServletPractice
```

7. Start the Tomcat server.

8. Open the application in your browser:

```text
http://localhost:8080/ServletPractice/
```

9. Open the login page:

```text
http://localhost:8080/ServletPractice/login.html
```

10. Test the login functionality using the predefined credentials and validation rules.

## Learning Outcomes

Through this project, the following concepts were practiced:

- Understanding Java Servlets and their lifecycle.
- Creating and configuring Maven web applications.
- Handling HTTP GET and POST requests.
- Working with `HttpServletRequest` and `HttpServletResponse`.
- Retrieving HTML form data using request parameters.
- Using servlet annotations for URL mapping.
- Forwarding requests using `RequestDispatcher`.
- Integrating Servlets with JSP pages.
- Implementing username and password validation.
- Deploying Java web applications using Apache Tomcat.

## Author

**Utakarsh Jain**

GitHub: [Utakarsh-Jain](https://github.com/Utakarsh-Jain)

---

*This project was developed as part of Java Web Development practice, covering Servlet Use Cases UC1 to UC4.*
