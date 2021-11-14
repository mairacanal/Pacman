package pacman.engine;

import pacman.gameElements.GameConstants;
import pacman.gameElements.GameStatus;
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
        eatPacdot();
        eatPill();    
        finishPillPower();
        eatFruit();
        eatGhost();
        createFruit();
        addLife();
        loseLife();
        nextLevel();
        endGame();
        
    }
    
    /**
     * 
     */
    private void eatPill() {

        for (Node[] rowNodes : nodes) {
            for (Node node : rowNodes) {
                if (node.hasPacman()) {
                    if (node.getConsumable() != null && node.getConsumable().getId() == GameConstants.PILL) {

                        node.setConsumable(null);
                        GameStatus.addPoints(50);
                        GameStatus.setEatableGhosts(true);

                    }
                }
            }
        }
        
    }
    
    /**
     * 
     */
    private void eatPacdot() {

        for (Node[] rowNodes : nodes) {
            for (Node node : rowNodes) {
                if (node.hasPacman()) {
                    if (node.getConsumable() != null && node.getConsumable().getId() == GameConstants.PACDOT) {

                        node.setConsumable(null);
                        GameStatus.addPacdots(1);

                    }
                }
            }
        }
        
    }
    
    /**
     * 
     */
    private void eatFruit() {
        
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
    private void addLife() {
        
    }
    
    /**
     * 
     */
    private void endGame() {
        
    }
    
    /**
     * 
     */
    private void nextLevel() {
        
    }
    
}
