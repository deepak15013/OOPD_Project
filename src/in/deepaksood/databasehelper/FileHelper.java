package in.deepaksood.databasehelper;

import java.io.*;

/**
 * Created by deepaksood619 on 25/6/16.
 */
public class FileHelper {

    private static final String PATH = "/home/deepaksood619/IdeaProjects/OOPD_Project/web/statuspackage/";

    private static FileHelper sharedInstance;
    public static FileHelper shared() {
        if(sharedInstance == null) {
            sharedInstance = new FileHelper();
        }
        return sharedInstance;
    }

    public void addStatus(String email, String newPost) {
        String fileName = email.split("\\.")[0] + ".txt";

        File textFile = new File(PATH+fileName);

        try {
            RandomAccessFile file = new RandomAccessFile(textFile, "rws");
            byte[] text = new byte[(int) file.length()];
            file.readFully(text);
            file.seek(0);
            file.writeBytes(newPost+"\n");
            file.write(text);
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
