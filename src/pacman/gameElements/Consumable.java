package pacman.gameElements;

public class Consumable {
    
    private int points;
    private int id;
    
    Consumable(int id){
        
        this.id = id;
        
        switch(id){
            
            case(20): {//pacdot
                points = 10;
            }
            case(21): {//pill
                points = 50;
            }
            case(22): {//fruit
                points = 100;//+ 200*GameStatus.level
                //this.id += GameStatus.level%3
            }
            
        }
    
    }

    public int getPoints() {
        
        return points;
        
    }

    public void setPoints(int points) {
        
        this.points = points;
        
    }

    public int getId() {
        
        return id;
        
    }

    public void setId(int id) {
        
        this.id = id;
        
    }    
    
}