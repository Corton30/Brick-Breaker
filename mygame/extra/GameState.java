package mygame.extra;

/**
 * The GameState enum represents the different states that a game can be in.
 * It is used to control the flow and logic of the game based on its current state.
 */
public enum GameState {
    /**
     * The RUNNING state indicates that the game is currently in progress.
     */
    RUNNING,

    /**
     * The PAUSED state indicates that the game is currently paused.
     */
    PAUSED,

    /**
     * The GAME_OVER state indicates that the game has ended with the player losing.
     */
    GAME_OVER,

    /**
     * The GAME_WON state indicates that the game has ended with the player winning.
     */
    GAME_WON
}