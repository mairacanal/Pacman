package pacman.gameElements;

/**
 * 
 */
public class Pinky extends Ghost {
    
    /**
     * 
     * @param node
     */
    public Pinky(Node node) {
        
        // definir velocidade
        super(node, GameConstants.PINKY, 0, GameConstants.LEFT);
        
    }    
    
    /**
     * 
     */
    public void move() {

        if (isLeavingHome)
            leavingHome();
        else if (isChasing)
            chase();
        else if (isGoingHome)
            goingHome();

    }
    
}