public class Graph {

    private Vector nodes;

    public Graph() {
        nodes = new Vector(50);
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

    public Stack findPathTwoElements(Comparable nodeLabel1, Comparable nodeLabel2) {
        setAllNodesUnvisited();
        Node startNode = findNode(nodeLabel1);
        Node endNode = findNode(nodeLabel2);
        Dictionary parentRelation = new Dictionary();
        Dictionary distance = new Dictionary();
        Queue toDoList = new Queue();
        toDoList.push(startNode);
        startNode.setVisited(true);
        distance.add(nodeLabel1, 0);
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
                    distance.add(n.getLabel(), (Integer) e.getWeight() + (Integer) distance.find(current.getLabel()));
                }
            }

        }
        Stack path = new Stack();
        Node current = endNode;
        if (success) {
            Comparable distanceToPath = (Comparable) distance.find(current.getLabel());
            while (current != startNode) {
                path.push(current.getLabel());
                current = (Node) parentRelation.find(current);
            }
            path.push(startNode.getLabel());
            path.push(distanceToPath);
        }
        return path;
    }

    public void findPathMultipleElements(LinkedList items) {
        String startPoint = items.get(0).toString();
        String order = startPoint + ", ";
        Stack aux;
        String tempPath = "";
        int position = 0;
        while (items.size() > 1) {
            int minDist = 1000;
            String closestItem = "";
            for (int i = 1; i < items.size(); i++) {
                aux = findPathTwoElements(startPoint, items.get(i).toString());
                int distance = (Integer) aux.pop();
                if (distance < minDist) {
                    minDist = distance;
                    closestItem = items.get(i).toString();
                    aux.pop();
                    tempPath = aux.toString();
                    position = i;
                } else if (distance == minDist) {
                    Stack tempPath1 = findPathTwoElements(items.get(i).toString(), items.get(items.size() - 1).toString());
                    Stack tempPath2 = findPathTwoElements(closestItem, items.get(items.size() - 1).toString());
                    if ((Integer) tempPath1.pop() > (Integer) tempPath2.pop()) {
                        minDist = distance;
                        closestItem = items.get(i).toString();
                        aux.pop();
                        tempPath = aux.toString();
                        position = i;
                    }
                }
            }
            startPoint = closestItem;
            order += tempPath;
            items.removeByIndex(position);
        }
        System.out.println(order);
    }

    public String toString() {
        String values = "";
        for (int i = 0; i < nodes.size(); i++) {
            values += nodes.get(i);
        }
        return values;
    }

}
