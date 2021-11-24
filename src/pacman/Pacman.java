/**
 * @file Pacman.java
 * @author Maíra Canal (N USP: 11819403)
 */

package pacman;

import pacman.gameElements.Map;
import pacman.engine.Engine;
import pacman.render.Render;
import java.util.Scanner;

public class Pacman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Map map = new Map();
        
        Engine engine = new Engine(map);
        Render render = new Render(map);

        Scanner scan = new Scanner(System.in);

        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.println("O jogo apresentado é uma versão beta da versão final do jogo");
        System.out.println("Entre todas as funcionalidades que devem ser implementadas, as seguintes funcionalidades ainda não funcionam:");
        System.out.println("- O Pacman move-se de forma aleatória no tabuleiro, sem input do usuário");
        System.out.println("- O Blinky e o Pinky ainda movem-se na mesma velocidade");
        System.out.println("- Apesar do Pacman comer as pílulas de energia, elas ainda não funcionam");
        System.out.println("- Frutas bônus ainda não aparecem no tabuleiro");
        System.out.println("As demais funcionalidades já funcionam como esperado, apesar de alguns pequenos bugs que serão consertados para parte 2");
        System.out.println("IMPORTANTE: O professor Robson autorizou a entrega do jogo dessa forma");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Clique em Enter para continuar");

        scan.nextLine();

        engine.init();              
        render.draw();

        while (true) {

            engine.running();
            render.draw();

        }

    }
    
}
