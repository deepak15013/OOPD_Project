package in.deepaksood.servlet;

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

        request.getRequestDispatcher("/profile.jsp").forward(request, response);

    }
}
