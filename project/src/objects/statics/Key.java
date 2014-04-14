package objects.statics;
import objects.Object;
/**
 *
 * @authors Jan Hanák, Pavlína Bortlová
 */
public class Key extends Object {
    private boolean taken;
    public Key(String name){
    	super(name);
        taken = false;
    }

    public boolean open(){
    	return true;
    }
    public boolean taken(){
        if(taken == false){
            taken = true;
            return true;
        }    
        else
            return false;
    }
    
    public boolean canSeize(){
    	return true;
    }   
    public boolean canBeOpen(){
        return false;
    }
    public boolean canBeTaken(){
        if(taken == false)
            return true;
        else
            return false;
    }
    /*PRIDAT TEN KLICEK*/
}
