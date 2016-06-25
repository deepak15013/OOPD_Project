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
@WebServlet(name = "FriendRequestHandler", urlPatterns = "/friendrequesthandler")
public class FriendRequestHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("accept");
        String userEmail = (String) request.getSession().getAttribute("USER_EMAIL");
        String friendEmail = request.getParameter("ACCEPT_EMAIL");
        if(action != null) {
            // accept used
            System.out.println("accept: "+friendEmail + "user: "+userEmail);
            String query = "INSERT INTO friendlist VALUES(\""+friendEmail+"\", \""+userEmail+"\")";
            DatabaseHelper.shared().executeUpdate(query);
            query = "INSERT INTO friendlist VALUES(\""+userEmail+"\", \""+friendEmail+"\")";
            DatabaseHelper.shared().executeUpdate(query);
        }

        // decline used
        System.out.println("decline: "+friendEmail);
        String query = "DELETE FROM friendrequest WHERE fromemail=\""+friendEmail+"\" AND toemail=\""+userEmail+"\"";
        DatabaseHelper.shared().executeUpdate(query);

        response.sendRedirect("homepage.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
