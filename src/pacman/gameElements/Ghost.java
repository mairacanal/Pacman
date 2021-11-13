package pacman.gameElements;

import java.util.ArrayList;
import java.util.Random;

public abstract class Ghost extends Entity {

    protected boolean isChasing;
    protected boolean isLeavingHome;
    protected boolean isGoingHome;
    
    Ghost(Node node, int type, int speed, int direction) {
        
        super(node, type, speed, direction);
    
    }

    private void moveNodeByDistance(String label, ArrayList<Integer> ids) {

        ArrayList<Node> nodes = this.node.getNodes();
        Node nextNode = null;

        for (Node node : nodes) {

            if (node.notForbiddenId(ids) && nextNode == null)
                nextNode = node;
            else if (node.notForbiddenId(ids) && nextNode.getDistance(label) > node.getDistance(label)) 
                nextNode = node;

        }

        this.node.removeEntity(this);
        this.node = nextNode;
        this.node.addEntity(this);

    }

    protected void leavingHome() {

        ArrayList<Integer> id = new ArrayList<>();

        id.add(GameConstants.BLOCKED);

        moveNodeByDistance("ghostSidewalk", id);

        if (this.node.getDistance("ghostSidewalk") == 0) {

            isLeavingHome = false;
            isChasing = true;

        }

    }

    protected void goingHome() {

    }

    protected void chase() {

        ArrayList<Integer> id = new ArrayList<>();

        id.add(GameConstants.BLOCKED);
        id.add(GameConstants.GATE);

        moveNodeByDistance("pacman", id);

    }

    protected void random() {

        Random rand = new Random();
        Node previousNode = node;
        ArrayList<Node> nodes = node.getNodes();
        ArrayList<Integer> id = new ArrayList<>();
        int newDirection;

        id.add(GameConstants.BLOCKED);
        id.add(GameConstants.GATE);

        do {

            newDirection = rand.nextInt(4);
            node = nodes.get(newDirection);

        } while (!node.notForbiddenId(id) || newDirection == GameConstants.oppositeDirection(direction));

        this.direction = newDirection;
        previousNode.removeEntity(this);
        this.node.addEntity(this);

    }
    
    public void born() {

        isLeavingHome = true;
        isChasing = false;
        isGoingHome = false;

    }
    
    public void die() {
        
        isLeavingHome = false;
        isChasing = false;
        isGoingHome = true;

    }
    
}
