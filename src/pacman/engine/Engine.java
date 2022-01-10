/**
 * @file Engine.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman.engine;

import pacman.gameElements.Map;
import pacman.gameElements.Entity;
import pacman.gameElements.Node;
import pacman.gameElements.GameConstants;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Classe que representa a engine de funcionamento do jogo, sendo responsável pela movimentação
 * dos personagens em cada turno, pela velocidade do jogo, pela contagem de pontos e pelo cálculo
 * das distâncias entre os nós do mapa.
 */
public class Engine {

    private final Map map;
    private final GameRules gameRules;
    private ArrayList<Entity> entities;
    
    /**
     * Construtor padrão da classe Engine
     * @param map Mapa do jogo, compartilhado com o Render
     */
    public Engine(Map map) {

       this.map = map;
       this.entities = new ArrayList<>();
       this.gameRules = new GameRules(map);

    }


    /**
     * Método para cálculo de distância de todos os nós do mapa até um nó especificado
     * @param node Nó referência para o cálculo de distância
     * @param key Chave da distância na estrutura de dados map de cada nó
     */
    private void calculateDistance(Node node, String key){
        
        LinkedList<Node> list = new LinkedList<>();

        for (Node[] nodeRow : map.getNodes())
            for (Node current : nodeRow)
                current.setStatus(-1);
        
        list.add(node);
        node.setStatus(0);
        node.setDistance(key, 0);

        while (!list.isEmpty()) {
            
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
     * Método de inicialização da engine do jogo, com construção do mapa, cálculo inicial de 
     * distâncias e método de inicialização das entidades.
     */
    public void init() {

        entities = map.build();
        
        calculateDistance(entities.get(entities.size() - 1).getNode(), "pacman");
        calculateDistance(map.getNode(11, 13), "ghostSidewalk");
        calculateDistance(map.getNode(14, 13), "home");

        for (Entity entity : entities)
            entity.born();

    }

    /**
     * Método que executa a lógica do jogo, movendo os personagens, aplicando as regras do jogo
     * e recalculando as distâncias.
     */
    public void running() {

        // FIX ME: Clyde não mata o Pacman
        for (Entity entity : entities)
            entity.move();
        gameRules.runAllRules();

        if (GameStatus.isResetGame())
            for (Entity entity : entities)
                entity.born();
        else if (GameStatus.isGameOver())
            exit();
        else if (GameStatus.isNextLevel())
            init();

        GameStatus.resetFlags();

        calculateDistance(entities.get(entities.size() - 1).getNode(), "pacman");

    }

    /**
     * Método que encerra a engine, mostrando a pontuação final do usuário e encerrando o jogo.
     */
    public void exit() {

        System.out.println("GAME OVER");
        System.out.println("Sua pontuação: " + GameStatus.getPoints());
        System.exit(0);

    }

}