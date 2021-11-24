/**
 * @file Map.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman.gameElements;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Classe que representa um elemento do jogo, o map (ou tabuleiro)
 */
public class Map {
    
    private Node[][] nodes;
    private int[][] matrix;

    private final int BOARD_VERTICAL = GameConstants.BOARD_VERTICAL;
    private final int BOARD_HORIZONTAL = GameConstants.BOARD_HORIZONTAL;
    
    /**
     * Construtor padrão da classe Map
     */
    public Map(){
        
        this.nodes = new Node[BOARD_VERTICAL][BOARD_HORIZONTAL];
        this.matrix = readMapFile();

    }
    
    
    /**
     * Método que lê o arquivo que o possui o mapa com identificadores e
     * transforma-o em uma matriz de inteiros
     * @return Matriz de inteiros com os identificadores do elementos
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
     * Método que conecta todos os nós do mapa, possibilitando o cálculo de distâncias
     * e a movimentação no mapa
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
     * Método que constroi um mapa de nós a partir da matriz de identificadores, posicionando
     * as entidades e comestíveis no tabuleiro
     * @return Array de entidades que existem no tabuleiro
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
     * Método getter de um nó do mapa
     * @param i Index da linha
     * @param j Index da coluna
     * @return Nó da linha i e coluna j do mapa
     */
    public Node getNode(int i, int j) {
        
        return nodes[i][j];
        
    }
        
    /**
     * Método getter de todos os nós do mapa
     * @return Matriz de nós
     */
    public Node[][] getNodes() {
        
        return nodes;
    
    }    

}
