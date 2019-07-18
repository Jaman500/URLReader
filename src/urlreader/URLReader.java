/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urlreader;

/**
 *
 * @author jasonfujii
 */
import java.net.*;
import java.io.*;
import java.util.*;
public class URLReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        System.out.println("This is my attempt to open and read from a website");
        
        //creating a String Builder to catch what is in the website
        StringBuilder text = new StringBuilder();
        //a String is added to take in the website one line at a time and add it to stringbuilder one at a time
        String line = new String();
        //create the url object
        URL test = new URL("https://www.hackerrank.com/dashboard");
        //open the connection 
        URLConnection testConnection = test.openConnection();
        //InputStreamReader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(testConnection.getInputStream()));
        //while there is still something to be read, line equals that next line
        while((line = bufferedReader.readLine()) != null)
        {
            //add the line to the stringbuilder
            text.append(line + "\n");
        }
        //close the buffered reader now
        bufferedReader.close();
        
        //print out the line
        System.out.println(text);
        
        // TODO code application logic here
        
        /*URL oracle = new URL("http://www.oracle.com/");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));
        
        System.out.println("this works");
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
        System.out.println("this works 2");*/
    }
    
}
