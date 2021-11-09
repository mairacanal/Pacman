package pacman.gameElements;

public class Blinky extends Ghost {
    
    public Blinky(Node node) {
        
        // definir velocidade
        super(node, GameConstants.BLINKY, 0, GameConstants.RIGHT);
        
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
