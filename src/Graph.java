/**
 * A graph consists of a set of nodes and connections between the nodes
 * Nodes are stored in a vector
 *
 * @author Claudia Vaquera
 */
public class Graph {

    private Vector nodes;

    public Graph() {
        nodes = new Vector(30);
    }

    /**
     * Adds a node to the graph.
     * This method verifies if the new node is already in the list, if it isn't, then it's added to the nodes
     *
     * @param label Comparable
     */
    public void addNode(Comparable label) {
        if (nodes.contains(new Node(label)) == null) {
            nodes.addLast(new Node(label));
        } else {
            System.out.println("Duplicated Node");
        }
    }

    /**
     * Gets the nodes in the graph
     *
     * @return nodes
     */
    public Vector getNodes() {
        return this.nodes;
    }

    /**
     * Finds a node in nodes
     *
     * @param nodeLabel Comparable
     * @return found node
     */
    public Node findNode(Comparable nodeLabel) {
        return (Node) nodes.contains(new Node(nodeLabel));
    }

    /**
     * If both nodes are valid, then the edge is added to the graph
     *
     * @param nodeLabel1 Comparable
     * @param nodeLabel2 Comparable
     * @param weight     Object
     */
    public void addEdge(Comparable nodeLabel1, Comparable nodeLabel2, Object weight) {
        Node n1 = findNode(nodeLabel1);
        Node n2 = findNode(nodeLabel2);
        if (n1 != null && n2 != null) {
            n1.addEdge(new Edge(n2, weight));
        } else {
            System.out.println("Invalid node");
        }
    }

    /**
     * Sets all nodes unvisited, this is important to avoid cycles when looking for a path
     */
    private void setAllNodesUnvisited() {
        for (int i = 0; i < nodes.size(); i++) {
            Node current = (Node) nodes.get(i);
            current.setVisited(false);
        }
    }

    /**
     * Shortest path between two nodes. this method creates a parent relation,
     * this helps to show the complete path; it also has a distance, this is important when
     * looking for a path passing for multiple nodes
     *
     * @param nodeLabel1 Comparable
     * @param nodeLabel2 Comparable
     * @return path
     */
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
        boolean nodeFound = false;
        while (!toDoList.empty()) {
            Node current = (Node) toDoList.pop();
            if (current == endNode) {
                nodeFound = true;
                break;
            }
            for (int i = 0; i < current.getEdges().size(); i++) {
                Edge e = (Edge) current.getEdges().get(i);
                Node n = e.getToNode();
                if (!n.getVisited()) {
                    toDoList.push(n);
                    n.setVisited(true);
                    parentRelation.add(n, current);

                    /* The distance of a node is the result of adding the weight of the edge and the distance of its parent*/
                    distance.add(n.getLabel(), (Integer) e.getWeight() + (Integer) distance.find(current.getLabel()));
                }
            }
        }
        Stack path = new Stack();
        Node current = endNode;
        if (nodeFound) {

            /* Distance of the path is the distance obtained in the end node */
            Comparable distanceToPath = (Comparable) distance.find(current.getLabel());

            /* Create the complete path*/
            while (current != startNode) {
                path.push(current.getLabel());
                current = (Node) parentRelation.find(current);
            }
            path.push(startNode.getLabel());

            /* Push the path's distance because it's important for another method */
            path.push(distanceToPath);
        }
        return path;
    }

    /**
     * This method finds the shortest path that passes through a group of nodes. In order to get the shortest path,
     * it looks for the shortest path between a starting point and the rest of the items, it uses the previous method
     * to find the shortest path. Then it selects the minimum distance obtained, so that item is the next
     * starting point and it's also removed from the items list
     *
     * @param items LinkedList
     * @return final path
     */
    public String findPathMultipleElements(LinkedList items) {
        String startPoint = items.get(0).toString();
        String route = startPoint + ", ";
        Stack tempPath;
        String tempRoute = "";      //temporary path
        int position = 0;
        String closestItem = "";
        while (items.size() > 2) {
            int minDist = 1000;         //random minimum distance
            closestItem = "";
            for (int i = 1; i < items.size() - 1; i++) {
                tempPath = findPathTwoElements(startPoint, items.get(i).toString());
                int distance = (Integer) tempPath.pop();
                int tempDistPath1 = 0;
                int tempDistPath2 = 0;

                /* if two paths have the same distance, the one selected will be the furthest from the end item */
                if (distance == minDist) {
                    Stack tempPath1 = findPathTwoElements(items.get(i).toString(), items.get(items.size() - 1).toString());
                    Stack tempPath2 = findPathTwoElements(closestItem, items.get(items.size() - 1).toString());
                    tempDistPath1 = (Integer) tempPath1.pop();
                    tempDistPath2 = (Integer) tempPath2.pop();
                }
                if (distance < minDist || tempDistPath1 > tempDistPath2) {
                    minDist = distance;
                    closestItem = items.get(i).toString();
                    tempPath.pop();
                    tempRoute = tempPath.toString();
                    position = i;
                }
            }
            startPoint = closestItem;
            route += tempRoute;
            items.removeByIndex(position);
        }

        /* find a path between the last item visited in the path obtained above and the last item in the list */
        tempPath = findPathTwoElements(closestItem, items.get(items.size() - 1).toString());
        tempPath.pop();     //pop the distance
        tempPath.pop();     //pop the first element because it's already in the route
        route += tempPath.toString();
        return route;
    }

    /**
     * Traverse the nodes and creates a string representation of the nodes
     *
     * @return created string
     */
    public String toString() {
        String values = "";
        for (int i = 0; i < nodes.size(); i++) {
            values += nodes.get(i);
        }
        return values;
    }

}
