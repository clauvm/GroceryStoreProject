
public class DictionaryPair implements Comparable {

    private Comparable key;
    private Object value;

    public DictionaryPair(Comparable someKey, Object someValue) {
        this.key = someKey;
        this.value = someValue;
    }

    public Comparable getKey() {
        return key;

    }

    public Object getValue() {
        return value;
    }

    public void setKey(Comparable newKey) {
        this.key = newKey;
    }

    public void setValue(Object newValue) {
        this.value = newValue;
    }

    public int compareTo(Object o) {
        DictionaryPair newPair = (DictionaryPair) o;
        return ((Comparable) key).compareTo(newPair.key);
    }

    public String toString() {
        String values = this.value + "\n";
        return values;
    }
}

