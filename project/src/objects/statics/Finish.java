package objects.statics;
import objects.Object;
/**
 *asd
 * @author Honza
 */
public class Finish extends Object {
    public Finish(String name){
    	super(name);
    }

    public boolean open(){
    	return false;
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
    /*PRIDAT UKONCENI HRY*/
    /*PRIDAT LIMIT NA POUZE JEDEN CIL*/
}