package objects.statics;
import objects.Object;
/**
 *
 * @author Honza
 */
public class Wall extends Object {
    public Wall(String name){
    	super(name);
    }

    public boolean open(){
    	return false;
    }
    
    public boolean canSeize(){
    	return false;
    }   
    public boolean canBeOpen(){
        return false;
    }
    public boolean canBeTaken(){
        return false;
    }
    public boolean taken(){
        return false;
    }    
}
