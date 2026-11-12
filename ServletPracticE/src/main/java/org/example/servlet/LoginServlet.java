
package org.example.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve username and password
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate username
        if (username == null || username.length() < 3 ||
                !Character.isUpperCase(username.charAt(0))) {

            response.setContentType("text/html");
            response.getWriter().println("<h2>Invalid Username!</h2>");
            response.getWriter().println(
                    "<p>Username must start with a capital letter " +
                            "and contain at least 3 characters.</p>"
            );
            response.getWriter().println(
                    "<a href='login.html'>Try Again</a>"
            );
            return;
        }

        // Validate password
        boolean hasUppercase = password != null &&
                password.matches(".*[A-Z].*");

        boolean hasDigit = password != null &&
                password.matches(".*[0-9].*");

        boolean hasExactlyOneSpecialCharacter = password != null &&
                password.matches("[A-Za-z0-9]*[^A-Za-z0-9][A-Za-z0-9]*");

        boolean hasMinimumLength = password != null &&
                password.length() >= 8;

        if (!hasMinimumLength || !hasUppercase ||
                !hasDigit || !hasExactlyOneSpecialCharacter) {

            response.setContentType("text/html");
            response.getWriter().println("<h2>Invalid Password!</h2>");
            response.getWriter().println(
                    "<p>Password must contain:</p>"
            );
            response.getWriter().println(
                    "<ul>" +
                            "<li>Minimum 8 characters</li>" +
                            "<li>At least one uppercase letter</li>" +
                            "<li>At least one digit</li>" +
                            "<li>Exactly one special character</li>" +
                            "</ul>"
            );
            response.getWriter().println(
                    "<a href='login.html'>Try Again</a>"
            );
            return;
        }

        // Predefined login credentials
        String validUsername = "Admin";
        String validPassword = "admin123";

        if (validUsername.equals(username) &&
                validPassword.equals(password)) {

            request.setAttribute("username", username);

            request.getRequestDispatcher("/LoginSuccess.jsp")
                    .forward(request, response);

        } else {

            response.setContentType("text/html");
            response.getWriter().println(
                    "<h2>Invalid Username or Password!</h2>"
            );
            response.getWriter().println(
                    "<a href='login.html'>Try Again</a>"
            );
        }
    }
}
