package pacman.gameElements;

import pacman.engine.GameStatus;
/**
 * 
 */
public class Consumable {
    
    private int points;
    private int id;
    
    /**
     * 
     * @param id
     */
    public Consumable(int id) {

        this.id = id;
        
        switch (id){
            
            case (GameConstants.PACDOT): {
                points = 10;
                break;
            }
            case (GameConstants.PILL): {
                points = 50;
                break;
            }
            case (GameConstants.FRUIT): {
                points = 200 * GameStatus.getLevel();
                this.id += GameStatus.getLevel() % 3;
                break;
            }
            
        }
    
    }

    /**
     * 
     * @return
     */
    public int getPoints() {
        
        return points;
        
    }

    /**
     * 
     * @param points
     */
    public void setPoints(int points) {
        
        this.points = points;
        
    }

    /**
     * 
     * @return
     */
    public int getId() {
        
        return id;
        
    }

    /**
     * 
     * @param id
     */
    public void setId(int id) {
        
        this.id = id;
        
    }    
    
}