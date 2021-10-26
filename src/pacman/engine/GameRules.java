/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacman.engine;

/**
 *
 * @author mairacanal
 */
public class GameRules {
    
    public void runAllRules() {
        
        // TODO: avaliar se essa é a melhor ordem
        eatPacdot();
        allPacdotsWereEaten();
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
    
    private void allPacdotsWereEaten() {
        
    }
    
    // TODO: esse método é realmente necessário?
    private void allPillsWereEaten() {
        
    }
    
    private void eatPill() {
        
    }
    
    private void eatPacdot() {
        
    }
    
    private void eatFruit() {
        
    }
        
    private void finishPillPower() {
        
    }
    
    private void createFruit() {
        
    }
    
    private void eatGhost() {
        
    }
    
    private void loseLife() {
        
    }
    
    private void addLife() {
        
    }
    
    private void endGame() {
        
    }
    
    private void nextLevel() {
        
    }
    
}
