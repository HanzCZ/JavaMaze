package objects;
import objects.statics.*;
/**
 * obsahuje rozsireni ktere urči o jaky typ objektu se jedna
 * 
 * @authors Jan Hanák, Pavlína Bortlová
 */
public abstract class Object {
    protected String name;
    public boolean seized;
    
    public Object(String name){
    	this.name = name;
        this.seized = false;
    } 
    public boolean seizing(){
        this.seized = true;
        if(this.name == "k")
            this.name = "t";
        else if(this.name == "g")
            this.name = "o";
        return true;
    }
    public boolean leaving(){
        this.seized = false;
        return true;
    }
    public boolean seizedBool(){
        return seized;
    }
    
    public abstract boolean canSeize();
    public abstract boolean taken();
    
    public abstract boolean open();
    public boolean opening(){
        if(this.name == "g"  && this.canBeOpen()){
            this.open();
            this.name = "o";
            return true;
        }
        else
            return false;
    }
    
    public boolean taking(){
        if((this.name == "k" ) && (this.taken())){
            this.name = "t";
            return true;
        }
        else
            return false;
    }
        
    
    public boolean equals(Object obj){
    	return name.equals(obj.GetName());
    }
    
    public String GetName(){
    	return name;
    }
    
    public int hashCode(){
    	return name.hashCode();
    }    
    //hw2
    public abstract boolean canBeOpen();
    public abstract boolean canBeTaken();
    
    public static Object create(String name){
        switch (name) {
            case "w":
                return new Wall(name);
            case "g":
                return new Gate(name);
            case "k":
                return new Key(name);
            case "f":
                return new Finish(name);
            case "p":
                return new Empty(name);
            default:
                return null;
        }
    } 
}