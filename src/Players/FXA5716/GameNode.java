package Players.FXA5716;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a node on the game board.
 * @author Faizan Ahmed
 */
public class GameNode {
    /**
     * This array holds all nodes connected to this one.
     */
    private ArrayList<GameNode> connectedNodes;

    /**
     * This flag shows if the node was visited during path search.
     */
    private boolean wasVisited;

    /**
     * Constructor. Creates a new node without any connections.
     */
    public GameNode() {
        // Create list for neighbors
        connectedNodes = new ArrayList<>();

        // Set that this node was not visited
        wasVisited = false;
    }

    /**
     * Resets the 'visited' flag of this node.
     */
    public void resetVisited() {
        wasVisited = false;
    }

    /**
     * Sets the 'visited' flag of this node.
     */
    public void setVisited() {
        wasVisited = true;
    }

    /**
     * Checks if this node was visited since the last 'visited' flag reset.
     * @return true if was visited, false otherwise.
     */
    public boolean isVisited() {
        return wasVisited;
    }

    /**
     * Adds a new node to the list of connected neighbors.
     * @param neighbor - the new neighbor of this node.
     */
    public void connectTo(GameNode neighbor) {
        connectedNodes.add(neighbor);
    }

    /**
     * Returns the list of connected neighbors.
     * @return connected neighbors of this node.
     */
    public List<GameNode> getNeighbors() {
        return connectedNodes;
    }
}
