package pacman.engine;

import pacman.gameElements.Map;
import pacman.gameElements.Node;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;

public class Engine {

    private Map map;
    private int[][] matrix;

    public Engine(Map map) {

       this.map = map;

    }

    private void readMapFile() {

        this.matrix = new int[31][28];

        try {

            File mapFile = new File("src/pacman/resources/map.txt");
            try (Scanner scan = new Scanner(mapFile)) {
                for (int i = 0; i < 31; i++)
                    for (int j = 0; j < 28; j++)
                        matrix[i][j] = scan.nextInt();
            }
            
        } catch (FileNotFoundException e) {

            System.out.println("An error occurred: " + e.getMessage());
        }
        
    }
    
    private void calcDistanceR(Node node, String key, LinkedList list){
        
    }
    private void calcDistance(Node node, String key){
        
        LinkedList<Node> list = new LinkedList<>();
        
        list.add(node);
        node.setStatus(0);
        node.setDistance(key, 0);
        
        while (list.size() > 0){
            
            Node currNode = list.pop();
            
            if (currNode.getStatus() != 0) continue;
            
            currNode.setStatus(1);
            int currDistance = currNode.getDistance(key);
            
            //int currDistance = currNode.distance;
            
            for(Node nextNode : currNode.getNodes()){
                
                if(!nextNode.isCanWalk()) continue;
                if(nextNode.getStatus() == -1){
                   
                    nextNode.setStatus(0);
                    nextNode.setDistance(key, currDistance +1);
                    //nextNode.distance = currDistance +1;
                                      
                    list.addLast(nextNode);
                }  
                
            }
            
        }
    }    

    public void init() {

        readMapFile();
        
        map.build(this.matrix);
        map.linkAll();
        
        this.calcDistance(map.getNode(23,13), "pacman");

    }

    public void running() {

    }

    public void exit() {

    }

}