/**
 * @file Ghost.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman.gameElements;

import java.util.ArrayList;
import java.util.Random;
import pacman.engine.GameStatus;

/**
 * Classe abstrata que representa um fantasma no jogo, implementando as características
 * comuns a um fantasma
 */
public abstract class Ghost extends Entity {

    protected boolean isChasing;
    protected boolean isLeavingHome;
    protected boolean isGoingHome;
    protected boolean isRunningAway;
    private boolean isDead;
    protected int behavior;
    protected int normalId;
    
    /**
     * Construtor padrão da classe abstrata Entity
     * @param currentNode Nó em que a Entidade inicia o jogo
     * @param id Número identificador da Entidade
     * @param speed Velocidade da Entidade
     * @param direction Direção da Entidade
     */
    Ghost(Node currentNode, int id, int speed, int direction) {
        
        super(currentNode, id, speed, direction);
        normalId = id;
    
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

        for (Node node : currentNodes) {

            if (node.notForbiddenId(ids) && nextNode == null)
                nextNode = node;
            else if (node.notForbiddenId(ids) && nextNode.getDistance(label) > node.getDistance(label)) 
                nextNode = node;

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
        id.add(GameConstants.VOID);

        moveNodeByDistance("ghostSidewalk", id);

        if (currentNode.getDistance("ghostSidewalk") == 0) {

            isLeavingHome = false;
            isChasing = true;
            isRunningAway = false;
            isGoingHome = false; 

        }

    }

    /**
     * Método que move o fantasma perseguindo o Pacman
     */
    protected void chase() {

        ArrayList<Integer> id = new ArrayList<>();

        id.add(GameConstants.BLOCKED);
        id.add(GameConstants.GATE);
        id.add(GameConstants.VOID);

        moveNodeByDistance("pacman", id);

    }
    
    /**
     * Método que move o fantasma perseguindo o Pacman
     */
    protected void goingHome() {
        
        if (currentNode.getDistance("home") == 0) {
            
            born();
            return;
            
        }
        
        ArrayList<Integer> id = new ArrayList<>();

        id.add(GameConstants.BLOCKED);
        id.add(GameConstants.VOID);

        moveNodeByDistance("home", id);
        
    }
    
    /**
     * Método que move o fantasma perseguindo o Pacman
     */
    protected void runAway() {

        random();

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
        id.add(GameConstants.VOID);

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
    @Override
    public void born() {

        id = normalId;
        isDead = false;
        
        isLeavingHome = true;
        isChasing = false;
        isGoingHome = false;    
        isRunningAway = false;
        
        currentNode.removeEntity(this);
        initialNode.addEntity(this);
        currentNode = initialNode;

    }
    
    /**
     * Método que mata o fantasma, colocando ele no estado de voltar para casa
     */
    @Override
    public void die() {

        isDead = true;
        id = GameConstants.GHOSTGHOST;
        isLeavingHome = false;
        isChasing = false;
        isGoingHome = true;
        isRunningAway = false;


        GameStatus.addGhostPoints();

    }
    
    /**
     * Método que atualiza as flags de status do fantasma, dependendo se o fantasma está morto.
     * @param isEatable Operador lógico que indica se o fantasma está comestível ou não.
     */
    public void setEatable(boolean isEatable) {
        
        if (!isDead) {
            
            if (isEatable) {
                
                id = GameConstants.BLUEGHOST;
                isRunningAway = true;
                isLeavingHome = false;
                isChasing = false;
                isGoingHome = false;   
                
            } else {
                
                id = normalId;
                isRunningAway = false;
                isLeavingHome = false;
                isChasing = true;
                isGoingHome = false;  
                
            }
            
        }
        
    }   
    
}
