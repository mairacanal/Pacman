package pacman.gameElements;

/**
 * 
 */
public abstract class Entity {
    
    protected Node node;
    protected int id;
    protected int speed;
    protected int direction;
    
    /**
     * 
     * @param node
     * @param id
     * @param speed
     * @param direction
     */
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

    /**
     * 
     * @return
     */
    public int getId() {

        return id;

    }

    /**
     * 
     * @param id
     */
    public void setId(int id) {

        this.id = id;

    }

    /**
     * 
     * @return
     */
    public Node getNode() {

        return node;

    }

    /**
     * 
     * @param node
     */
    public void setNode(Node node) {

        this.node = node;

    }
    
}
