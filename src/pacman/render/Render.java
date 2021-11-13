package pacman.render;

import pacman.gameElements.GameConstants;
import pacman.gameElements.GameStatus;
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
        
        this.pallete.put(GameConstants.PATH,"  ");
        this.pallete.put(GameConstants.BLOCKED,"▓▓");
        this.pallete.put(GameConstants.PACMAN,"¢ ");
        this.pallete.put(GameConstants.BLINKY,"B ");
        this.pallete.put(GameConstants.PINKY,"P ");
        this.pallete.put(GameConstants.INKY,"K ");
        this.pallete.put(GameConstants.CLYDE,"C ");
        this.pallete.put(GameConstants.PACDOT,"· ");
        this.pallete.put(GameConstants.PILL,"¤ ");
        this.pallete.put(GameConstants.FRUIT,"× ");
        this.pallete.put(23,"× ");
        this.pallete.put(24,"× ");
        this.pallete.put(GameConstants.HOME,"  ");
        this.pallete.put(GameConstants.GATE,"- ");        
        
    }
    
    public void drawMap(){

        for (int i = 0; i < GameConstants.BOARD_VERTICAL; i++){
            
            for (int j = 0; j < GameConstants.BOARD_HORIZONTAL; j++){
                
                Node current = map.getNode(i,j);
                
                if (!current.getEntities().isEmpty())
                    System.out.print(this.pallete.get(current.getEntities().get(0).getId()));
                else if (current.getConsumable() != null)
                    System.out.print(this.pallete.get(current.getConsumable().getId()));
                else if (current.getId() == GameConstants.BLOCKED || current.getId() == GameConstants.GATE)
                    System.out.print(this.pallete.get(current.getId()));
                else        
                    System.out.print("  ");
                    // System.out.print(String.format("%02d", current.getDistance("ghostSidewalk")));
                
            }
            
            System.out.println();
            
        }  
        
        System.out.println("Points: " + GameStatus.getPoints());

    }
    
}
