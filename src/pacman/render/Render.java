package pacman.render;

import pacman.engine.GameStatus;
import pacman.gameElements.GameConstants;
import pacman.gameElements.Map;
import pacman.gameElements.Node;
import java.util.HashMap;

/**
 * Classe que renderiza a interface gráfica do jogo
 */
public class Render {
    
    private Map map;
    private HashMap<Integer, String> pallete;
    
    /**
     * Construtor padrão da classe Render
     * @param map Mapa do jogo
     */
    public Render(Map map) {
        
        this.map = map;
        this.pallete = new HashMap<>();
        this.pickPallete();
    
    }
    
    /**
     * Método que define a paleta de correspondência entre símbolos e identificadores
     * do jogo
     */
    private void pickPallete(){

        this.pallete.put(GameConstants.PATH,   "  " + "\u001B[0m");
        this.pallete.put(GameConstants.BLOCKED,"\u001B[34m" + "▓▓" + "\u001B[0m");
        this.pallete.put(GameConstants.PACMAN, "\u001B[33m" + "¢ " + "\u001B[0m");
        this.pallete.put(GameConstants.BLINKY, "\u001B[31m" + "B " + "\u001B[0m");
        this.pallete.put(GameConstants.PINKY,  "\u001B[35m" + "P " + "\u001B[0m");
        this.pallete.put(GameConstants.INKY,   "\u001B[36m" + "I " + "\u001B[0m");
        this.pallete.put(GameConstants.CLYDE,  "\u001B[37m" + "C " + "\u001B[0m");
        this.pallete.put(GameConstants.PACDOT, "\u001B[37m" + "· " + "\u001B[0m");
        this.pallete.put(GameConstants.PILL,   "\u001B[37m" + "¤ " + "\u001B[0m");
        this.pallete.put(GameConstants.FRUIT,  "\u001B[31m" + "× " + "\u001B[0m");
        this.pallete.put(23,                   "× " + "\u001B[0m");
        this.pallete.put(24,                   "× " + "\u001B[0m");
        this.pallete.put(GameConstants.HOME,   "\u001B[31m" + "  " + "\u001B[0m");
        this.pallete.put(GameConstants.GATE,   "\u001B[34m" + "--" + "\u001B[0m");
        
    }
    
    /**
     * Método que desenha a interface gráfica do jogo
     */
    public void draw(){

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        for (int i = 0; i < GameConstants.BOARD_VERTICAL; i++){
            
            for (int j = 0; j < GameConstants.BOARD_HORIZONTAL; j++){
                
                Node current = map.getNode(i,j);
                
                if (!current.getEntities().isEmpty())
                    System.out.print(this.pallete.get(current.getEntities().get(0).getId()));
                else if (current.getConsumable() != null)
                    System.out.print(this.pallete.get(current.getConsumable().getId()));
                else if (current.getId() == GameConstants.BLOCKED || current.getId() == GameConstants.GATE)
                    System.out.print(this.pallete.get(current.getId()));
                else        
                    System.out.print(this.pallete.get(GameConstants.PATH));
                
            }
            
            System.out.println();
            
        }  
        
        System.out.println("Points: " + GameStatus.getPoints());
        System.out.println("Lifes: " + GameStatus.getLifes());

    }
    
}
