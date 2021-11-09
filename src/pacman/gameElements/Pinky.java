package pacman.gameElements;

public class Pinky extends Ghost {
    
    public Pinky(Node node) {
        
        // definir identificaçao e velocidade
        super(node, GameConstants.PINKY, 0, GameConstants.LEFT);
        
    }    
    
    public void move() {

        if (isLeavingHome)
            leavingHome();
        else if (isChasing)
            chase();
        else if (isGoingHome)
            goingHome();

    }
    
}