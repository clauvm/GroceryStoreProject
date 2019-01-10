/**
 * This class allows storing data in a simple way, it needs a specific capacity
 *
 * @author Claudia Vaquera
 */
public class Vector {
    protected Comparable data[];
    protected int count;

    public Vector(int capacity) {
        data = new Comparable[capacity];
        count = 0;
    }

    /**
     * Returns the size of the vector, this is different of the capacity
     *
     * @return count
     */
    public int size() {
        return count;
    }

    /**
     * This method is to know if the vector is empty
     *
     * @return boolean, true if size is equal to 0
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Gets the data in a specific position
     *
     * @param index int
     * @return data
     */
    public Comparable get(int index) {
        return data[index];
    }

    /**
     * Sets the data in a specific position
     *
     * @param index int
     * @param obj   Comparable
     */
    public void set(int index, Comparable obj) {
        data[index] = obj;
    }

    /**
     * Verifies is the vector contains the object provided
     *
     * @param obj Comparable
     * @return data or null if the object is not in the vector
     */
    public Comparable contains(Comparable obj) {
        for (int i = 0; i < count; i++) {
            if (data[i].compareTo(obj) == 0) {
                return data[i];
            }
        }
        return null;
    }

    /**
     * Adds a new item in the first position
     *
     * @param vectorLength int
     * @param item Comparable
     */
    public void addFirst(int vectorLength, Comparable item) {
        if (count == vectorLength) {
            System.out.println("sorry, the vector is full and it's not possible to add an item in the first position");
        } else {
            for (int i = count; i > 0; i--) {
                data[i] = data[i - 1];
            }
            data[0] = item;
            count++;
        }

    }

    /**
     * Adds a new item in the last position
     *
     * @param item Comparable
     */
    public void addLast(Comparable item) {
        data[count] = item;
        count++;
    }

    /**
     * Gets first element of the vector
     *
     * @return element
     */
    public Comparable getFirst() {
        return data[0];
    }

    /**
     * Gets last element of the vector
     *
     * @return last element
     */
    public Comparable getLast() {
        return data[count - 1];
    }

    /**
     * Removes last element of the vector
     */
    public void removeLast() {
        data[count - 1] = null;
        count--;
    }

    /**
     * Removes first element of the vector
     */
    public void removeFirst() {
        for (int i = 0; i < count; i++) {
            data[i] = data[i + 1];
        }
        count--;
    }

    /**
     * Reverses the vector
     */
    public void reverse() {
        int j = count - 1;
        for (int i = 0; i < count / 2; i++) {
            Comparable intermediate = data[i];
            data[i] = data[j];
            data[j] = intermediate;
            j--;
        }
    }

    /**
     * traverse the list and creates a string representation of the vector
     *
     * @return created string
     */
    public String toString() {
        String values = "";
        for (int i = 0; i < count; i++) {
            values += data[i] + " ";
        }
        return values;
    }


}
