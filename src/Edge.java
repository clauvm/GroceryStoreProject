/**
 * Edge class, represents the connection between two nodes, toNode is the destination node
 * it also has a weight
 *
 * @author Claudia Vaquera
 */
public class Edge implements Comparable {
    private Node toNode;
    private Object weight;

    public Edge(Node to, Object weightEdge) {
        toNode = to;
        weight = weightEdge;
    }

    /**
     * Gets the destination node
     *
     * @return node
     */
    public Node getToNode() {
        return this.toNode;
    }

    /**
     * Gets the weight of the edge
     *
     * @return weight
     */
    public Object getWeight() {
        return this.weight;
    }

    /**
     * Compare de destination node
     *
     * @return the result of the comparison
     */
    public int compareTo(Object o) {
        /* two edges are equal if they point
         * to the same node.
         * this assumes that the edges are
         * starting from the same node
         */
        Edge n = (Edge) o;
        return n.toNode.compareTo(toNode);
    }

    /**
     * traverse the list and creates a string representation of the dictionary
     *
     * @return created string
     */
    public String toString() {
        return "" + toNode.getLabel() + " (" + weight + ")";
    }
}