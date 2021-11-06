package pacman.gameElements;

import java.util.ArrayList;
import java.util.HashMap;

public class Node {
    
    private ArrayList<Node> nodes;
    private ArrayList<Entity> entities;
    private HashMap<String, Integer> distances;
    private int id;    
    private Consumable consumable;
    private boolean canWalk;
    private int status;

    public Node(int id) {

        this.id = id;
        this.consumable = null;
        this.canWalk = (id != GameConstants.BLOCKED); // TODO: analisar como lidar com portao
        this.nodes =  new ArrayList<>();
        this.entities =  new ArrayList<>();
        this.distances = new HashMap<>();
        this.status = -1;

    }
    
    public Node(int id, Consumable consumable){
        
        this.id = id;
        this.consumable = consumable;
        this.canWalk = true;
        this.nodes =  new ArrayList<>();
        this.entities =  new ArrayList<>();
        this.distances = new HashMap<>();
        this.status = -1;
    
    }
    
    void connect(Node other){
        
        nodes.add(other);
    
    }

    public ArrayList<Node> getNodes() {
        
        return nodes;
    
    }

    public void setNodes(ArrayList<Node> nodes) {
        
        this.nodes = nodes;
        
    }

    public ArrayList<Entity> getEntities() {
        
        return entities;
        
    }

    public void setEntities(ArrayList<Entity> entities) {
        
        this.entities = entities;
        
    }

    public void addEntity(Entity entity) {

        this.entities.add(entity);

    }

    public void removeEntity(Entity entity) {

        this.entities.remove(entity);

    }

    public int getDistance(String key) {
        
        return distances.get(key);
    
    }

    public void setDistance(String key, int distance) {
        
        distances.put(key, distance);
    
    }    

    public int getId() {
        
        return id;
        
    }

    public void setId(int id) {
        
        this.id = id;
        
    }

    public Consumable getConsumable() {
        
        return consumable;
        
    }

    public void setConsumable(Consumable consumable) {
        
        this.consumable = consumable;
        
    }

    public boolean isCanWalk() {
        
        return canWalk;
        
    }

    public void setCanWalk(boolean canWalk) {
        
        this.canWalk = canWalk;
        
    }

    public int getStatus() {
        
        return status;
        
    }

    public void setStatus(int status) {
        
        this.status = status;
        
    }
    
}
