package maps;

public class Map {
    
    private final String name;
    private int x;
    private int y;
    private Field field[][];
    public Head head;
    
    public Map(String name, String format){

        int length = name.length();

        String testX =name.substring(length-8,length-6);
        String testY =name.substring(length-6,length-4);
        
        this.name = name;
        this.x = Integer.parseInt(testX);
        this.y = Integer.parseInt(testY); 

        int posX = 0;
        int posY = 0;

        field = new Field[x][y];





        for(char ch: format.toCharArray()){
            switch (ch) {
                case 'w':
                    field[posX][posY] = new Field(this, posX, posY, "w");
                    break;
                case 'g':
                    field[posX][posY] = new Field(this, posX, posY, "g");
                    break;
                case 'f':
                    field[posX][posY] = new Field(this, posX, posY, "f");
                    break;
                case 'k':
                    field[posX][posY] = new Field(this, posX, posY, "k");
                    break;   
                case 'p':
                    field[posX][posY] = new Field(this, posX, posY, "p");
                    break; 
                case ' ':
                    posX++;
                    break;
                case '\n':
                    posY++;
                    posX=0;
                    break;
                default:
                    break;
            }      
        }
    }
    
    public Field fieldAt(int posX,int posY){
        if((posX <= this.x) || (posY <= this.y))
            return field[posX][posY];
        else
            return null;
    }
    public Head createHead(int i){
        for(int b = 0; b < y; b++){
            for(int a = 0; a < x; a++){
                if(field[a][b].canSeize() == true){
                    head = new Head(i, field[a][b]);
		field[a][b].seize(head);
		return head;
                }
            }
        }
	return null;
    }
    public void printMap(){
        
            for(int b = 0; b < y; b++){
                for(int a = 0; a < x; a++){ 
                       if(field[a][b].GetObject().seizedBool()){
                            System.out.print(field[a][b].GetHead().id());
                       }
                       else{
                            System.out.print(field[a][b].GetObject().GetName());
                       }
                       if(a == 9)
                            System.out.print("\n");
                }
            }
            
    }
}    
