package in.deepaksood.servlet;

import in.deepaksood.databasehelper.DatabaseHelper;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by deepaksood619 on 22/6/16.
 */
@WebServlet(name = "UploadPictureServlet", urlPatterns = "/uploadpictureservlet")
public class UploadPictureServlet extends HttpServlet {

    private boolean isMultipart;
    private String filePath;
    private String statusPath;
    private int maxFileSize = 50 * 1024;
    private int maxMemSize = 4 * 1024;
    private File file ;

    public void init( ){
        // Get the file location where it would be stored.
        filePath = "/home/deepaksood619/IdeaProjects/OOPD_Project/web/profilepics/";
        statusPath = "/home/deepaksood619/IdeaProjects/OOPD_Project/web/statuspackage/";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userEmail = (String) request.getSession().getAttribute("USER_EMAIL");
        System.out.println("Email: "+userEmail);


        isMultipart = ServletFileUpload.isMultipartContent(request);
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter( );
        if( !isMultipart ){
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>No file uploaded</p>");
            out.println("</body>");
            out.println("</html>");
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);
        // Location to save data that is larger than maxMemSize.
        factory.setRepository(new File("/home/deepaksood619/Desktop/temp"));

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        // maximum file size to be uploaded.
        upload.setSizeMax( maxFileSize );

        try{
            // Parse the request to get file items.
            List fileItems = upload.parseRequest(request);

            // Process the uploaded file items
            Iterator i = fileItems.iterator();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            while ( i.hasNext () )
            {
                FileItem fi = (FileItem)i.next();
                if ( !fi.isFormField () )
                {
                    // Get the uploaded file parameters
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();
                    // Write the file

                    System.out.println("create");

                    System.out.println("useremail: "+userEmail);
                    String[] fileNameToSave = userEmail.split("\\.");

                    file = new File(filePath+fileNameToSave[0]+".jpg");
                    boolean create = file.createNewFile();

                    fi.write( file ) ;
                    System.out.println("file: "+file.getAbsolutePath());

                    File statusFile = new File(statusPath+fileNameToSave[0]+".txt");
                    boolean createFile = statusFile.createNewFile();

                    response.sendRedirect("homepage.jsp");
                }
            }
            out.println("</body>");
            out.println("</html>");
        }catch(Exception ex) {
            System.out.println(ex);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
