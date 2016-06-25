package in.deepaksood.servlet;

import in.deepaksood.classpackage.NotificationGrabber;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by deepaksood619 on 24/6/16.
 */
@WebServlet(name = "PostStatusServlet", urlPatterns = "/poststatusservlet")
public class PostStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("inside poststatus servlet");
        String postStatus = request.getParameter("poststatus");

        String userEmail = (String) request.getSession().getAttribute("USER_EMAIL");

        System.out.println("postStatus: "+postStatus+" by "+userEmail);

        NotificationGrabber.shared().addPost(userEmail,userEmail+":"+postStatus);

        response.sendRedirect("homepage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
