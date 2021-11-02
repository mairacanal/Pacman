package pacman.gameElements;

public class Consumable {
    
    private int points;
    private int id;
    
    Consumable(int id){

        this.id = id;
        
        switch(id){
            
            case (GameConstants.PACDOT): {
                points = 10;
            }
            case (GameConstants.PILL): {
                points = 50;
            }
            case (GameConstants.FRUIT): {
                points = 200 * GameStatus.getLevel();
                this.id += GameStatus.getLevel() % 3;
            }
            
        }
    
    }

    public int getPoints() {
        
        return points;
        
    }

    public void setPoints(int points) {
        
        this.points = points;
        
    }

    public int getId() {
        
        return id;
        
    }

    public void setId(int id) {
        
        this.id = id;
        
    }    
    
}