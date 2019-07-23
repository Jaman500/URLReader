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
        //a string Builder for the good stuff (stock data or anything else)
        StringBuilder data = new StringBuilder();
        //a String is added to take in the website one line at a time and add it to stringbuilder one at a time
        String line = new String();
        //create the url object
        URL test = new URL("https://money.cnn.com/data/markets/");
        //open the connection 
        URLConnection testConnection = test.openConnection();
        //InputStreamReader takes chars and turns them into strings (i think). Here, we wrap the reader into the bufferedreader
        //for efficiency
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(testConnection.getInputStream()));
        //make two strings to update line without effecting the code
        String one = new String(), two = new String();
        //while there is still something to be read, line equals that next line
        
        
        while((line = bufferedReader.readLine()) != null)
        {
            //add the line to the stringbuilder
            
            text.append(line + "\n");
            if(line.contains("stock-name"))
            {
                int num1, num2;
                num1 = line.indexOf("stock-name") + 12;
                
                
                
                one = line.substring(num1);
                num2 = one.indexOf("<");
                two = one.substring(0,num2);
                //+ 11, line.indexOf("<") - 1);
                //two = line.substring(line.indexOf("<") - 1);
                //data.append(line.substring(line.indexOf("stock-name")) + " - ");
                data.append(two + " - ");
            }
            else if(line.contains("stock-price"))
            {
                int num3, num4;
                String three, four;
                num3 = line.indexOf("stock-price") + 13;
                three = line.substring(num3);
                num4 = three.indexOf("<");
                four = three.substring(0, num4);
                //data.append(line.substring(line.indexOf("stock-price")) + "\n");
                data.append(four + "\n");
            }
        }
        //close the buffered reader now
        bufferedReader.close();
        
        //print out the line
        //System.out.println(text);
        //System.out.println("\n \n \n \n");
        System.out.println(data);
        
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
