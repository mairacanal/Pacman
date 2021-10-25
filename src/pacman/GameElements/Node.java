package pacman.GameElements;

import java.util.ArrayList;

public class Node {

    private ArrayList<Entity> entities;
    private Node[] nodes;
    private Consumable consumable;
    private int id;

    Node(ArrayList<Entity> entities, Node[] nodes, Consumable consumable, int id) {

        this.entities = entities;
        this.nodes = nodes;
        this.consumable = consumable;
        this.id = id;

    }

    void connect() {

    }
    
}
