/**
 * @file Blinky.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman.gameElements;

import pacman.engine.GameStatus;

/**
 * Classe que representa um elemento do jogo, o fantasma Blinky 
 */
public class Blinky extends Ghost {
    
    /**
     * Construtor padrão da classe Blinky
     * @param node Nó em que o fantasma nasce
     */
    public Blinky(Node node) {
        
        super(node, GameConstants.BLINKY, 50, GameConstants.RIGHT);
        
    }
    
    /**
     * Método que movimenta o fantasma de acordo do modo em que o
     * fantasma está, ou seja, se ele está saindo da casa, perseguindo
     * o Pacman ou voltando para casa.
     */
    @Override
    public void move() {
        
        moveCounter += speed + GameStatus.getPoints()/400;        
        
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
