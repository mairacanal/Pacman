package pacman.gameElements;

public class GameStatus {
    
    static private int level;
    static private int points;
    static private int lifes;
    static private int pacdots;
    static private boolean eatableGhosts;
    
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

    public static int getLevel() {
        
        return level;
    
    }

    public static void nextLevel() {
    
        level++;
    
    }

    public static int getPoints() {
    
        return points;
    
    }

    public static void addPoints(int points) {
    
        GameStatus.points += points;
    
    }

    public static int getLifes() {
        
        return lifes;
    
    }

    public static void addLife() {
    
        lifes++;
    
    }
    
    public static void loseLife() {
    
        lifes--;
    
    }

    public static int getPacdots() {
    
        return pacdots;
    
    }
    
    public static void addPacdots(int pacdots) {
    
        GameStatus.pacdots += pacdots;
    
    }

    public static boolean isEatableGhosts() {
    
        return eatableGhosts;
    
    }

    public static void setEatableGhosts(boolean eatableGhosts) {
    
        GameStatus.eatableGhosts = eatableGhosts;
    
    }
    
}
