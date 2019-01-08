public class Stack {
    private LinkedList data;

    public Stack() {
        data = new LinkedList();
    }

    public void push(Comparable o) {
        data.addFirst(o);
    }

    public Comparable pop() {
        Comparable firstObject = data.getFirst();
        data.removeFirst();
        return firstObject;
    }

    public Comparable top() {
        return data.getFirst();
    }

    public int size() {
        return data.size();
    }

    public boolean empty() {
        return data.isEmpty();
    }

    public String toString() {
        String s = data + " ";
        return s;
    }
}

