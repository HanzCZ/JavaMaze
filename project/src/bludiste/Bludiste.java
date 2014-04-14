package bludiste;
import java.io.*;
import java.util.regex.*;


import maps.Map;
/**
 *
 * @authors Jan Hanák, Pavlína Bortlová
 * trida bludiste v sobe zabaluje logiku hry
 * mapu, hrace, policka a objekty nich
 */
public class Bludiste {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Map map = quitMap();
        
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
        //printMap(map);            //tisk mapy
        
        
        String command=null;
        boolean exit = false;
        //  prompt the user to enter their name

        //  open up standard input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //  read the username from the command-line; need to use try/catch with the
      //  readLine() method
        try {
           while(!exit){
                System.out.print("Command: ");    
                command = br.readLine();
                if(command.contains("game ")){
                    String param = command.substring(5);
                    map = loadMap(param);
                    map.createHead(1); 
                }
                else if(command.equals("show"))
                    printMap(map); 
                else if(command.equals("close")){
                    map = quitMap();
                    exit = true;
                }    
                else if(command.equals("step"))
                    if(map.head.moveClear()){
                        System.out.println("step: ok"); 
                        if(map.head.winner()){
                            System.out.println("VICTORY!!! HURAAYY");
                            exit = true;
                        }
                    }
                    else
                        System.out.println("step: false");  
                else if(command.equals("left")){
                    map.head.turnLeft();
                }
                else if(command.equals("right")){
                    map.head.turnRight();
                }    
                else if(command.equals("take")){
                    if(map.head.take())
                        System.out.println("take: ok");  
                    else
                        System.out.println("take: false");                    
                }
                else if(command.equals("open")){
                    if(map.head.open())
                        System.out.println("open: ok");  
                    else
                        System.out.println("open: false");                      
                }
                else if(command.equals("keys")){
                    map.head.printKeys();            
                }
                else{
                    System.out.println("unknown command\n");                      
                }
           }
        } catch (IOException ioe) {
           System.out.println("IO error trying to read command!");
           System.exit(1);
        }   
    }
    /*public Bludiste()throws IOException {	
        Container container; 
        Map map;
        container = new Container("./examples/maps");
        
        map = loadMap("simple1010.txt");
        map = quitMap();
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
    BufferedReader reader = new BufferedReader( new FileReader ("./examples/maps/"+file));
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
