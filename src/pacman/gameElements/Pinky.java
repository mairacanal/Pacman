/**
 * @file Pinky.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman.gameElements;

/**
 * Classe que representa um elemento do jogo, o fantasma Pinky 
 */
public class Pinky extends Ghost {
    
    /**
     * Construtor padrão da classe Pinky
     * @param node Nó em que o fantasma nasce
     */
    public Pinky(Node node) {
        
        super(node, GameConstants.PINKY, 80, GameConstants.LEFT);
        
    }    
    
    /**
     * Método que movimenta o fantasma de acordo do modo em que o
     * fantasma está, ou seja, se ele está saindo da casa, perseguindo
     * o Pacman ou voltando para casa.
     */
    public void move() {
        
        moveCounter += speed;
        
        if (moveCounter >= 1000) {
            
            if (isLeavingHome)
                leavingHome();
            else if (isChasing)
                chase();
            else if (isGoingHome)
                goingHome();
            else if (isRunningAway){
                runAway();
            }
            
            moveCounter = 0;
            
        }
        
    }
    
}