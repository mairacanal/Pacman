package pacman.gameElements;

public abstract class Entity {
    
    protected Node node;
    protected int type;
    protected int speed;
    
    Entity(Node node, int type, int speed) {
        
        this.node = node;
        this.type = type;
        this.speed = speed;
        
    }

    abstract public void move();
    abstract public void born();
    abstract public void die();
    
}
