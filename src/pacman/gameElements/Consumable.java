/**
 * @file Consumable.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman.gameElements;

import pacman.engine.GameStatus;

/**
 * Classe que representa qualquer consumível do jogo, ou seja, qualquer
 * objeto que o Pacman possa consumir e ganhar pontos
 */
public class Consumable {
    
    private int points;
    private int id;
    
    /**
     * Construtor padrão da classe Consumable
     * @param id Identificador do consumível
     */
    public Consumable(int id) {

        this.id = id;
        
        switch (id){
            
            case (GameConstants.PACDOT): {
                points = 10;
                break;
            }
            case (GameConstants.PILL): {
                points = 50;
                break;
            }
            case (GameConstants.FRUIT): {
                points = 200 * GameStatus.getLevel();
                this.id += GameStatus.getLevel() % 3;
                break;
            }
            
        }
    
    }

    /**
     * Método getter do atributo points
     * @return Retorna o número de pontos que o Pacman ganha quando
     * come um consumível 
     */
    public int getPoints() {
        
        return points;
        
    }

    /**
     * Método setter do atributo points
     * @param points Número de pontos que o consumível equivale
     */
    public void setPoints(int points) {
        
        this.points = points;
        
    }

    /**
     * Método getter do atributo id
     * @return Retorna o número de identificação do consumível
     */
    public int getId() {
        
        return id;
        
    }

    /**
     * Método setter do atributo id
     * @param id Número de identificação do consumível
     */
    public void setId(int id) {
        
        this.id = id;
        
    }    
    
}