/**
 * This class is a simple data structure that supports only a limited set of operations.
 * A stack represents a pile of objects and only the top of the pile can be manipulated
 *
 * @author Claudia Vaquera
 */
public class Stack {
    private LinkedList data;

    public Stack() {
        data = new LinkedList();
    }

    /**
     * Pushes the new element at the top of the pile
     *
     * @param o Comparable
     */
    public void push(Comparable o) {
        data.addFirst(o);
    }

    /**
     * Removes the top element of the pile
     *
     * @return removed element
     */
    public Comparable pop() {
        Comparable firstObject = data.getFirst();
        data.removeFirst();
        return firstObject;
    }

    /**
     * Gets top element of the pile
     *
     * @return first element
     */
    public Comparable top() {
        return data.getFirst();
    }

    /**
     * Shows the size of the stack
     *
     * @return size
     */
    public int size() {
        return data.size();
    }

    /**
     * Shows if the stack is empty
     *
     * @return boolean, true if the stack is empty
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

