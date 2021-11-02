package pacman.render;

import pacman.gameElements.GameConstants;
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
        
        this.pallete.put(GameConstants.PATH," ");
        this.pallete.put(GameConstants.BLOCKED,"▓▓");
        this.pallete.put(GameConstants.PACMAN,"¢");
        this.pallete.put(GameConstants.BLINKY,"B");
        this.pallete.put(GameConstants.PINKY,"P");
        this.pallete.put(GameConstants.INKY,"K");
        this.pallete.put(GameConstants.CLYDE,"C");
        this.pallete.put(GameConstants.PACDOT,"·");
        this.pallete.put(GameConstants.PILL,"¤");
        this.pallete.put(GameConstants.FRUIT,"×");
        this.pallete.put(23,"×");
        this.pallete.put(24,"×");
        this.pallete.put(GameConstants.HOME," ");
        this.pallete.put(GameConstants.GATE,"-");        
        
    }
    
    public void drawMap(){
        
        for (int i = 0; i < GameConstants.BOARD_VERTICAL; i++){
            
            for (int j = 0; j < GameConstants.BOARD_HORIZONTAL; j++){
                
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
