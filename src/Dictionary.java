public class Dictionary {
    private LinkedList data;

    public Dictionary() {
        data = new LinkedList();
    }

    public void add(Comparable key, Object value) {
        DictionaryPair newPair = new DictionaryPair(key, value);
        data.addFirst(newPair);
    }

    public int findPosition(Comparable key) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).compareTo(key) == 0) {
                return i;
            }
        }
        return -1;
    }

    public Object find(Comparable key) {
        DictionaryPair test = new DictionaryPair(key, "");
        int position = findPosition(test);
        if (position >= 0) {
            DictionaryPair pair = (DictionaryPair) data.get(position);
            return pair.getValue();
        }
        return null;
    }

    public void remove(Comparable key) {
        DictionaryPair test = new DictionaryPair(key, "");
        int position = findPosition(test);
        data.removeByIndex(position);
    }

    public int size() {
        return data.size();
    }

    public Object get(int position) {
        DictionaryPair pair = (DictionaryPair) data.get(position);
        return pair.getValue();
    }

    public String toString() {
        String values = "";
        for (int i = 0; i < data.size(); i++) {
            values += data.get(i) + " ";
        }
        return values;
    }
}