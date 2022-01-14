/**
 * @file GameRules.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman.engine;

import pacman.gameElements.Consumable;
import pacman.gameElements.GameConstants;
import pacman.gameElements.Map;
import pacman.gameElements.Node;

/**
 * Classe que agrupa todas as regras do jogo, contabilizando os pontos do usuário, as vidas
 * e o nível do jogo.
 */
public class GameRules {

    private final Map map;
    
    private long pillStartTime;        

    /**
     * Construtor padrão da classe GameRules
     * @param map Mapa do jogo, compartilhado entre a Engine e o Render
     */
    GameRules(Map map) {

        this.map = map;

    }
    
    /**
     * Método para execução das regras do jogo a cada movimento 
     */
    public void runMoveRules() {
                
        eat();
        finishPillPower();
        eatGhost();
        loseLife();
        
    }
    
    /**
     * Método para execução das regras do jogo a cada rodada
     */
    public void runAllRules() {

        createFruit();
        addLife();
        nextLevel();
        endGame();
        
    }

    /**
     * Método em que o Pacman come um consumível, como um Pacdot, uma pílula de energia
     * ou uma fruta. Além de causar um efeito visual, o método também contabiliza o número
     * de pontos do consumível.
     */
    private void eat() {

        for (Node[] rowNodes : map.getNodes()) {
            for (Node node : rowNodes) {
                if (node.hasPacman() && node.getConsumable() != null) {

                    GameStatus.addPoints(node.getConsumable().getPoints());

                    switch (node.getConsumable().getId()) {
                        case (GameConstants.PACDOT): {
                            GameStatus.addPacdot();
                            break;
                        } case (GameConstants.PILL): {
                            GameStatus.setEatableGhosts(true);
                            map.getGhosts().forEach((ghost) -> ghost.setEatable(true));
                            pillStartTime = System.currentTimeMillis();
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
     * Método que encerra o poder da pílula de energia após um determinado tempo.
     */
    private void finishPillPower() {
        
        if (GameStatus.isEatableGhosts() && System.currentTimeMillis() - pillStartTime > GameConstants.POWER_PILL_TIME_MS) {
            
            GameStatus.setEatableGhosts(false);
            GameConstants.POINTS_BY_GHOST = 200;
            map.getGhosts().forEach((ghost) -> ghost.setEatable(false));
            
        }
        
    }
    
    /**
     * Método que cria, visualmente, uma fruta no mapa após o usuário comer 70 pacdots e
     * novamente, após mais 100 pacdots.
     */
    private void createFruit() {
        
        if (GameStatus.getPacdots() == 70 || GameStatus.getPacdots() == 170)
            map.getNode(17, 13).setConsumable(new Consumable(GameConstants.FRUIT));
        
    }
    
    /**
     * Método que possibilita o Pacman comer os fantasmas durante a duração do poder da 
     * pílula de energia. Além disso, contabiliza os pontos que o jogador ganha ao comer
     * um fantasma.
     */
    private void eatGhost() {
        
        if (GameStatus.isEatableGhosts()) {
            for (Node[] rowNodes : map.getNodes()) {
                for (Node node : rowNodes) {
                    if (node.hasPacman() && node.hasGhost()) {
                        
                        node.getBlueGhosts().forEach((ghost) -> ghost.die());
                        
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

        for (Node[] rowNodes : map.getNodes()) {
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
