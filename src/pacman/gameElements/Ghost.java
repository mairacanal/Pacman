package pacman.gameElements;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 */
public abstract class Ghost extends Entity {

    protected boolean isChasing;
    protected boolean isLeavingHome;
    protected boolean isGoingHome;
    
    /**
     * 
     * @param currentNode
     * @param type
     * @param speed
     * @param direction
     */
    Ghost(Node currentNode, int type, int speed, int direction) {
        
        super(currentNode, type, speed, direction);
    
    }

    /**
     * 
     * @param label
     * @param ids
     */
    private void moveNodeByDistance(String label, ArrayList<Integer> ids) {

        ArrayList<Node> currentNodes = currentNode.getNodes();
        Node nextNode = null;

        for (Node currentNode : currentNodes) {

            if (currentNode.notForbiddenId(ids) && nextNode == null)
                nextNode = currentNode;
            else if (currentNode.notForbiddenId(ids) && nextNode.getDistance(label) > currentNode.getDistance(label)) 
                nextNode = currentNode;

        }

        currentNode.removeEntity(this);
        currentNode = nextNode;
        currentNode.addEntity(this);

    }

    /**
     * 
     */
    protected void leavingHome() {

        ArrayList<Integer> id = new ArrayList<>();

        id.add(GameConstants.BLOCKED);

        moveNodeByDistance("ghostSidewalk", id);

        if (currentNode.getDistance("ghostSidewalk") == 0) {

            isLeavingHome = false;
            isChasing = true;

        }

    }

    /**
     * 
     */
    protected void goingHome() {

    }

    /**
     * 
     */
    protected void chase() {

        ArrayList<Integer> id = new ArrayList<>();

        id.add(GameConstants.BLOCKED);
        id.add(GameConstants.GATE);

        moveNodeByDistance("pacman", id);

    }

    /**
     * 
     */
    protected void random() {

        Random rand = new Random();
        Node previousNode = currentNode;
        ArrayList<Node> currentNodes = currentNode.getNodes();
        ArrayList<Integer> id = new ArrayList<>();
        int newDirection;

        id.add(GameConstants.BLOCKED);
        id.add(GameConstants.GATE);

        do {

            newDirection = rand.nextInt(4);
            currentNode = currentNodes.get(newDirection);

        } while (!currentNode.notForbiddenId(id) || newDirection == GameConstants.oppositeDirection(direction));

        direction = newDirection;
        previousNode.removeEntity(this);
        currentNode.addEntity(this);

    }
    
    /**
     * 
     */
    public void born() {

        isLeavingHome = true;
        isChasing = false;
        isGoingHome = false;        
        
        currentNode.removeEntity(this);
        initialNode.addEntity(this);
        currentNode = initialNode;

    }
    
    /**
     * 
     */
    public void die() {
        
        isLeavingHome = false;
        isChasing = false;
        isGoingHome = true;

    }
    
}
