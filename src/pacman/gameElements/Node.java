/**
 * @file Node.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman.gameElements;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que representa um nó no tabuleiro
 */
public class Node {
    
    private final ArrayList<Node> nodes;
    private ArrayList<Entity> entities;
    private final HashMap<String, Integer> distances;
    private Consumable consumable;
    private final int id;    
    private int status;

    /**
     * Construtor padrão da classe Node
     * @param id Número identificador do nó
     */
    public Node(int id) {

        this.id = id;
        this.consumable = null;
        this.nodes =  new ArrayList<>();
        this.entities =  new ArrayList<>();
        this.distances = new HashMap<>();
        this.status = -1;

    }
    
    /**
     * Construtor alternativo da classe Node
     * @param id Número identificador do nó
     * @param consumable Consumível que existe no nó
     */
    public Node(int id, Consumable consumable) {
        
        this.id = id;
        this.consumable = consumable;
        this.nodes =  new ArrayList<>();
        this.entities =  new ArrayList<>();
        this.distances = new HashMap<>();
        this.status = -1;
    
    }
    
    /**
     * Método que conecta dois nós
     * @param other Nó a ser conectado
     */
    public void connect(Node other){
        
        nodes.add(other);
    
    }

    /**
     * Método getter do atributo nodes
     * @return Array de nós conectados
     */
    public ArrayList<Node> getNodes() {
        
        return nodes;
    
    }

    /**
     * Método getter do atributo entities
     * @return Array de entidades existentes no nó
     */
    public ArrayList<Entity> getEntities() {
        
        return entities;
        
    }
    
    /**
     * Retorna os fantasmas que estão no nó
     * @return Array de fantasmas existentes no nó
     */
    public ArrayList<Entity> getGhosts() {
        
        ArrayList<Entity> ghosts = new ArrayList<>();
        
        for (Entity entity : entities) {
            if (entity.getId() >= GameConstants.BLINKY && entity.getId() <= GameConstants.GHOSTGHOST) 
                ghosts.add(entity);
        }
        
        return ghosts;
        
    }
    
    /**
     * Retorna os fantasmas que podem ser comidos no nó
     * @return Array de fantasmas existentes no nó
     */
    public ArrayList<Entity> getBlueGhosts() {
        
        ArrayList<Entity> ghosts = new ArrayList<>();
        
        for (Entity entity : entities) {
            if (entity.getId() == GameConstants.BLUEGHOST) 
                ghosts.add(entity);
        }
        
        return ghosts;
        
    }

    /**
     * Método setter do atributo entities
     * @param entities Array de entidades que devem existir no nó
     */
    public void setEntities(ArrayList<Entity> entities) {
        
        this.entities = entities;
        
    }

    /**
     * Método que adiciona uma entidade no nó
     * @param entity Entidade a ser adicionada no nó
     */
    public void addEntity(Entity entity) {

        this.entities.add(entity);

    }

    /**
     * Método que remove uma entidade do nó
     * @param entity Entidade a ser removida do nó
     */
    public void removeEntity(Entity entity) {

        this.entities.remove(entity);

    }
    
    /**
     * Método que averigua se o Pacman está no nó
     * @return Retorna true, se o nó possuir o Pacman. Caso contrário, retorna false.
     */
    public boolean hasPacman() {

        for (Entity entity : entities)
            if (entity.getId() == GameConstants.PACMAN)
                return true;

        return false;

    }

    /**
     * Método que averigua se há um fantasma está no nó
     * @return Retorna true, se o nó possuir um fantasma. Caso contrário, retorna false.
     */
    public boolean hasGhost() {

        for (Entity entity : entities)
            if (entity.getId() >= GameConstants.BLINKY && entity.getId() <= GameConstants.GHOSTGHOST) 
                return true;

        return false;

    }

    /**
     * Método getter do atributo distance
     * @param key Chave da distância na estrutura de dados
     * @return Distância do nó até um ponto calculado
     */
    public int getDistance(String key) {
        
        return distances.get(key); 
    
    }

    /**
     * Método setter do atributo distance
     * @param key Chave da distância na estrutura de dados
     * @param distance Distância do nó até um ponto calculado
     */
    public void setDistance(String key, int distance) {
        
        distances.put(key, distance);
    
    }    

    /**
     * Método getter do atributo id
     * @return Número identificador do nó
     */
    public int getId() {
        
        return id;
        
    }

    /**
     * Método que checa se o nó pertence a uma lista de identificadores proibidos
     * @param forbiddenIds Array de identificadores proibidos
     * @return Retorna true, se o nó não pertence a lista de identificadores proibidos.
     * Caso contrário, retorna false.
     */
    public boolean notForbiddenId(ArrayList<Integer> forbiddenIds) {

        for (int id : forbiddenIds)
            if (id == this.id)
                return false;

        return true;

    }

    /**
     * Método getter do atributo consumable
     * @return Consumível existente no nó
     */
    public Consumable getConsumable() {
        
        return consumable;
        
    }

    /**
     * Método setter do atributo consumable
     * @param consumable Consumível que deve existir no nó
     */
    public void setConsumable(Consumable consumable) {
        
        this.consumable = consumable;
        
    }

    /**
     * Método getter do atributo status
     * @return Status do nó
     */
    public int getStatus() {
        
        return status;
        
    }

    /**
     * Método setter do atributo nó
     * @param status Novo status do nó
     */
    public void setStatus(int status) {
        
        this.status = status;
        
    }
    
}
