/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pacman;

import pacman.gameElements.Map;
import pacman.engine.Engine;
import pacman.render.Render;

/**
 *
 * @author mairacanal
 */
public class Pacman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Map map = new Map();
        
        Engine engine = new Engine(map);
        Render render = new Render(map);
        
        engine.init();              
        render.drawMap();
        
    }
    
}
