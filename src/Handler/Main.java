package Handler;

import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        try {
            INI iniFileHandler = new INI(new File("C:\\Users\\Shahrom\\IdeaProjects\\INI file handler\\src\\Handler\\file.ini"));

            System.out.println(iniFileHandler.get(Integer.class, "PlentySockMaxQSize", "[DEBUG]"));
        } catch (InvalidFormattingException | IOException  e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
