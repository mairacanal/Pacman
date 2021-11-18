package pacman.gameElements;

/**
 * Classe que representa um elemento do jogo, o fantasma Inky 
 */
public class Inky extends Ghost {

    /**
     * TODO: definir a velocidade do fantasma
     * Construtor padrão da classe Inky
     * @param node Nó em que o fantasma nasce
     */
    public Inky(Node node) {
        
        super(node, GameConstants.INKY, 0, GameConstants.RIGHT);
        
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

    }
    
}
