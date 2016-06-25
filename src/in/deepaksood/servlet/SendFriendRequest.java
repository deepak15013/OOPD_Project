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
@WebServlet(name = "SendFriendRequest", urlPatterns = "/sendfriendrequest")
public class SendFriendRequest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String toEmail = request.getParameter("TO_EMAIL");
        String fromEmail = (String) request.getSession().getAttribute("USER_EMAIL");

        System.out.println("from: "+fromEmail+" to: "+toEmail);

        String sqlQuery = "INSERT INTO friendrequest VALUES(\""+fromEmail+"\", \""+toEmail+"\")";
        Boolean check = DatabaseHelper.shared().executeUpdate(sqlQuery);
        if(check) {
            request.setAttribute("ERROR_MESSAGE","Friend request sent");
            request.getRequestDispatcher("/homepage.jsp").forward(request, response);
        }
        else {
            request.setAttribute("ERROR_MESSAGE","Friend request not sent, please try again later");
            request.getRequestDispatcher("/homepage.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
