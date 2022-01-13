/**
 * @file Entity.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman.gameElements;

/**
 * Classe abstrata que representa uma entidade do jogo, ou seja, um elemento do jogo
 * que se move
 */
public abstract class Entity {
    
    protected Node currentNode;
    protected Node initialNode;
    protected int id;
    protected int speed;
    protected int direction;
    protected int moveCounter;
    
    /**
     * Construtor padrão da classe abstrata Entity
     * @param node Nó em que a Entidade inicia o jogo
     * @param id Número identificador da Entidade
     * @param speed Velocidade da Entidade
     * @param direction Direção da Entidade
     */
    Entity(Node node, int id, int speed, int direction) {
        
        this.currentNode = node;
        this.initialNode = node;
        this.id = id;
        this.speed = speed;
        this.direction = direction;

        this.currentNode.addEntity(this);
        
    }

    /**
     * Método abstrato responsável pelo movimento da Entidade
     */
    abstract public void move();

    /**
     * Método abstrato responsável pela iniciação da Entidade, ou seja,
     * posiciona-la no nó adequado com o estado adequado
     */
    abstract public void born();

    /**
     * Método abstrato responsável pela "morte" da Entidade
     */
    abstract public void die();

    /**
     * Método getter do atributo id 
     * @return Número identificador da Entidade
     */
    public int getId() {

        return id;

    }

    /**
     * Método getter do atributo node
     * @return Nó em que a Entidade encontra-se
     */
    public Node getNode() {

        return currentNode;

    }

    /**
     * Método setter do atributo node
     * @param node Nó em que a Entidade deve se encontrar
     */
    public void setNode(Node node) {

        this.currentNode = node;

    }
    
}
