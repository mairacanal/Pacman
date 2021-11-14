package pacman.gameElements;

/**
 * 
 */
public class Clyde extends Ghost {
    
    /**
     * 
     * @param node
     */
    public Clyde (Node node) {
        
        // definir velocidade
        super(node, GameConstants.CLYDE, 0, GameConstants.LEFT);
        
    }
    
    /**
     * 
     */
    public void move() {

        if (isLeavingHome)
            leavingHome();
        else if (isChasing)
            random();
        else if (isGoingHome)
            goingHome();
        
    }
    
}