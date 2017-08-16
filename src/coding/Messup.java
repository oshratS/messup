package coding;

import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Messup {
    static String USERS_JSON_FILE = "src/coding/users.json";
    static String USERS_TEXT_FILE = "src/coding/users.txt";
    
    public static void main(String[] args) {
        try {
            UsersFormatter frmt = new UsersFormatter(); 
            
            // Reading the users from our JSONFile
            frmt.readFromFile(USERS_JSON_FILE);
            
            // reformatting our users into a better structure
            JSONObject reformatedUsers = frmt.reformatUsers();
 
            // Writing our reformatted data into a text file
            frmt.writeIntoFile(USERS_TEXT_FILE);
 
            System.out.println("\nJSON Object: " + reformatedUsers);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
