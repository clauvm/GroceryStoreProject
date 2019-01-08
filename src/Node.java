public class Node implements Comparable {
    private Comparable info;
    private Vector edges;
    private boolean visited;

    public Node(Comparable label) {
        this.info = label;
        this.edges = new Vector(20);
        this.visited = false;
    }

    public void addEdge(Edge e) {
        this.edges.addLast(e);
    }

    public int compareTo(Object o) {
        // two nodes are equal if they have the same label
        Node n = (Node) o;
        return n.info.compareTo(this.info);
    }

    public void setVisited(boolean state) {
        this.visited = state;
    }

    public Vector getEdges() {
        return this.edges;
    }

    public Comparable getLabel() {
        return this.info;
    }

    public boolean getVisited() {
        return this.visited;
    }

    public String toString() {
        String values = "\n" + this.info + ": ";
        for (int i = 0; i < this.edges.size(); i++) {
            values += this.edges.get(i) + ", ";
        }
        return values;
    }
}
