
package org.example.servlet;

// Import required Java and Servlet classes
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Map this Servlet to the /login URL
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // Handle HTTP POST requests from the login form
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve username entered by the user
        String username = request.getParameter("username");

        // Retrieve password entered by the user
        String password = request.getParameter("password");

        // Define predefined login credentials
        String validUsername = "admin";
        String validPassword = "admin123";

        // Check whether both username and password match
        if (validUsername.equals(username) &&
                validPassword.equals(password)) {

            // Forward the request to the success JSP page
            request.getRequestDispatcher("/LoginSuccess.jsp")
                    .forward(request, response);

        } else {

            // Set the response content type to HTML
            response.setContentType("text/html");

            // Display an error message for invalid credentials
            response.getWriter().println(
                    "<h2>Invalid Username or Password!</h2>"
            );

            // Provide a link to return to the login page
            response.getWriter().println(
                    "<a href='login.html'>Try Again</a>"
            );
        }
    }
}
