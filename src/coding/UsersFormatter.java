/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coding;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author oshrat
 * 
 * This class is able to load a users JSON file,
 * reformat this user data into a `username:password` structure
 * and write it back into a file
 * 
 */
public class UsersFormatter {
    private final JSONParser parser;
    private final JSONObject reformatedUsers;
    private JSONArray usersFromFile;

    public UsersFormatter() {
        this.parser = new JSONParser();
        this.reformatedUsers = new JSONObject();
    }
    
    /**
    * @param usersFilePath (String) - the path for the JSON file to load from
    * @throws IOException | ParseException
    * 
    * The method converts our users JSON file into a JSONArray structure 
    * we can later manipulate
    */
    public void readFromFile(String usersFilePath) throws IOException, ParseException {       
        this.usersFromFile = (JSONArray) parser.parse(new FileReader(usersFilePath));
    }
    
    /**
    * @return JSONObject
    * 
    * The method iterates over the JSONArray pulled from the given file
    * and reformat the original data into a `username:password` structure.
    */
    public JSONObject reformatUsers() {
        JSONArray usersByName = new JSONArray();
        
        // Iterating over the users JSONArray
        for (int loop_index = 0; loop_index < this.usersFromFile.size(); loop_index++) {
            // Getting each user JSONObject
            JSONObject Obj = (JSONObject) this.usersFromFile.get(loop_index);

            // Converting the JSONObject into a structured String (username: password)
            // Adding this json structured string into our own JSONArray
            usersByName.add(Obj.get("username").toString() + ":" + Obj.get("password").toString().hashCode());
        }
        
        // Putting our reformated JSONArray into a new key (users) inside a final JSONObject
        this.reformatedUsers.put("users", usersByName);
        
        return this.reformatedUsers;
    }
    
    /**
    * @param newFilePath (String) - the path for the file to write into
    * @throws IOException
    * 
    * The method writes the reformatted users data into a given file path
    */
    public void writeIntoFile(String newFilePath) throws IOException {      
        FileWriter file = new FileWriter(newFilePath);
        file.write(this.reformatedUsers.toJSONString());
        file.close();
    }
}
