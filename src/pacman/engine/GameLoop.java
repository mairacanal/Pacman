package pacman.engine;

import java.util.ArrayList;
import pacman.gameElements.Entity;

public class GameLoop {
    
    private ArrayList<Entity> entities;
    
    GameLoop(ArrayList<Entity> entities) {

        this.entities = entities;
        
    }

    public void init() {

        for (Entity entity : entities)
            entity.born();

    }
    
    public void loop() {

        for (Entity entity : entities)
            entity.move();

    }
    
}
