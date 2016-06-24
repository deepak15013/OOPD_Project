package in.deepaksood.classpackage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * Created by deepaksood619 on 24/6/16.
 */

public class SendEmail extends HttpServlet {


    public void sendEmail(String recipient, String textOtp) {
        // Recipient's email ID needs to be mentioned.
        String to = recipient;

        // Sender's email ID needs to be mentioned
        String from = "deepaksood619@gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        //properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("deepaksood619@gmail.com","deepak9425592627");
            }
        });

        try{
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            // Set Subject: header field
            message.setSubject("Otp for signup to ConnectBook");
            // Now set the actual message
            message.setText("Your otp for sign up to ConnectBook is "+textOtp);
            // Send message
            Transport.send(message);

        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}

