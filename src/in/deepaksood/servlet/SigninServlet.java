package in.deepaksood.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by deepaksood619 on 23/6/16.
 */
@WebServlet(name = "SigninServlet", urlPatterns = "/signinservlet")
public class SigninServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println("name: "+name+" password: "+password);

        response.sendRedirect("homepage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
