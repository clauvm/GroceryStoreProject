/**
 * Dictionary class, this class maps keys to values, it uses linked list to store the data
 *
 * @author Claudia Vaquera
 */
public class Dictionary {
    private LinkedList data;

    public Dictionary() {
        data = new LinkedList();
    }

    /**
     * This method add a new Dictionary Pair to the list
     *
     * @param key   Comparable
     * @param value Object
     */
    public void add(Comparable key, Object value) {
        DictionaryPair newPair = new DictionaryPair(key, value);
        data.addFirst(newPair);
    }

    /**
     * This method finds the position of a value in the list using the value's key
     *
     * @param key Comparable
     * @return the position of the value, or -1 if the key is not in the list
     */
    public int findPosition(Comparable key) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).compareTo(key) == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Uses the key of a value to find it in the list
     *
     * @param key Comparable
     * @return the value found, or null if the key is not in the list
     */
    public Object find(Comparable key) {
        DictionaryPair test = new DictionaryPair(key, "");
        int position = findPosition(test);
        if (position >= 0) {
            DictionaryPair pair = (DictionaryPair) data.get(position);
            return pair.getValue();
        }
        return null;
    }

    /**
     * Look for a value in the list, using the key, and remove it
     *
     * @param key Comparable
     */
    public void removeByIndex(Comparable key) {
        DictionaryPair test = new DictionaryPair(key, "");
        int position = findPosition(test);
        data.removeByIndex(position);
    }

    /**
     * Remove the first element in the list
     */
    public void remove() {
        data.removeFirst();
    }

    /**
     * Gets the size of the list
     *
     * @return size
     */
    public int size() {
        return data.size();
    }

    /**
     * Gets a dictionary pair using a position
     *
     * @param position int
     * @return value of the dictionary pair
     */
    public Object get(int position) {
        DictionaryPair pair = (DictionaryPair) data.get(position);
        return pair.getValue();
    }

    /**
     * traverse the list and creates a string representation of the dictionary
     *
     * @return created string
     */
    public String toString() {
        String values = "";
        for (int i = 0; i < data.size(); i++) {
            values += data.get(i) + " ";
        }
        return values;
    }
}