package in.deepaksood.servlet;

import in.deepaksood.databasehelper.DatabaseHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by deepaksood619 on 25/6/16.
 */
@WebServlet(name = "UnFriendServlet", urlPatterns = "/unfriendservlet")
public class UnFriendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String toEmail = request.getParameter("TO_EMAIL");
        String fromEmail = (String) request.getSession().getAttribute("USER_EMAIL");

        String query = "DELETE FROM friendlist WHERE email=\""+toEmail+"\" AND friendemail=\""+fromEmail+"\"";
        DatabaseHelper.shared().executeUpdate(query);

        query = "DELETE FROM friendlist WHERE email=\""+fromEmail+"\" AND friendemail=\""+toEmail+"\"";
        DatabaseHelper.shared().executeUpdate(query);

        response.sendRedirect("homepage.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
