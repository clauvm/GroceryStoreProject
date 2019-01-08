public class Vector {
    protected Comparable data[];
    protected int count;

    public Vector(int capacity) {
        data = new Comparable[capacity];
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {

        return size() == 0;
    }

    public Comparable get(int index) {
        return data[index];
    }

    public void set(int index, Comparable obj) {
        data[index] = obj;
    }

    public Comparable contains(Comparable obj) {
        for (int i = 0; i < count; i++) {
            if (data[i].compareTo(obj) == 0) {
                return data[i];
            }
        }
        return null;
    }

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

    public void addLast(Comparable item) {
        data[count] = item;
        count++;
    }

    //    public boolean binarySearch(Object key){
//        int start = 0;
//        int end = count - 1;
//        while(start <= end){
//            int middle = (start + end + 1)/2;
//            if(key < data[middle]){
//                end = middle - 1;
//            }
//            else if (key > data[middle]){
//                start = middle + 1;
//            }
//            else
//                return true;
//        }
//        return false;
//    }
    public Comparable getFirst() {
        return data[0];
    }

    public Comparable getLast() {
        return data[count - 1];
    }

    public void removeLast() {
        data[count - 1] = null;
        count--;
    }

    public void removeFirst() {
        for (int i = 0; i < count; i++) {
            data[i] = data[i + 1];
        }
        count--;
    }

    public void addItem(Comparable item) {
        data[count] = item;
        count++;
    }

    public void reverse() {
        int j = count - 1;
        for (int i = 0; i < count / 2; i++) {
            Comparable intermediate = data[i];
            data[i] = data[j];
            data[j] = intermediate;
            j--;
        }
    }

    public Vector mirror() {
        Vector v2 = new Vector(count * 2);
        for (int i = 0; i < count; i++) {
            v2.addLast(this.data[i]);
            v2.addLast(this.data[i]);
        }
        return v2;
    }

    public Vector interleave(Vector secondVector) {
//        int j = secondVector.size()-1;
        Vector v4 = new Vector(secondVector.size() + this.size());
        int currentSize = 0;
        if (secondVector.size() > this.size()) {
            currentSize = secondVector.size();
        } else {
            currentSize = this.size();
        }
        for (int i = 0; i < currentSize; i++) {
            v4.addLast(this.data[i]);
            v4.addLast(secondVector.data[i]);
        }
        return v4;
    }

//    public void print(){
//        for (int i = 0; i<count; i++){
//            System.out.print(data[i]+ " ");
//        }
//    }

    //best way to print my vector
    public String toString() {
        String values = "";
        for (int i = 0; i < count; i++) {
            values += data[i] + " ";
        }
        return values;
    }


}
