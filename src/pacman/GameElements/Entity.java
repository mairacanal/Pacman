package pacman.GameElements;

public abstract class Entity {

    private Node node;
    private int type;
    private int speed;

    abstract public void move();
    abstract public void born();
    abstract public void die();
    
}
