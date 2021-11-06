package pacman.engine;

import pacman.gameElements.Map;
import pacman.gameElements.Node;
import pacman.gameElements.Entity;
import pacman.gameElements.GameConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

public class Engine {

    private Map map;
    private int[][] matrix;
    private ArrayList<Entity> entities;

    private final int BOARD_VERTICAL = GameConstants.BOARD_VERTICAL;
    private final int BOARD_HORIZONTAL = GameConstants.BOARD_HORIZONTAL;

    public Engine(Map map) {

       this.map = map;

    }

    private void readMapFile() {

        this.matrix = new int[BOARD_VERTICAL][BOARD_HORIZONTAL];

        try {

            File mapFile = new File("src/pacman/resources/map.txt");
            Scanner scan = new Scanner(mapFile);

            for (int i = 0; i < BOARD_VERTICAL; i++)
                for (int j = 0; j < BOARD_HORIZONTAL; j++)
                    matrix[i][j] = scan.nextInt();
            
        } catch (FileNotFoundException e) {

            System.out.println("An error occurred: " + e.getMessage());
        }
        
    }

    private void calculateDistance(Node node, String key){
        
        LinkedList<Node> list = new LinkedList<>();
        
        list.add(node);
        node.setStatus(0);
        node.setDistance(key, 0);
        
        while (list.size() > 0) {
            
            Node currNode = list.pop();
            
            if (currNode.getStatus() != 0) continue;
            
            currNode.setStatus(1);
            int currDistance = currNode.getDistance(key);
            
            for (Node nextNode : currNode.getNodes()){
                
                if (!nextNode.isCanWalk()) continue;
                if (nextNode.getStatus() == -1) {
                   
                    nextNode.setStatus(0);
                    nextNode.setDistance(key, currDistance + 1);
                                      
                    list.addLast(nextNode);
                }  
                
            }
            
        }

    }    

    public void init() {

        readMapFile();
        map.build(matrix);
        calculateDistance(map.getNode(23,13), "pacman");

    }

    public void running() {

    }

    public void exit() {

    }

}