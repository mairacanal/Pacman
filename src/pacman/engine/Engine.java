package pacman.engine;

import pacman.gameElements.*;
import java.util.LinkedList;
import java.util.ArrayList;

import java.util.concurrent.TimeUnit;

public class Engine {

    private Map map;
    private GameRules gameRules;
    private ArrayList<Entity> entities;

    private final int framerate = 1;

    /**
     * 
     * @param map
     */
    public Engine(Map map) {

       this.map = map;
       this.entities = new ArrayList<>();
       this.gameRules = new GameRules(map);

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
    public void init() {

        entities = map.build();
        
        calculateDistance(entities.get(entities.size() - 1).getNode(), "pacman");
        calculateDistance(map.getNode(11, 13), "ghostSidewalk");

        for (Entity entity : entities)
            entity.born();

    }

    /**
     * 
     */
    public void running() {

        try {

            TimeUnit.MILLISECONDS.sleep(1000 / framerate);

        } catch (InterruptedException e) {

            System.out.println("Error: " + e.getMessage());

        }

        for (Entity entity : entities)
            entity.move();
        gameRules.runAllRules();

        if (GameStatus.isResetGame()) {

            for (Entity entity : entities)
                entity.born();
            GameStatus.setResetGame(false);

        } else if (GameStatus.isGameOver()) {

            GameStatus.setGameOver(false);
            exit();

        }

        calculateDistance(entities.get(entities.size() - 1).getNode(), "pacman");

    }

    /**
     * 
     */
    public void exit() {

        System.out.println("GAME OVER");
        System.out.println("Sua pontuação: " + GameStatus.getPoints());
        System.exit(0);

    }

}