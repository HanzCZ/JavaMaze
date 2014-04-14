package objects.statics;
import objects.Object;
/**
 *
 * @authors Jan Hanák, Pavlína Bortlová
 */
public class Gate extends Object{
    private boolean open;
    
    public Gate(String name){
        super(name);
        open = false;
    }

    public boolean open(){
	if(open == true) 
            return false;
        else{
            open = true;
            return true;
        }
    }   

    public boolean canSeize(){
        return open == true;
    }
    
    public boolean equals(Object obj){
        return open == obj.canSeize();
    }   
    
    
    public boolean canBeOpen(){
        return open == false;
    }
    public boolean canBeTaken(){
        return false;
    }
    public boolean taken(){
        return false;
    }
}