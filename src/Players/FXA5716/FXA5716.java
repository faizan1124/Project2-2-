//
// My Player class
//

package Players.FXA5716; // TODO: rename the package

import Interface.PlayerModulePart1;
import Interface.PlayerMove;

/**
 * This class represents my player for the Pathfinder game.
 * Basically the game board is a graph where the nodes are players positions
 * and the edges are connecting links between them.
 * @author Faizan Ahmed
 */
public class FXA5716 implements PlayerModulePart1 {
    /**
     * This is the dimensions of the board.
     */
    private int dimensions;

    /**
     * This is the inner representation of the board.
     */
    private GameBoard gameBoard;

    /**
     * This is the game ID of this player.
     */
    private int myPlayerId;

    @Override
    public boolean hasWonGame( int id ) {
        // Reset visited flags so previous state won't interfere
        gameBoard.resetVisitedAll();

        // Try to find path from each node of one side
        for (int i = 1; i < dimensions * 2; i += 2) {
            // Choose if we're iterating over columns or row based on player
            if (id == 1) {
                // For red player, we're starting from the left side of the board
                gameBoard.visitStartingFrom(i, 0);
            } else if (id == 2) {
                // For blue player, we're starting from the top side of the board
                gameBoard.visitStartingFrom(0, i);
            }
        }

        // Now check if at least one node on the opposite side is reachable from the start
        for (int i = 1; i < dimensions * 2; i += 2) {
            // Choose if we're iterating over columns or row based on player
            if (id == 1) {
                // For red player, we're checking the right side of the board
                if (gameBoard.wasNodeVisited(i, dimensions * 2)) {
                    return true;
                }
            } else if (id == 2) {
                // For blue player, we're checking the bottom side of the board
                if (gameBoard.wasNodeVisited(dimensions * 2, i)) {
                    return true;
                }
            }
        }

        // If we reached here, the player did not win yet
        return false;
    }

    @Override
    public void initPlayer( int dim, int playerId ) {
        // Remember dimensions and player id
        dimensions = dim;
        myPlayerId = playerId;

        // Create the board
        gameBoard = new GameBoard(dim);
    }

    @Override
    public void lastMove( PlayerMove playerMove ) {
        // Extract coordinates from the move info structure
        int moveRow = playerMove.getCoordinate().getRow();
        int moveCol = playerMove.getCoordinate().getCol();

        // Check what player did the move, and find out which nodes should be connected
        if (playerMove.getPlayerId() == 1) {
            // Check which nodes should be connected for red player
            if (moveCol % 2 == 1) {
                // For red player, if the cell has odd coordinates, the move was horizontal
                gameBoard.linkNodes(moveRow, moveCol - 1, moveRow, moveCol + 1);
            } else {
                // For red player, if the cell has even coordinates, the move was vertical
                gameBoard.linkNodes(moveRow - 1, moveCol, moveRow + 1, moveCol);
            }
        } else if (playerMove.getPlayerId() == 2) {
            // Check which nodes should be connected for blue player
            if (moveCol % 2 == 1) {
                // For blue player, if the cell has odd coordinates, the move was vertical
                gameBoard.linkNodes(moveRow - 1, moveCol, moveRow + 1, moveCol);
            } else {
                // For blue player, if the cell has even coordinates, the move was horizontal
                gameBoard.linkNodes(moveRow, moveCol - 1, moveRow, moveCol + 1);
            }
        }
    }

    @Override
    public void otherPlayerInvalidated() {
        // TODO: in part 2.
    }

    @Override
    public PlayerMove move() {

        // TODO: use internal documentation to describe your algorithm.

        // TODO: you will need to add private methods as helpers.
        // TODO: you may also need to add other .java files to your package.
        // TODO: in part 2.

        return null;
    }
}