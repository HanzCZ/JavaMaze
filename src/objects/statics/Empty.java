package objects.statics;
import objects.Object;
/**
 *
 * @author Honza
 */
public class Empty extends Object {
    public Empty(String name){
    	super(name);
    }

    public boolean open(){
    	return true;
    }
    
    public boolean canSeize(){
    	return true;
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