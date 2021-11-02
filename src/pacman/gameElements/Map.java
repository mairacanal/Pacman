package pacman.gameElements;

public class Map {
    
    private Node[][] nodes;
    private boolean modified;

    private final int BOARD_VERTICAL = GameConstants.BOARD_VERTICAL;
    private final int BOARD_HORIZONTAL = GameConstants.BOARD_HORIZONTAL;
    
    public Map(){
        
        this.nodes = new Node[BOARD_VERTICAL][BOARD_HORIZONTAL];
    
    }
    
    public Node getNode(int i, int j) {
        
        return nodes[i][j];
        
    }
        
    public Node[][] getNodes() {
        
        return nodes;
    
    }
    
    public void linkAll(){
        
        for(int i = 0; i < BOARD_VERTICAL; i++) {
            
            for(int j = 0; j < BOARD_VERTICAL; j++) {
                
                nodes[i][j].connect(nodes[(i + 1) % BOARD_VERTICAL][j]);           
                nodes[i][j].connect(nodes[(i + BOARD_VERTICAL - 1) % BOARD_VERTICAL][j]);       
                nodes[i][j].connect(nodes[i][(j + 1) % BOARD_HORIZONTAL]);        
                nodes[i][j].connect(nodes[i][(j + BOARD_HORIZONTAL - 1) % BOARD_HORIZONTAL]); 
                     
            }
            
        }
        
    }
    
    public void build(int[][] matrix){   
        
        for (int i = 0; i < BOARD_VERTICAL; i++) {
            
            for (int j = 0; j < BOARD_HORIZONTAL; j++) {
                
                int id = matrix[i][j];
                nodes[i][j] =  new Node(id, new Consumable(id));
            
            }
            
        }
        
        linkAll();
        
    }  
    
}
