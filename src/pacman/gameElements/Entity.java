package pacman.gameElements;

public abstract class Entity {
    
    protected Node node;
    protected int id;
    protected int speed;
    protected int direction;
    
    Entity(Node node, int id, int speed, int direction) {
        
        this.node = node;
        this.id = id;
        this.speed = speed;
        this.direction = direction;

        this.node.addEntity(this);
        
    }

    abstract public void move();
    abstract public void born();
    abstract public void die();

    public int getId() {

        return id;

    }

    public Node getNode() {

        return node;

    }
    
}
