/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacman.gameElements;

/**
 *
 * @author mairacanal
 */
public abstract class Entity {
    
    private Node node;
    private int type;
    private int speed;
    
    Entity(Node node, int type, int speed) {
        
        this.node = node;
        this.type = type;
        this.speed = speed;
        
    }

    abstract public void move();
    abstract public void born();
    abstract public void die();
    
}
