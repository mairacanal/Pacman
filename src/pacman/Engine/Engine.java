package pacman.Engine;

import pacman.GameElements.Map;
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Engine {

    private Map map;

    Engine() {

        map = new Map();
        
    }

    private void readMapFile() {

        int[][] map = new int[31][28];

        try {

            File mapFile = new File("src/pacman/Resources/pacman.txt");
            Scanner scan = new Scanner(mapFile);

            for (int i = 0; i < 31; i++) 
                for (int j = 0; j < 28; j++) 
                    map[i][j] = scan.nextInt();

            scan.close();

        } catch (FileNotFoundException e) {

            System.out.println("An error occurred: " + e.getMessage());

        }

    }

    public void init() {

        readMapFile();

    }

    public void running() {

    }

    public void exit() {

    }
    
}
