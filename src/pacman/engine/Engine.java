package pacman.engine;

import pacman.gameElements.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

public class Engine {

    private Map map;
    private GameLoop gameLoop;
    private GameRules gameRules;
    private ArrayList<Entity> entities;

    private final int framerate = 30;
    private final int BOARD_VERTICAL = GameConstants.BOARD_VERTICAL;
    private final int BOARD_HORIZONTAL = GameConstants.BOARD_HORIZONTAL;

    /**
     * 
     * @param map
     */
    public Engine(Map map) {

       this.map = map;
       this.entities = new ArrayList<>();
       this.gameLoop = new GameLoop(entities);
       this.gameRules = new GameRules(map);

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
     * @param matrix
     */
    private void buildMap(int[][] matrix) {

        Entity entity;
        Node[][] nodes;

        nodes = new Node[BOARD_VERTICAL][BOARD_HORIZONTAL];

        for (int i = 0; i < BOARD_VERTICAL; i++) {
            for (int j = 0; j < BOARD_HORIZONTAL; j++) {
                
                int id = matrix[i][j];

                if (id >= GameConstants.PACDOT && id <= GameConstants.FRUIT)
                    nodes[i][j] =  new Node(id, new Consumable(id));
                else 
                    nodes[i][j] =  new Node(id);

                switch (id) {
                    case (GameConstants.PACMAN):
                        entity = new Pacman(nodes[i][j]);
                        break;
                    case (GameConstants.BLINKY):
                        entity = new Blinky(nodes[i][j]);
                        break;
                    case (GameConstants.PINKY):
                        entity = new Pinky(nodes[i][j]);
                        break;
                    case (GameConstants.INKY):
                        entity = new Inky(nodes[i][j]);
                        break;
                    case (GameConstants.CLYDE):
                        entity = new Clyde(nodes[i][j]);
                        break;
                    default:
                        entity = null;
                        break;
                }

                if (entity != null)
                    entities.add(entity);
            
            }
        }

        map.build(nodes);

    }

    /**
     * 
     * @param node
     * @param key
     */
    private void calculateDistance(Node node, String key){
        
        LinkedList<Node> list = new LinkedList<>();

        for (Node[] nodeRow : map.getNodes())
            for (Node current : nodeRow)
                current.setStatus(-1);
        
        list.add(node);
        node.setStatus(0);
        node.setDistance(key, 0);

        while (list.size() > 0) {
            
            Node currNode = list.pop();
            
            if (currNode.getStatus() != 0) continue;
            
            currNode.setStatus(1);
            
            for (Node nextNode : currNode.getNodes()){
                
                if (nextNode.getId() == GameConstants.BLOCKED) continue;
                if (nextNode.getStatus() == -1) {
                   
                    nextNode.setStatus(0);
                    nextNode.setDistance(key, currNode.getDistance(key) + 1);
                                      
                    list.addLast(nextNode);

                }  
                
            }
            
        }

    }    

    /**
     * 
     */
    private void resetMap() {

        int[][] matrix = readMapFile();
        
        entities.clear();

        buildMap(matrix);

    }

    /**
     * 
     */
    public void init() {

        resetMap();
        
        calculateDistance(entities.get(entities.size() - 1).getNode(), "pacman");
        calculateDistance(map.getNode(11, 13), "ghostSidewalk");

        gameLoop.init();

    }

    /**
     * 
     */
    public void running() {

        gameLoop.loop();
        gameRules.runAllRules();

        calculateDistance(entities.get(entities.size() - 1).getNode(), "pacman");

    }

    /**
     * 
     */
    public void exit() {

    }

}