package pacman.engine;

import pacman.gameElements.GameConstants;
import pacman.gameElements.Map;
import pacman.gameElements.Node;

/**
 * 
 */
public class GameRules {

    private Map map;
    private Node[][] nodes;

    /**
     * 
     * @param map
     */
    GameRules(Map map) {

        this.map = map;

    }
    
    /**
     * 
     */
    public void runAllRules() {

        nodes = map.getNodes();
        
        // TODO: avaliar se essa é a melhor ordem
        eat();
        finishPillPower();
        eatGhost();
        createFruit();
        addLife();
        loseLife();
        nextLevel();
        endGame();
        
    }

    private void eat() {

        for (Node[] rowNodes : nodes) {
            for (Node node : rowNodes) {
                if (node.hasPacman() && node.getConsumable() != null) {

                    GameStatus.addPoints(node.getConsumable().getPoints());

                    switch (node.getConsumable().getId()) {
                        case (GameConstants.PACDOT): {
                            GameStatus.addPacdots(1);
                            break;
                        } case (GameConstants.PILL): {
                            GameStatus.setEatableGhosts(true);
                            break;
                        }
                    }

                    node.setConsumable(null);
                }
            }
        }

    }
        
    /**
     * 
     */
    private void finishPillPower() {

        GameStatus.setEatableGhosts(false);
        
    }
    
    /**
     * 
     */
    private void createFruit() {
        
    }
    
    /**
     * 
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
     * 
     */
    private void loseLife() {

        for (Node[] rowNodes : nodes) {
            for (Node node : rowNodes) {
                if (!GameStatus.isEatableGhosts()) {
                    if (node.hasPacman() && node.hasGhost()) {
                        
                        GameStatus.setResetGame(true);
                        GameStatus.loseLife();

                    }
                }
            }
        }
        
    }
    
    /**
     * 
     */
    private void addLife() {
        
        if (GameStatus.getPoints() == 10000)
            GameStatus.addLife();
    }
    
    /**
     * 
     */
    private void endGame() {

        if (GameStatus.getLifes() == 0)
            GameStatus.setGameOver(true);
        
    }
    
    /**
     * 
     */
    private void nextLevel() {
        
        if (GameStatus.getPacdots() == 240) {

        }
        
    }
    
}
