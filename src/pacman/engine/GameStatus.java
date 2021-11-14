package pacman.engine;

public class GameStatus {
    
    static private int level = 1;
    static private int points = 0;
    static private int lifes = 3;
    static private int pacdots = 0;
    static private boolean eatableGhosts = false;
    static private boolean resetGame = false;
    static private boolean nextLevel = false;
    static private boolean gameOver = false;

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
    
    }

    /**
     * 
     */
    public static void resetPacdots() {

        GameStatus.pacdots = 0;

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
    
    /**
     * 
     * @return
     */
    public static boolean isResetGame() {
    
        return resetGame;
    
    }

    /**
     * 
     * @param resetGame
     */
    public static void setResetGame(boolean resetGame) {
    
        GameStatus.resetGame = resetGame;
    
    }

    /**
     * 
     * @return
     */
    public static boolean isNextLevel() {
    
        return nextLevel;
    
    }

    /**
     * 
     * @param gameOver
     */
    public static void setNextLevel(boolean nextLevel) {
    
        GameStatus.nextLevel = nextLevel;
    
    }

    /**
     * 
     * @return
     */
    public static boolean isGameOver() {
    
        return gameOver;
    
    }

    /**
     * 
     * @param gameOver
     */
    public static void setGameOver(boolean gameOver) {
    
        GameStatus.gameOver = gameOver;

    }
    

    /**
     * 
     */
    public static void resetFlags()  {

        resetGame = false;
        nextLevel = false;
        gameOver = false;

    }

}
