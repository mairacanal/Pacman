package pacman.gameElements;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 */
public class Node {
    
    private ArrayList<Node> nodes;
    private ArrayList<Entity> entities;
    private HashMap<String, Integer> distances;
    private Consumable consumable;
    private int id;    
    private int status;

    /**
     * 
     * @param id
     */
    public Node(int id) {

        this.id = id;
        this.consumable = null;
        this.nodes =  new ArrayList<>();
        this.entities =  new ArrayList<>();
        this.distances = new HashMap<>();
        this.status = -1;

    }
    
    /**
     * 
     * @param id
     * @param consumable
     */
    public Node(int id, Consumable consumable) {
        
        this.id = id;
        this.consumable = consumable;
        this.nodes =  new ArrayList<>();
        this.entities =  new ArrayList<>();
        this.distances = new HashMap<>();
        this.status = -1;
    
    }
    
    /**
     * 
     * @param other
     */
    public void connect(Node other){
        
        nodes.add(other);
    
    }

    /**
     * 
     * @return
     */
    public ArrayList<Node> getNodes() {
        
        return nodes;
    
    }

    /**
     * 
     * @param nodes
     */
    public void setNodes(ArrayList<Node> nodes) {
        
        this.nodes = nodes;
        
    }

    /**
     * 
     * @return
     */
    public ArrayList<Entity> getEntities() {
        
        return entities;
        
    }

    /**
     * 
     * @param entities
     */
    public void setEntities(ArrayList<Entity> entities) {
        
        this.entities = entities;
        
    }

    /**
     * 
     * @param entity
     */
    public void addEntity(Entity entity) {

        this.entities.add(entity);

    }

    /**
     * 
     * @param entity
     */
    public void removeEntity(Entity entity) {

        this.entities.remove(entity);

    }
    
    /**
     * 
     * @return
     */
    public boolean hasPacman() {

        for (Entity entity : entities)
            if (entity.getId() == GameConstants.PACMAN)
                return true;

        return false;

    }

    /**
     * 
     * @return
     */
    public boolean hasGhost() {

        for (Entity entity : entities)
            if (entity.getId() >= GameConstants.BLINKY && entity.getId() <= GameConstants.CLYDE) 
                return true;

        return false;

    }

    /**
     * 
     * @param key
     * @return
     */
    public int getDistance(String key) {
        
        return distances.get(key);
    
    }

    /**
     * 
     * @param key
     * @param distance
     */
    public void setDistance(String key, int distance) {
        
        distances.put(key, distance);
    
    }    

    /**
     * 
     * @return
     */
    public int getId() {
        
        return id;
        
    }

    /**
     * 
     * @param forbiddenIds
     * @return
     */
    public boolean notForbiddenId(ArrayList<Integer> forbiddenIds) {

        for (int id : forbiddenIds)
            if (id == this.id)
                return false;

        return true;

    }

    /**
     * 
     * @return
     */
    public Consumable getConsumable() {
        
        return consumable;
        
    }

    /**
     * 
     * @param consumable
     */
    public void setConsumable(Consumable consumable) {
        
        this.consumable = consumable;
        
    }

    /**
     * 
     * @return
     */
    public int getStatus() {
        
        return status;
        
    }

    /**
     * 
     * @param status
     */
    public void setStatus(int status) {
        
        this.status = status;
        
    }
    
}
