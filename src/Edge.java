public class Edge implements Comparable {
    private Node toNode;
    private Object weightNode;

    public Edge(Node to, Object weight) {
        toNode = to;
        weightNode = weight;
    }

    public int compareTo(Object o) {
        // two edges are equal if they point
        // to the same node.
        // this assumes that the edges are
        // starting from the same node !!!
        Edge n = (Edge) o;
        return n.toNode.compareTo(toNode);
    }

    public String toString() {
        return "" + toNode.getLabel() + " (" + weightNode + ")";
    }

    public Node getToNode() {
        return this.toNode;
    }


}