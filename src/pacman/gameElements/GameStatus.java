package pacman.gameElements;

public class GameStatus {
    
    static private int level = 1;
    static private int points = 0;
    static private int lifes = 3;
    static private int pacdots = 0;
    static private boolean eatableGhosts = false;

    /**
     * 
     * @return
     */
    public static int getLevel() {
        
        return level;
    
    }

    /**
     * 
     */
    public static void nextLevel() {
    
        level++;
    
    }

    /**
     * 
     * @return
     */
    public static int getPoints() {
    
        return points;
    
    }

    /**
     * 
     * @param points
     */
    public static void addPoints(int points) {
    
        GameStatus.points += points;
    
    }

    /**
     * 
     * @return
     */
    public static int getLifes() {
        
        return lifes;
    
    }

    /**
     * 
     */
    public static void addLife() {
    
        lifes++;
    
    }
    
    /**
     * 
     */
    public static void loseLife() {
    
        lifes--;
    
    }

    /**
     * 
     * @return
     */
    public static int getPacdots() {
    
        return pacdots;
    
    }
    
    /**
     * 
     * @param pacdots
     */
    public static void addPacdots(int pacdots) {
    
        GameStatus.pacdots += pacdots;
        GameStatus.points += pacdots * 10;
    
    }

    /**
     * 
     * @return
     */
    public static boolean isEatableGhosts() {
    
        return eatableGhosts;
    
    }

    /**
     * 
     * @param eatableGhosts
     */
    public static void setEatableGhosts(boolean eatableGhosts) {
    
        GameStatus.eatableGhosts = eatableGhosts;
    
    }
    
}
