/**
 * This class is a simple data structure that supports only a limited set of operations.
 * A queue represents a pile of objects, it pushes a new element to the bottom and it removes only the first element
 *
 * @author Claudia Vaquera
 */
public class Queue {
    private LinkedList data;

    public Queue() {
        data = new LinkedList();
    }

    /**
     * Pushes the new elements at the bottom of the list
     *
     * @param o Comparable
     */
    public void push(Comparable o) {
        data.addFirst(o);
    }

    /**
     * Removes the top element of the queue
     *
     * @return removed element
     */
    public Comparable pop() {
        Comparable lastElement = data.getLast();
        data.removeLast();
        return lastElement;
    }

    /**
     * Gets top element of the pile
     *
     * @return last element
     */
    public Comparable top() {
        return data.getLast();
    }

    /**
     * Shows the size of the queue
     *
     * @return size
     */
    public int size() {
        return data.size();
    }

    /**
     * Shows if the queue is empty
     *
     * @return boolean, true if the queue is empty
     */
    public boolean empty() {
        return data.isEmpty();
    }

    /**
     * String representation of the data
     *
     * @return created string
     */
    public String toString() {
        String s = data + " ";
        return s;
    }
}
