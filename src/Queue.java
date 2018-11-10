public class Queue {
    private LinkedList data;

    public Queue() {
        data = new LinkedList();
    }

    public void push(Comparable o) {
        data.addFirst(o);
    }

    public Comparable pop() {
        Comparable lastElement = data.getLast();
        data.removeLast();
        return lastElement;
    }

    public Comparable top() {
        return data.getLast();
    }

    public int size() {
        return data.size();
    }

    public String toString() {
        String s = data + " ";
        return s;
    }
}
