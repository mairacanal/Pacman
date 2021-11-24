/**
 * @file Ghost.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman.gameElements;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe abstrata que representa um fantasma no jogo, implementando as características
 * comuns a um fantasma
 */
public abstract class Ghost extends Entity {

    protected boolean isChasing;
    protected boolean isLeavingHome;
    protected boolean isGoingHome;
    
    /**
     * Construtor padrão da classe abstrata Entity
     * @param currentNode Nó em que a Entidade inicia o jogo
     * @param id Número identificador da Entidade
     * @param speed Velocidade da Entidade
     * @param direction Direção da Entidade
     */
    Ghost(Node currentNode, int id, int speed, int direction) {
        
        super(currentNode, id, speed, direction);
    
    }

    /**
     * Método que move um fantasma para o nó mais próximo de um ponto
     * definido pela label
     * @param label Chave da distância na estrutura de dados map de cada nó
     * @param ids Array de números identificadores que o fantasma não pode estar
     */
    private void moveNodeByDistance(String label, ArrayList<Integer> ids) {

        ArrayList<Node> currentNodes = currentNode.getNodes();
        Node nextNode = null;

        for (Node currentNode : currentNodes) {

            if (currentNode.notForbiddenId(ids) && nextNode == null)
                nextNode = currentNode;
            else if (currentNode.notForbiddenId(ids) && nextNode.getDistance(label) > currentNode.getDistance(label)) 
                nextNode = currentNode;

        }

        currentNode.removeEntity(this);
        currentNode = nextNode;
        currentNode.addEntity(this);

    }

    /**
     * Método que move o fantasma para fora da casa de forma coordenada
     */
    protected void leavingHome() {

        ArrayList<Integer> id = new ArrayList<>();

        id.add(GameConstants.BLOCKED);

        moveNodeByDistance("ghostSidewalk", id);

        if (currentNode.getDistance("ghostSidewalk") == 0) {

            isLeavingHome = false;
            isChasing = true;

        }

    }

    /**
     * TODO
     * Método que move o fantasma de volta para casa, após o Pacman come-lo 
     */
    protected void goingHome() {

    }

    /**
     * Método que move o fantasma perseguindo o Pacman
     */
    protected void chase() {

        ArrayList<Integer> id = new ArrayList<>();

        id.add(GameConstants.BLOCKED);
        id.add(GameConstants.GATE);

        moveNodeByDistance("pacman", id);

    }

    /**
     * Método que move o fantasma de forma aleatória
     */
    protected void random() {

        Random rand = new Random();
        Node previousNode = currentNode;
        ArrayList<Node> currentNodes = currentNode.getNodes();
        ArrayList<Integer> id = new ArrayList<>();
        int newDirection;

        id.add(GameConstants.BLOCKED);
        id.add(GameConstants.GATE);

        do {

            newDirection = rand.nextInt(4);
            currentNode = currentNodes.get(newDirection);

        } while (!currentNode.notForbiddenId(id) || newDirection == GameConstants.oppositeDirection(direction));

        direction = newDirection;
        previousNode.removeEntity(this);
        currentNode.addEntity(this);

    }
    
    /**
     * Método que inicializa o fantasma na posição e no estado adequado
     */
    public void born() {

        isLeavingHome = true;
        isChasing = false;
        isGoingHome = false;        
        
        currentNode.removeEntity(this);
        initialNode.addEntity(this);
        currentNode = initialNode;

    }
    
    /**
     * Método que mata o fantasma, colocando ele no estado de voltar para casa
     */
    public void die() {
        
        isLeavingHome = false;
        isChasing = false;
        isGoingHome = true;

    }
    
}
