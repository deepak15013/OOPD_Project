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
@WebServlet(name = "ProfileViewServlet", urlPatterns = "/profileviewservlet")
public class ProfileViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String profileEmail = request.getParameter("search");
        System.out.println("profileEmail: "+profileEmail);

        String[] profileDetails = DatabaseHelper.shared().getProfileDetails(profileEmail);
        System.out.println("profileDetails:");

        for(int i=0;i<profileDetails.length;i++) {
            System.out.println("i: "+profileDetails[i]);
        }

        request.setAttribute("NAME",profileDetails[0]);
        request.setAttribute("EMAIL",profileDetails[1]);
        request.setAttribute("DOB",profileDetails[2]);
        request.setAttribute("GENDER",profileDetails[3]);
        request.getRequestDispatcher("/profile.jsp").forward(request, response);

    }
}
