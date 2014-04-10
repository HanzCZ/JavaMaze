/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;


import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import maps.Container;
import maps.Map;
import fileReader.*;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Honza
 */
public class Server{
   private Map map;
   
   public Server()throws IOException {	
        Container container; 
        Map map;
        container = new Container("./lib/maps");
        
        map = loadMap("simple1010.txt");
        map = quitMap();
   }
   
   
   /*public static void main(String[] args) throws IOException {	
        Container container; 
        Map map;
        container = new Container("./lib/maps");
        //container.printMapsNames(); //vypise seznam map
        //map = loadMap("simple1010.txt");
        //map = quitMap();
        //map.createHead(1);        //vytvori hrace v levem hornim rohu
        //map.head.turnRight();     //otoceni hrace doprava
        //map.head.turnLeft();      //otoceni hrace doleva
        //map.head.move();          //pohyb ktery bere klice a otevira brany
        //map.head.take();          //vziti klice
        //map.head.moveClear();     //pohyb ktery se zastavi pred klicem a branou   
        //map.head.open();          //otevreni brany
        //map.head.printKeys();     //vypise pocet klicu hrace
        //printMap(map);           //tisk mapy
        
   }*/
    public static Map loadMap(String fileName) throws IOException{
        String mapka = readFile(fileName);
        Map mapHelp = new Map(fileName,mapka);
        return mapHelp;
    }
    public static Map quitMap(){
        return null;
    }  
    public static boolean printMap(Map map){
        if(map != null){
            map.printMap();
            return true;
        }
        else{
            return false;
        }
           
    }
   
    private static String readFile( String file ) throws IOException {
    BufferedReader reader = new BufferedReader( new FileReader ("./lib/maps/"+file));
    String         line = null;
    StringBuilder  stringBuilder = new StringBuilder();
    String         ls = System.getProperty("line.separator");

    while( ( line = reader.readLine() ) != null ) {
        stringBuilder.append( line );
        stringBuilder.append( ls );
    }

    return stringBuilder.toString();
}
}