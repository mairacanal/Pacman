package pacman;

import pacman.gameElements.Map;
import pacman.engine.Engine;
import pacman.render.Render;

public class Pacman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Map map = new Map();
        
        Engine engine = new Engine(map);
        Render render = new Render(map);
        
        engine.init();              
        render.draw();

        while (true) {

            engine.running();
            render.draw();

        }

        // Scanner scan = new Scanner(System.in);

        // System.out.println("--------------------------- MENU ---------------------------");
        // System.out.println("Legenda:");
        // System.out.println("B, C, P, K = Fantasmas");
        // System.out.println("¢ = Pacman");
        // System.out.println("▓▓ = Parede");
        // System.out.println("Opções:");
        // System.out.println("(1) Teste da primeira etapa do projeto");
        // System.out.println("(2) Versão beta do jogo (algumas funcionalidades ainda não estão implementadas)");
        // System.out.println("------------------------------------------------------------");
        // System.out.println("Escolha sua opção: ");

        // switch (scan.nextInt()) {
        //     case (1): {
        //         break;
        //     } case (2): {
        //         break;
        //     } default: {
        //         System.out.println("Opção inválida!");
        //         break;
        //     }
        // }

    }
    
}
