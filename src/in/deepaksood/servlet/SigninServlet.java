package in.deepaksood.servlet;

import in.deepaksood.databasehelper.DatabaseHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by deepaksood619 on 23/6/16.
 */
@WebServlet(name = "SigninServlet", urlPatterns = "/signinservlet")
public class SigninServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println("name: "+email+" password: "+password);

        if(DatabaseHelper.shared().checkPassword(email, password)) {

            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("USER_EMAIL", email);
            httpSession.setAttribute("PASSWORD", password);

            response.sendRedirect("homepage.jsp");
        } else {
            request.setAttribute("error_message","Wrong password, please try again");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
