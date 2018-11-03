/*Claudia Vaquera*/
public class LinkedList {

    private class ListElement {
        private Object el1;
        private ListElement el2;


        public ListElement(Object el, ListElement nextElement) {
            el1 = el;
            el2 = nextElement;
        }

        /**
         * First list element
         *
         * @param el
         */

        public ListElement(Object el) {
            this(el, null);
        }

        /**
         * return value of the element
         *
         * @return
         */
        public Object first() {
            return el1;
        }

        /**
         * return next element
         *
         * @return
         */
        public ListElement rest() {
            return el2;
        }

        /**
         * set value of the element
         *
         * @param value
         */
        public void setFirst(Object value) {
            el1 = value;
        }

        /**
         * set next element
         *
         * @param value
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
     * Add first element to the list
     *
     * @param o
     */
    public void addFirst(Object o) {
        head = new ListElement(o, head);
    }

    /**
     * Get first element of the list
     *
     * @return
     */
    public Object getFirst() {
        return head.first();
    }

    /**
     * get specific element of the list using the index
     *
     * @param n
     * @return
     */
    public Object get(int n) {
        ListElement d = head;
        while (n > 0) {
            d = d.rest();
            n--;
        }
        return d.first();
    }

    /**
     * Convert linked list to string
     *
     * @return
     */
    public String toString() {
        String s = "(";
        ListElement d = head;
        while (d != null) {
            s += d.first().toString();
            s += " ";
            d = d.rest();
        }
        s += ")";
        return s;
    }

    /**
     * Get size of the list
     *
     * @return
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
     * set specific element of the list using the index
     *
     * @param n
     * @param o
     */
    public void set(int n, Object o) {
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
     * Get last element of the list
     *
     * @return
     */
    public Object getLast() {
        ListElement d = head;
        while (d.rest() != null) {
            d = d.rest();
        }
        return d.first();
    }

    /**
     * Add last element to the list
     *
     * @param o
     */
    public void addLast(Object o) {
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
     * Verify if a given object is part of the list
     *
     * @param o
     * @return
     */
    public boolean contains(Object o) {
        ListElement d = head;
        while (d != null) {
            if (d.first() == o) {
                return true;
            }
            d = d.rest();
        }
        return false;
    }

    /**
     * Remove first element of the list
     */
    public void removeFirst() {
        ListElement d = head;
        head = d.rest();
    }

    /**
     * Remove last element of the list
     */
    public void removeLast() {
        ListElement d = head;
        int n = this.size();
        while (n > 2) {
            d = d.rest();
            n--;
        }
        d.setRest(null);
    }

    /**
     * Remove a specific element of the list using the index
     *
     * @param n
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

}
