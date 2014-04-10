package maps;
/**
 *
 * @author Honza
 */
public class Head {
    private final int id;
    private Field field;
    private int keys;
    public boolean win;
    private int dir; //smer hlavy  1-W 2-N 3-E 4-S
    
    public int id(){
        return id;
    }
    public boolean equals(Head obj){
        return obj.id() == id;
    }
    public int hashCode(){
    	return id;
    } 
    //hw2
    public Head(int id, Field f){
        this.id = id;
        field = f;
        keys = 0;
        dir = 2; 
        win = true;
    }
    public Field seizedField(){
        return field;
    }
    public void addKeys(int n){
        keys+=n;
    }
    public int keys(){
        return keys;
    }
    public void printKeys(){
        System.out.print(keys);
    }
    public void turnLeft(){ //--
        if(dir == 1)
            dir = 4;
        else
            dir--;
    }
    public void turnRight(){ //--
        if(dir == 4)
            dir = 1;
        else
            dir++;
    }
    public Field next(){
        if(dir == 1){
            return field.WField();
        }            
        else if(dir == 2){
            return field.NField();
        }
        else if(dir == 3){
            return field.EField();
        }
        else{
            return field.SField();
        }
    }
    
    public boolean take(){
        Field next;
        next = next();
        
        if(next != null){
            if(next.canTaking()){
                keys++;
                return next.taking();
            }
        }

        return false;
    }
    public boolean open(){
        Field next;
        next = next();
        
        if(next != null){
            if(next.canBeOpen() && (keys > 0)){
                keys--;
                return next.open();
            }
        }
        return false;
    }
    public boolean moveClear(){
        Field prev = field;
        Field next;
        next = next();
         
        if((next != null) && next.canSeize() && (next.GetObject().GetName() != "k") && (next.GetObject().GetName() != "g")){
            field = next;
            if(field.seize(this)){ 
                    prev.leave();
                    if(field.GetObject().GetName() == "f")
                        win = true;
                    return true;        
            }
        }
        field = prev;
        return false;
    }    
    public boolean move(){
        Field prev = field;
        Field next;
        next = next();
        
        
        if(next != null){
            field = next;
            
            if(field.canSeize()){
                if(field.GetObject().GetName() == "k"){
                    keys++;
                }
                    
                if(field.seize(this)){
                    
                    prev.leave();
                    if(field.GetObject().GetName() == "f")
                        win = true;
                    return true;        
                }
            }
            else if(field.canBeOpen()){
                if(keys > 0){
                    keys--;
                    field.open();
                    field.seize(this);
                    prev.leave();
                    return true;
                }
            }
            
        }
        field = prev;
        return false;
    }
}
