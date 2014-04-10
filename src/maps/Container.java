package maps;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Honza
 */
public class Container {
   private int number;
   private Map map[];
   final File folder;
   private File files[];   
   private ArrayList<String> list;
   
    public void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                //listFilesForFolder(fileEntry);
            } else {
                list.add(fileEntry.getName());
            }
        }
    }

   public void printMapsNames(){
        for (String item : list) {   
            System.out.println(item);
        }
   }


   //pri inicializaci kontejneru se zadava pouze cesta do adresare s priklady
   public Container(String Path){
       number = 0;
       folder = new File(Path);
       list = new ArrayList<>();       
       listFilesForFolder(folder);
   }
   
   public boolean LoadMap(){
       //metoda nacte mapy ze souboru
       return true;
   }
}
