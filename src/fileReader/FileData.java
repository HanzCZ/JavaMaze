/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FileReader;

import java.io.IOException;

/**
 *
 * @author Honza
 */
public class FileData {

    public String FileData(String path) throws IOException {
       String file_name = "./lib/maps"+path;
       StringBuilder builder = new StringBuilder();
       try {
           ReadFile file = new ReadFile(file_name);
           String[] aryLines = file.OpenFile();
           
           int i;
           for(i=0; i<aryLines.length; i++){
               System.out.println(aryLines[i]);
           }
           
           
           for(String s : aryLines) {
                 builder.append(s);
           }
           return builder.toString();
       }
       catch (IOException e) {
           System.out.println( e.getMessage());
       }
       return builder.toString();
    }  
}
