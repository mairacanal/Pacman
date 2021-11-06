package pacman.gameElements;

public abstract class Ghost extends Entity {
    
    Ghost(Node node, int type, int speed) {
        
        super(node, type, speed);
    
    }
    
    public void born() {

    }
    
    public void die() {
        
    }
    
}
