/**
 * This class represents the node of a graph. It has a info, the edges (adjacent nodes).
 * It's also important to know if a node was visited or node while traversing a graph
 *
 * @author Claudia Vaquera
 */
public class Node implements Comparable {
    private Comparable info;
    private Vector edges;
    private boolean visited;

    public Node(Comparable label) {
        this.info = label;
        this.edges = new Vector(20);
        this.visited = false;
    }

    /**
     * Adds an edge to the node
     *
     * @param e Edge
     */
    public void addEdge(Edge e) {
        this.edges.addLast(e);
    }

    /**
     * Compares the info of the node
     *
     * @param o Object
     * @return result of the comparison
     */
    public int compareTo(Object o) {
        // two nodes are equal if they have the same label
        Node n = (Node) o;
        return n.info.compareTo(this.info);
    }

    /**
     * Sets the visited value of the node
     *
     * @param state boolean
     */
    public void setVisited(boolean state) {
        this.visited = state;
    }

    /**
     * Gets the edges of the node
     *
     * @return edges
     */
    public Vector getEdges() {
        return this.edges;
    }

    /**
     * Gets the info of the node
     *
     * @return info
     */
    public Comparable getLabel() {
        return this.info;
    }

    /**
     * Gets the visited value of the node
     *
     * @return visited
     */
    public boolean getVisited() {
        return this.visited;
    }

    /**
     * Traverse the edges and creates a string representation of the node
     *
     * @return created string
     */
    public String toString() {
        String values = "\n" + this.info + ": ";
        for (int i = 0; i < this.edges.size(); i++) {
            values += this.edges.get(i) + ", ";
        }
        return values;
    }
}
