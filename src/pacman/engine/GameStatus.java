/**
 * @file GameStatus.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman.engine;

import pacman.gameElements.GameConstants;

/**
 * Classe que armazena todas as informações do jogo, como nível, pontos e vidas, e realiza 
 * toda a aritmética com essas informações.
 */
public class GameStatus {
    
    static private int level = 1;
    static private int points = 0;
    static private int lifes = 3;
    static private int pacdots = 0;
    static private boolean eatableGhosts = false;
    static private boolean resetGame = false;
    static private boolean nextLevel = false;
    static private boolean gameOver = false;
    static private int pacmanDirection = GameConstants.LEFT;

    /**
     * Método getter do atributo level
     * @return Nível do jogo
     */
    public static int getLevel() {
        
        return level;
    
    }

    /**
     * Método que avança um nível no jogo, ou seja, soma um ao nível atual.
     */
    public static void nextLevel() {
    
        level++;
    
    }

    /**
     * Método getter do atributo points
     * @return Pontuação atual do jogador
     */
    public static int getPoints() {
    
        return points;
    
    }

    /**
     * Método que adiciona pontos na pontuação atual do jogador
     * @param points Número de pontos a serem adicionados
     */
    public static void addPoints(int points) {
    
        GameStatus.points += points;
    
    }

    /**
     * Método getter do atributo lifes
     * @return Número de vidas que o jogador possui
     */
    public static int getLifes() {
        
        return lifes;
    
    }

    /**
     * Método que adiciona uma vida ao usuário
     */
    public static void addLife() {
    
        lifes++;
    
    }
    
    /**
     * Método que subtrai uma vida do usuário
     */
    public static void loseLife() {
    
        lifes--;
    
    }

    /**
     * Método getter do atributo pacdots
     * @return Número de pacdots comidos no nível
     */
    public static int getPacdots() {
    
        return pacdots;
    
    }
    
    /**
     * Método que adiciona um pacdot ao número de pacdots previamente comidos pelo jogador
     */
    public static void addPacdot() {
    
        pacdots++;
    
    }

    /**
     * Método que zera o número de pacdots comidos pelo jogador
     */
    public static void resetPacdots() {

        GameStatus.pacdots = 0;

    }

    /**
     * Método que indica se os fantasmas podem ser comidos pelo Pacman
     * @return Retorna true, se os fantasmas forem comestíveis
     */
    public static boolean isEatableGhosts() {
    
        return eatableGhosts;
    
    }

    /**
     * Método setter do atributo eatableGhost
     * @param eatableGhosts Operador lógico que indica se os fantasmas podem 
     * ou não ser comidos pelo Pacman
     */
    public static void setEatableGhosts(boolean eatableGhosts) {
    
        GameStatus.eatableGhosts = eatableGhosts;
    
    }
    
    /**
     * Método que indica se o jogo deve ser reiniciado, ou seja, se o jogador perdeu 
     * a sua vida
     * @return Retorna true, se o tabuleiro deve ser reiniciado
     */
    public static boolean isResetGame() {
    
        return resetGame;
    
    }

    /**
     * Método setter do atributo resetGame
     * @param resetGame Operador lógico que indica se o tabuleiro deve ser reiniciado
     */
    public static void setResetGame(boolean resetGame) {
    
        GameStatus.resetGame = resetGame;
    
    }

    /**
     * Método que indica se o próximo nível deve ser iniciado, reiniciando o tabuleiro,
     * mas não os pontos
     * @return Retorna true, se o próximo nível deve ser inicializado
     */
    public static boolean isNextLevel() {
    
        return nextLevel;
    
    }

    /**
     * Método setter do atributo nextLevel
     * @param nextLevel Operador lógico que indica se o próximo nível deve ser iniciado
     */
    public static void setNextLevel(boolean nextLevel) {
    
        GameStatus.nextLevel = nextLevel;
    
    }

    /**
     * Método que indica se o jogo acabou, ou seja, que o jogador perdeu todas as vidas
     * @return Retorna true, se o jogo acabou
     */
    public static boolean isGameOver() {
    
        return gameOver;
    
    }

    /**
     * Método setter do atributo gameOver
     * @param gameOver Operador lógico que indica se o jogo acabou
     */
    public static void setGameOver(boolean gameOver) {
    
        GameStatus.gameOver = gameOver;

    }
    

    /**
     * Método que desabilita todas as flags, ou seja, atribui false para todas as flags 
     * do jogo
     */
    public static void resetFlags()  {

        resetGame = false;
        nextLevel = false;
        gameOver = false;

    }
    
    /**
     * Método setter do atributo pacmanDirection
     * @param direction Nova direção do Pacman
     */
    public static void setPacmanDirection(int direction) {
        
        pacmanDirection = direction;
        
    }
    
    /**
     * Método getter do atributo pacmanDirection
     * @return Direção do Pacman
     */
    public static int getPacmanDirection() {
        
        return pacmanDirection;
        
    }
    
    public static void addGhostPoints() {
        addPoints(GameConstants.POINTS_BY_GHOST);
        
        GameConstants.POINTS_BY_GHOST *= 2;
        
        
        if(GameConstants.POINTS_BY_GHOST > 1600) {
            GameConstants.POINTS_BY_GHOST = 200;
            
        }
    }
}
