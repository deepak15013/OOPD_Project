package in.deepaksood.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * Created by deepaksood619 on 20/6/16.
 */
@WebServlet(name = "SignUpServlet", urlPatterns = "/signupservlet")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("inside signupservlet");

        String email = request.getParameter("email");
        System.out.println("name: " + email);

        String password = request.getParameter("password");
        System.out.println("password: " + password);

        String confirmPassword = request.getParameter("confirm_password");
        System.out.println("confirm_password: "+confirmPassword);

        if(!password.equals(confirmPassword)) {
            System.out.println("password does not matches");
            request.setAttribute("error_message","password does not match");
            String nextJSP = "/index.jsp";
            getServletContext().getRequestDispatcher(nextJSP).forward(request, response);
        }
        else {
            System.out.println("password matches");
        }

        response.sendRedirect("uploadpicture.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
