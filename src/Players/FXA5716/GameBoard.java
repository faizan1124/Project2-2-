package Players.FXA5716;

/**
 * This class represents a game board for the game as a graph.
 * The nodes are players positions on the game board, and the edges are connecting links between them.
 * @author Faizan Ahmed
 */
public class GameBoard {
    /**
     * This is the nodes of the board.
     */
    private GameNode[][] gameNodes;

    /**
     * Constructor. Creates board with the given dimentions. (Actual size is (2 * dim + 1) x (2 * dim + 1).
     * @param dim - dimesions of the board.
     */
    public GameBoard(int dim) {
        // Initialize the node objects
        gameNodes = new GameNode[2 * dim + 1][2 * dim + 1];
        for (int i = 0; i < gameNodes.length; i++) {
            for (int j = 0; j < gameNodes[i].length; j++) {
                gameNodes[i][j] = new GameNode();
            }
        }
    }

    /**
     * Resets 'visited' flags for all nodes on the board.
     */
    public void resetVisitedAll() {
        for (GameNode[] rowNodes : gameNodes) {
            for (GameNode node : rowNodes) {
                node.resetVisited();
            }
        }
    }

    /**
     * Checks if the node at the given position was visited since last flag reset.
     * @param row - row where the node is located.
     * @param col - column where the node is located.
     * @return true if the node was visited, false otherwise.
     */
    public boolean wasNodeVisited(int row, int col) {
        return gameNodes[row][col].isVisited();
    }

    /**
     * Creates bidirectional link between two nodes.
     * @param row1 - row where the first node is located.
     * @param col1 - column where the first node is located.
     * @param row2 - row where the second node is located.
     * @param col2 - column where the second node is located.
     */
    public void linkNodes(int row1, int col1, int row2, int col2) {
        // Get both nodes objects
        GameNode node1 = gameNodes[row1][col1];
        GameNode node2 = gameNodes[row2][col2];

        // Create link between both of them
        node1.connectTo(node2);
        node2.connectTo(node1);
    }

    /**
     * Marks all nodes reachable from this node as visited.
     * @param row - row where the node is located.
     * @param col - column where the node is located.
     */
    public void visitStartingFrom(int row, int col) {
        // Use inner helper method to visit node and it's connected neighbors
        visitNodeAndNeighbors(gameNodes[row][col]);
    }

    /**
     * Marks given node and its connected neighbors as visited.
     * @param node - node to visit.
     */
    private void visitNodeAndNeighbors(GameNode node) {
        // If the node was already visited - do nothing
        if (node.isVisited()) {
            return;
        }

        // Mark the node itself as visited
        node.setVisited();

        // Visit all neighbors
        for (GameNode neighbor: node.getNeighbors()) {
            visitNodeAndNeighbors(neighbor);
        }
    }
}
