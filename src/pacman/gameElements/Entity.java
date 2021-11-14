package pacman.gameElements;

/**
 * 
 */
public abstract class Entity {
    
    protected Node currentNode;
    protected Node initialNode;
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
        
        this.currentNode = node;
        this.initialNode = node;
        this.id = id;
        this.speed = speed;
        this.direction = direction;

        this.currentNode.addEntity(this);
        
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

        return currentNode;

    }

    /**
     * 
     * @param node
     */
    public void setNode(Node node) {

        this.currentNode = node;

    }
    
}
