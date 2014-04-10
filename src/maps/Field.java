/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maps;

import objects.Object;
/**
 *
 * @author Honza
 */
public class Field {
    private final int posX;
    private final int posY;
    private Object obj;
    private Head head;
    private Map map;

   
    public Field(Map map, int x, int y, String type){
        posX = x;
        posY = y;
        switch (type) {
            case "w":
                obj = Object.create(type);
                break;
            case "g":
                obj = Object.create(type);
                break;
            case "f":
                obj = Object.create(type);
                break;
            case "k":
                obj = Object.create(type);
                break;
            case "p":
                obj = Object.create(type);
                break;    
            default:
                obj = null;
                break;
        }
        head = null;
        this.map = map;
    }
    
    //prave policko
    public Field EField(){
        return map.fieldAt(posX+1, posY);
    }     
    
    //leve policko
    public Field WField(){
        return map.fieldAt(posX-1, posY);
    }     
    
    //horni policko
    public Field NField(){
        return map.fieldAt(posX, posY-1);
    }     
    
    //spodni policko
    public Field SField(){
        return map.fieldAt(posX, posY+1);
    }  
        
    public int positionX(){
    	return posX;
    }
        
    public int positionY(){
    	return posY;
    }
    public boolean seize(Head head){
	if(canSeize() == true){
            this.head = head;
            obj.seizing();
            return true;
	}
        else 
            return false;
    }
    public boolean canTaking(){
        if(obj.GetName() == "k")
            return true;
        else
            return false;
    }
    public boolean taking(){
        return obj.taking();
    }
    public boolean canBeOpen(){
        if(obj == null)
            return false;
        else
            return obj.canBeOpen();
    }
    
    public boolean canBeTaken(){
        if(obj == null)
            return false;
        else
            return obj.canBeTaken();
    }
    
    
    public Head leave(){
    	Head retHead;
    	obj.leaving();
    	if(head != null){
            retHead = head;
            head = null;
    	}
    	else 
            retHead = null;
    	
    	return retHead;
    }
    public boolean canSeize(){
	if(head == null){
	    if(obj == null) 
                return true;
            else if(obj != null && obj.canSeize()) 
                return true;
	}
        return false;
    }
    public boolean open(){
    	if(obj != null) 
            return obj.opening();
    	else 
            return false;
    }

    public Object GetObject(){
    	return obj;
    }
    public String GetName(){
        return obj.GetName();
    }
    public Head GetHead(){
        return head;
    }
}
