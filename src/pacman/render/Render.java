package pacman.render;

import pacman.gameElements.Map;
import pacman.gameElements.Node;
import java.util.HashMap;

public class Render {
    
    private Map map;
    private HashMap<Integer, String> pallete;
    
    public Render(Map map) {
        
        this.map = map;
        this.pallete = new HashMap<>();
        this.pickPallete();
    
    }
    
    private void pickPallete(){
        
        this.pallete.put(0," ");
        this.pallete.put(1,"▓▓");
        this.pallete.put(10,"¢");
        this.pallete.put(11,"B");
        this.pallete.put(12,"P");
        this.pallete.put(13,"K");
        this.pallete.put(14,"C");
        this.pallete.put(20,"·");
        this.pallete.put(21,"¤");
        this.pallete.put(22,"×");
        this.pallete.put(23,"×");
        this.pallete.put(24,"×");
        this.pallete.put(30," ");
        this.pallete.put(31,"-");        
        
    }
    
    public void drawMap(){
        
        for (int i = 0; i < 31; i++){
            
            for (int j = 0; j < 28; j++){
                
                Node current = map.getNode(i,j);
                
                //int distance = this.map.nodes[i][j].distance;
                if (current.getId() == 1)
                    System.out.print(this.pallete.get(current.getId()));
                else {
                    
                    int distance = current.getDistance("pacman");
                    System.out.print(String.format("%02d",distance));
                    
                }
                
            }
            
            System.out.println();
            
        }  
        
    }
    
}
