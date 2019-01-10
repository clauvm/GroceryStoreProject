/**
 * This class represents a data structure which stores data in a linear manner.
 * It can grow and shrink dynamically
 *
 * @author Claudia Vaquera
 */
public class LinkedList {

    /**
     * List elements
     */
    private class ListElement {
        private Comparable el1;
        private ListElement el2;


        public ListElement(Comparable el, ListElement nextElement) {
            el1 = el;
            el2 = nextElement;
        }

        /**
         * Gets the first element of list
         *
         * @param el Comparable
         */

        public ListElement(Comparable el) {
            this(el, null);
        }

        /**
         * Returns the value of the element
         *
         * @return value
         */
        public Comparable first() {
            return el1;
        }

        /**
         * Returns next element
         *
         * @return next
         */
        public ListElement rest() {
            return el2;
        }

        /**
         * Sets value of the element
         *
         * @param value Comparable
         */
        public void setFirst(Comparable value) {
            el1 = value;
        }

        /**
         * Sets next element
         *
         * @param value ListElement
         */
        public void setRest(ListElement value) {
            el2 = value;
        }
    }

    private ListElement head;

    /**
     * Set head to null
     */
    public LinkedList() {
        head = null;
    }

    /**
     * Adds first element to the list
     *
     * @param o Comparable
     */
    public void addFirst(Comparable o) {
        head = new ListElement(o, head);
    }

    /**
     * Gets first element of the list
     *
     * @return first
     */
    public Comparable getFirst() {
        return head.first();
    }

    /**
     * Gets specific element of the list using the index
     *
     * @param n int
     * @return first element
     */
    public Comparable get(int n) {
        ListElement d = head;
        while (n > 0) {
            d = d.rest();
            n--;
        }
        return d.first();
    }

    /**
     * Converts linked list to string
     *
     * @return created string
     */
    public String toString() {
        String s = "";
        ListElement d = head;
        while (d != null) {
            s += d.first().toString();
            s += ", ";
            d = d.rest();
        }
        return s;
    }

    /**
     * Gets size of the list
     *
     * @return size
     */
    public int size() {
        int size = 0;
        ListElement d = head;
        while (d != null) {
            size++;
            d = d.rest();
        }
        return size;
    }

    /**
     * Sets specific element of the list using the index
     *
     * @param n int
     * @param o Comparable
     */
    public void set(int n, Comparable o) {
        int count = 1;
        ListElement d = head;
        while (d != null) {
            if (n == count) {
                d.setFirst(o);
                break;
            }
            d = d.rest();
            count++;
        }
    }

    /**
     * Gets last element of the list
     *
     * @return value of the last element
     */
    public Comparable getLast() {
        ListElement d = head;
        while (d.rest() != null) {
            d = d.rest();
        }
        return d.first();
    }

    /**
     * Adds last element to the list
     *
     * @param o Comparable
     */
    public void addLast(Comparable o) {
        ListElement d = head;
        if (d == null) {
            addFirst(o);
        } else {
            while (d.rest() != null) {
                d = d.rest();
            }
            d.el2 = new ListElement(o);
        }

    }

    /**
     * Verifies if a given Comparable is part of the list
     *
     * @param o Comparable
     * @return index of the element, -1 if the elements is not in the list
     */
    public int contains(Comparable o) {
        ListElement d = head;
        int index = 0;
        while (d != null) {
            if (d.first().compareTo(o) == 0) {
                return index;
            }
            d = d.rest();
            index++;
        }
        return -1;
    }

    /**
     * Removes first element of the list
     */
    public void removeFirst() {
        ListElement d = head;
        head = d.rest();
    }

    /**
     * Removes last element of the list
     */
    public void removeLast() {
        ListElement d = head;
        int n = this.size();
        if (n > 1) {
            while (n > 2) {
                d = d.rest();
                n--;
            }
            d.setRest(null);
        } else {
            head = null;
        }

    }

    /**
     * Removes a specific element of the list using the index
     *
     * @param n int
     */

    public void removeByIndex(int n) {
        ListElement d = head;
        int count = 0;
        if (n == 0) {
            this.removeFirst();
        } else if (n == this.size() - 1) {
            this.removeLast();
        } else if (n < this.size()) {
            while (count < n - 1) {
                count++;
                d = d.rest();
            }
            ListElement aux = d.rest();
            d.el2 = aux.rest();
        }
    }

    /**
     * This method is to know if the vector is empty
     *
     * @return boolean, true if size is equal to 0
     */
    public boolean isEmpty() {
        return size() == 0;
    }
}
