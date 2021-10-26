package pacman.gameElements;

public class Map {
    
    private Node[][] nodes;
    private boolean modified;
    
    public Map(){
        
        this.nodes = new Node[31][28];
    
    }
    
    public Node getNode(int i, int j) {
        
        return nodes[i][j];
        
    }
        
    public Node[][] getNodes() {
        
        return nodes;
    
    }
    
    public void build(int[][] matrix){   
        
        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 28; j++) {
                
                int id = matrix[i][j];
                nodes[i][j] =  new Node(id, new Consumable(id));
            
            }
        }
        
    }
    
    public void linkAll(){
        
        for(int i = 0; i < 31; i++) {
            
            for(int j = 0; j < 28; j++) {
                
                this.nodes[i][j].connect(this.nodes[(i + 1) % 31][j]);           
                this.nodes[i][j].connect(this.nodes[(i + 31 - 1) % 31][j]);       
                this.nodes[i][j].connect(this.nodes[i][(j + 1) % 28]);        
                this.nodes[i][j].connect(this.nodes[i][(j + 28 - 1) % 28]); 
                     
            }
            
        }
        
    }
    
}
