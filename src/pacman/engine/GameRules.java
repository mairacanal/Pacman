package pacman.engine;

import pacman.gameElements.GameConstants;
import pacman.gameElements.Map;
import pacman.gameElements.Node;

/**
 * Classe que agrupa todas as regras do jogo, contabilizando os pontos do usuário, as vidas
 * e o nível do jogo.
 */
public class GameRules {

    private Map map;
    private Node[][] nodes;

    /**
     * Construtor padrão da classe GameRules
     * @param map Mapa do jogo, compartilhado entre a Engine e o Render
     */
    GameRules(Map map) {

        this.map = map;

    }
    
    /**
     * Método para execução de todas as regras do jogo
     */
    public void runAllRules() {

        nodes = map.getNodes();
        
        eat();
        finishPillPower();
        eatGhost();
        createFruit();
        addLife();
        loseLife();
        nextLevel();
        endGame();
        
    }

    /**
     * Método em que o Pacman come um consumível, como um Pacdot, uma pílula de energia
     * ou uma fruta. Além de causar um efeito visual, o método também contabiliza o número
     * de pontos do consumível.
     */
    private void eat() {

        for (Node[] rowNodes : nodes) {
            for (Node node : rowNodes) {
                if (node.hasPacman() && node.getConsumable() != null) {

                    GameStatus.addPoints(node.getConsumable().getPoints());

                    switch (node.getConsumable().getId()) {
                        case (GameConstants.PACDOT): {
                            GameStatus.addPacdot();
                            break;
                        } case (GameConstants.PILL): {
                            GameStatus.setEatableGhosts(true);
                            break;
                        }
                    }

                    node.setConsumable(null);
                    return;
                }
            }
        }

    }
        
    /**
     * TODO
     * Método que encerra o poder da pílula de energia após um determinado tempo.
     */
    private void finishPillPower() {

        GameStatus.setEatableGhosts(false);
        
    }
    
    /**
     * TODO
     * Método que cria, visualmente, uma fruta no mapa após o usuário comer 70 pacdots e
     * novamente, após mais 100 pacdots.
     */
    private void createFruit() {
        
    }
    
    /**
     * TODO
     * Método que possibilita o Pacman comer os fantasmas durante a duração do poder da 
     * pílula de energia. Além disso, contabiliza os pontos que o jogador ganha ao comer
     * um fantasma.
     */
    private void eatGhost() {

        for (Node[] rowNodes : nodes) {
            for (Node node : rowNodes) {
                if (GameStatus.isEatableGhosts()) {
                    if (node.hasPacman() && node.hasGhost()) {


                    }
                }
            }
        }
        
    }
    
    /**
     * Método que subtrai uma vida do jogador quando o Pacman toca um fantasma sem o poder
     * da pílula de energia.
     */
    private void loseLife() {

        for (Node[] rowNodes : nodes) {
            for (Node node : rowNodes) {
                if (!GameStatus.isEatableGhosts()) {
                    if (node.hasPacman() && node.hasGhost()) {
                        
                        GameStatus.setResetGame(true);
                        GameStatus.loseLife();

                        return;

                    }
                }
            }
        }
        
    }
    
    /**
     * Método que adiciona uma vida extra quando o jogador atinge 10000 pontos.
     */
    private void addLife() {
        
        if (GameStatus.getPoints() == 10000)
            GameStatus.addLife();
    }
    
    /**
     * Método que encerra o jogo quando o jogador perde todas as vidas.
     */
    private void endGame() {

        if (GameStatus.getLifes() == 0)
            GameStatus.setGameOver(true);
        
    }
    
    /**
     * Método que avança um nível no jogo, reiniciando o tabuleiro para iniciar
     * um novo nível.
     */
    private void nextLevel() {
        
        if (GameStatus.getPacdots() == 240) {

            GameStatus.resetPacdots();
            GameStatus.nextLevel();
            GameStatus.setNextLevel(true);

        }
        
    }
    
}
