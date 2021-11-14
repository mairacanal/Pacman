package pacman.gameElements;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * 
 */
public class Map {
    
    private Node[][] nodes;
    private int[][] matrix;

    private final int BOARD_VERTICAL = GameConstants.BOARD_VERTICAL;
    private final int BOARD_HORIZONTAL = GameConstants.BOARD_HORIZONTAL;
    
    /**
     * 
     */
    public Map(){
        
        this.nodes = new Node[BOARD_VERTICAL][BOARD_HORIZONTAL];
        this.matrix = readMapFile();

    }
    
    
    /**
     * 
     * @return
     */
    private int[][] readMapFile() {

        int[][] matrix = new int[BOARD_VERTICAL][BOARD_HORIZONTAL];

        try {

            File mapFile = new File("src/pacman/resources/map.txt");
            Scanner scan = new Scanner(mapFile);

            for (int i = 0; i < BOARD_VERTICAL; i++)
                for (int j = 0; j < BOARD_HORIZONTAL; j++)
                    matrix[i][j] = scan.nextInt();
            
        } catch (FileNotFoundException e) {

            System.out.println("An error occurred: " + e.getMessage());
        }

        return matrix;
        
    }

    /**
     * 
     */
    private void linkAll(){
        
        for(int i = 0; i < BOARD_VERTICAL; i++) {
            for(int j = 0; j < BOARD_HORIZONTAL; j++) {
                
                nodes[i][j].connect(nodes[(i + 1) % BOARD_VERTICAL][j]);           
                nodes[i][j].connect(nodes[(i + BOARD_VERTICAL - 1) % BOARD_VERTICAL][j]);       
                nodes[i][j].connect(nodes[i][(j + 1) % BOARD_HORIZONTAL]);        
                nodes[i][j].connect(nodes[i][(j + BOARD_HORIZONTAL - 1) % BOARD_HORIZONTAL]); 
                     
            }
        }
        
    }

    /**
     * 
     * @param matrix
     */
    public ArrayList<Entity> build() {

        ArrayList<Entity> entities = new ArrayList<>();

        for (int i = 0; i < BOARD_VERTICAL; i++) {
            for (int j = 0; j < BOARD_HORIZONTAL; j++) {
                
                int id = matrix[i][j];

                if (id >= GameConstants.PACDOT && id <= GameConstants.FRUIT)
                    nodes[i][j] =  new Node(id, new Consumable(id));
                else 
                    nodes[i][j] =  new Node(id);

                switch (id) {
                    case (GameConstants.PACMAN):
                        entities.add(new Pacman(nodes[i][j]));
                        break;
                    case (GameConstants.BLINKY):
                        entities.add(new Blinky(nodes[i][j]));
                        break;
                    case (GameConstants.PINKY):
                        entities.add(new Pinky(nodes[i][j]));
                        break;
                    case (GameConstants.INKY):
                        entities.add(new Inky(nodes[i][j]));
                        break;
                    case (GameConstants.CLYDE):
                        entities.add(new Clyde(nodes[i][j]));
                        break;
                    default:
                        break;
                }

            }
        }

        linkAll();
        return entities;

    }
    
    /**
     * 
     * @param i
     * @param j
     * @return
     */
    public Node getNode(int i, int j) {
        
        return nodes[i][j];
        
    }
        
    /**
     * 
     * @return
     */
    public Node[][] getNodes() {
        
        return nodes;
    
    }    

}
