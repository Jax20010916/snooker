/**
 * @author Hassan Tahir
 * @version 1.0
 *          Class to manage input in the game.
 */
public class Input {
    /**
     * Handles the input for 1 frame of the game
     * 
     * @param board KlaskBoard for which to handle inputs
     */
    public static void handleInputs(KlaskBoard board) {
        handlePlayer1Inputs(board);
        handlePlayer2Inputs(board);
    }

    private static void handlePlayer1Inputs(KlaskBoard board) {
        GameArena arena = board.getArena();
        Player player = board.getPlayer(1);
        // set velocities to 0 as default state
        player.getPlayerBall().setXVelocity(0);
        player.getPlayerBall().setYVelocity(0);
        if (arena.letterPressed('W')) {
            player.changePosition(0, -5);
            player.getPlayerBall().setYVelocity(-5);
        }
        if (arena.letterPressed('A')) {
            player.changePosition(-5, 0);
            player.getPlayerBall().setXVelocity(-5);
        }
        if (arena.letterPressed('S')) {
            player.changePosition(0, 5);
            player.getPlayerBall().setYVelocity(5);
        }
        if (arena.letterPressed('D')) {
            player.changePosition(5, 0);
            player.getPlayerBall().setXVelocity(5);
        }
    }

    private static void handlePlayer2Inputs(KlaskBoard board) {
        GameArena arena = board.getArena();
        Player player = board.getPlayer(2);
        // set velocities to 0 as default state
        player.getPlayerBall().setXVelocity(0);
        player.getPlayerBall().setYVelocity(0);
        if (arena.upPressed()) {
            player.changePosition(0, -5);
            player.getPlayerBall().setYVelocity(-5);
        }
        if (arena.leftPressed()) {
            player.changePosition(-5, 0);
            player.getPlayerBall().setXVelocity(-5);
        }
        if (arena.downPressed()) {
            player.changePosition(0, 5);
            player.getPlayerBall().setYVelocity(5);
        }
        if (arena.rightPressed()) {
            player.changePosition(5, 0);
            player.getPlayerBall().setXVelocity(5);
        }
    }
}