public class Graph {

    private Vector nodes;

    public Graph() {
        nodes = new Vector(20);
    }

    public void addNode(Comparable label) {
        if (nodes.contains(new Node(label)) == null) {
            nodes.addLast(new Node(label));
        } else {
            System.out.println("Duplicated Node");
        }
    }

    public Vector getNodes() {
        return this.nodes;
    }

    public Node findNode(Comparable nodeLabel) {
        return (Node) nodes.contains(new Node(nodeLabel));
    }

    public void addEdge(Comparable nodeLabel1, Comparable nodeLabel2, Object weight) {
        Node n1 = findNode(nodeLabel1);
        Node n2 = findNode(nodeLabel2);
        if (n1 != null && n2 != null) {
            n1.addEdge(new Edge(n2, weight));
        } else {
            System.out.println("Invalid node");
        }
    }

    public void setAllNodesUnvisited() {
        for (int i = 0; i < nodes.size(); i++) {
            Node current = (Node) nodes.get(i);
            current.setVisited(false);
        }
    }

    public Stack findPath2(Comparable nodeLabel1, Comparable nodeLabel2) {
        setAllNodesUnvisited();
        Node startNode = findNode(nodeLabel1);
        Node endNode = findNode(nodeLabel2);
        Dictionary parentRelation = new Dictionary();
        Queue toDoList = new Queue();
        toDoList.push(startNode);
        startNode.setVisited(true);
        boolean success = false;
        while (!toDoList.empty()) {
            Node current = (Node) toDoList.pop();
            if (current == endNode) {
                success = true;
                break;
            }
            for (int i = 0; i < current.getEdges().size(); i++) {
                Edge e = (Edge) current.getEdges().get(i);
                Node n = e.getToNode();
                if (!n.getVisited()) {
                    toDoList.push(n);
                    n.setVisited(true);
                    parentRelation.add(n, current);
                }
            }

        }
        Stack path = new Stack();
        Node current = endNode;
        if (success) {
            while (current != startNode) {
                path.push(current.getLabel());
                current = (Node) parentRelation.find(current);
            }
            path.push(startNode.getLabel());
        }
        return path;
    }

    public String toString() {
        String values = "";
        for (int i = 0; i < nodes.size(); i++) {
            values += nodes.get(i);
        }
        return values;
    }

}
