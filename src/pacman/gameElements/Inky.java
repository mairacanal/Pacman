/**
 * @file Inky.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman.gameElements;

/**
 * Classe que representa um elemento do jogo, o fantasma Inky 
 */
public class Inky extends Ghost {

    /**
     * Construtor padrão da classe Inky
     * @param node Nó em que o fantasma nasce
     */
    public Inky(Node node) {
        
        super(node, GameConstants.INKY, 80, GameConstants.RIGHT);
        
    }
    
    /**
     * Método que movimenta o fantasma de acordo do modo em que o
     * fantasma está, ou seja, se ele está saindo da casa, andando
     * aleatoriamente no tabuleiro ou voltando para casa.
     */
    @Override
    public void move() {
        
        moveCounter += speed;
        
        if (moveCounter >= 1000) {
            
            if (isLeavingHome)
                leavingHome();
            else if (isChasing)
                random();
            else if (isGoingHome)
                goingHome();
            else if (isRunningAway){
                runAway();
            }
            
            moveCounter = 0;
            
        }

    }
    
}
