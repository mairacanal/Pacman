/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacman.gameElements;

/**
 *
 * @author mairacanal
 */
public abstract class Ghost extends Entity {
    
    Ghost(Node node, int type, int speed) {
        
        super(node, type, speed);
    
    }
    
    public void born() {
        
    }
    
    public void die() {
        
    }
    
}
