package pacman.engine;

public class GameStatus {
    
    private int level;
    private int points;
    private int lifes;
    private int pacdots;
    private boolean eatableGhosts;
    
    private static GameStatus instance;
     
    private GameStatus(){                       
        
        level = 1;
        points = 0;
        lifes = 3;
        pacdots = 0;
        eatableGhosts = false;
        
    }
     
    public static GameStatus getInstance() {
        
        if(instance == null){
            instance = new GameStatus();
        }
        
        return instance;
        
    }

    public int getLevel() {
        
        return level;
    
    }

    public void nextLevel() {
    
        level++;
    
    }

    public int getPoints() {
    
        return points;
    
    }

    public void addPoints(int points) {
    
        this.points += points;
    
    }

    public int getLifes() {
        
        return lifes;
    
    }

    public void addLife() {
    
        lifes++;
    
    }
    
    public void loseLife() {
    
        lifes--;
    
    }

    public int getPacdots() {
    
        return pacdots;
    
    }

    public void addPacdots(int pacdots) {
    
        this.pacdots += pacdots;
    
    }

    public boolean isEatableGhosts() {
    
        return eatableGhosts;
    
    }

    public void setEatableGhosts(boolean eatableGhosts) {
    
        this.eatableGhosts = eatableGhosts;
    
    }
    
}
