package pacman.gameElements;

public class Inky extends Ghost {

    public Inky(Node node) {
        
        // definir identificaçao e velocidade
        super(node, GameConstants.INKY, 0, GameConstants.RIGHT);
        
    }
    
    public void move() {

        if (isLeavingHome)
            leavingHome();
        else if (isChasing)
            random();
        else if (isGoingHome)
            goingHome();

    }
    
}
