package in.deepaksood.servlet;

import in.deepaksood.classpackage.SendEmail;
import in.deepaksood.databasehelper.DatabaseHelper;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

/**
 * Created by deepaksood619 on 20/6/16.
 */
@WebServlet(name = "SignUpServlet", urlPatterns = "/signupservlet")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Random random = new Random();
        int confirmationOtp = random.nextInt(9999) + 1;

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

            String sqlQuery = "SELECT * FROM users WHERE email=\""+email+"\"";
            if(DatabaseHelper.shared().checkIfExists(sqlQuery)) {
                request.setAttribute("error_message","Email already in use, please login");
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }

            SendEmail sendEmail = new SendEmail();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    sendEmail.sendEmail(email,String.valueOf(confirmationOtp));
                }
            }).start();

            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("CONFIRMATION_OTP",confirmationOtp);
            httpSession.setAttribute("USER_EMAIL", email);
            httpSession.setAttribute("PASSWORD", password);

            response.sendRedirect("emailconfirmation.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
