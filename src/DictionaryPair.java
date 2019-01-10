/**
 * Dictionary Pair class, this has a key and a value
 *
 * @author Claudia Vaquera
 */
public class DictionaryPair implements Comparable {

    private Comparable key;
    private Object value;

    public DictionaryPair(Comparable someKey, Object someValue) {
        this.key = someKey;
        this.value = someValue;
    }

    /**
     * Gets the key of the dictionary pair
     *
     * @return key
     */
    public Comparable getKey() {
        return key;
    }

    /**
     * Gets the value of the dictionary pair
     *
     * @return value
     */
    public Object getValue() {
        return value;
    }

    /**
     * Sets the value of the dictionary pair
     *
     * @param newValue Object
     */
    public void setValue(Object newValue) {
        this.value = newValue;
    }

    /**
     * Compares the key
     *
     * @param o Object
     * @return result of the comparison
     */
    public int compareTo(Object o) {
        DictionaryPair newPair = (DictionaryPair) o;
        return ((Comparable) key).compareTo(newPair.key);
    }

    /**
     * creates a string representation of the dictionary pair
     *
     * @return created string
     */
    public String toString() {
        return this.value + "\n";
    }
}

