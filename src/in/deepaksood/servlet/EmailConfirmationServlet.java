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
@WebServlet(name = "EmailConfirmationServlet", urlPatterns = "/emailconfirmationservlet")
public class EmailConfirmationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txtOtp = request.getParameter("txt_otp");
        System.out.println("txtOtp: "+txtOtp);

        String confirmationOtp = String.valueOf(request.getSession().getAttribute("CONFIRMATION_OTP"));
        if(txtOtp.equals(confirmationOtp)) {
            response.sendRedirect("uploadpicture.jsp");
        }
        else {
            System.out.println("otp does not match");
            request.setAttribute("ERROR_MESSAGE","Wrong otp please try again.");

            String nextJSP = "/emailconfirmation.jsp";
            getServletContext().getRequestDispatcher(nextJSP).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
