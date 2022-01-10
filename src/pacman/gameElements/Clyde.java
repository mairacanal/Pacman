/**
 * @file Clyde.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman.gameElements;

/**
 * Classe que representa um elemento do jogo, o fantasma Clyde 
 */
public class Clyde extends Ghost {
    
    /**
     * TODO: definir a velocidade do fantasma
     * Construtor padrão da classe Clyde
     * @param node Nó em que o fantasma nasce
     */
    public Clyde (Node node) {
        
        super(node, GameConstants.CLYDE, 0, GameConstants.LEFT);
        
    }
    
    /**
     * Método que movimenta o fantasma de acordo do modo em que o
     * fantasma está, ou seja, se ele está saindo da casa, andando
     * aleatoriamente no tabuleiro ou voltando para casa.
     */
    public void move() {

        if (isLeavingHome)
            leavingHome();
        else if (isChasing)
            random();
        else if (isGoingHome)
            goingHome();
        else if (isRunningAway){
            runAway();
        }
        
    }
    
}