package pacman.gameElements;

public final class GameConstants {

    public static final int DOWN = 0;
    public static final int UP = 1;
    public static final int RIGHT = 2;
    public static final int LEFT = 3;

    public static final int BOARD_VERTICAL = 31;
    public static final int BOARD_HORIZONTAL = 28;

    public static final int PATH = 0;
    public static final int BLOCKED = 1;

    public static final int PACMAN = 10;
    public static final int BLINKY = 11;
    public static final int PINKY = 12;
    public static final int INKY = 13;
    public static final int CLYDE = 14;

    public static final int PACDOT = 20;
    public static final int PILL = 21;
    public static final int FRUIT = 22;

    public static final int HOME = 30;
    public static final int GATE = 31;

    public static int oppositeDirection(int direction) {

        int newDirection = UP;

        switch (direction) {
            case DOWN: {
                newDirection = UP;
                break;
            }
            case UP: {
                newDirection = DOWN;
                break;
            }
            case RIGHT: {
                newDirection = LEFT;
                break;
            }
            case LEFT: {
                newDirection = RIGHT;
                break;
            }
        }

        return newDirection;

    }
    
}
