package in.deepaksood.servlet;

import in.deepaksood.databasehelper.DatabaseHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by deepaksood619 on 24/6/16.
 */
@WebServlet(name = "SavePersonalDetails", urlPatterns = "/savepersonaldetails")
public class SavePersonalDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userEmail = (String) request.getSession().getAttribute("USER_EMAIL");
        System.out.println("Email: "+userEmail);
        String password = (String) request.getSession().getAttribute("PASSWORD");
        System.out.println("pass: "+password);

        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        System.out.println("firstname: "+firstName+" last: "+lastName+" dob: "+dob+" gender: "+gender);

        String sqlQuery = "INSERT INTO users VALUES(\""+ userEmail +"\", \""+password+"\", \""+firstName+"\", \""+lastName+"\", \""+dob+"\", \""+gender+"\")";
        DatabaseHelper.shared().executeUpdate(sqlQuery);

        response.sendRedirect("uploadpicture.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
