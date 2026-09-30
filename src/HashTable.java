import java.util.Iterator;
import java.util.LinkedList;

public class HashTable<K, V> {

    private static final double LOAD_FACTOR_THRESHOLD = 0.75;

    private LinkedList<Entry<K, V>>[] table;
    private int size;
    private int lastGetComparisons;

    public HashTable(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        }
        createTable(capacity);
    }

    @SuppressWarnings("unchecked")
    private void createTable(int capacity) {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int indexFor(K key) {
        return Math.floorMod(key.hashCode(), table.length);
    }

    public void put(K key, V value) {
        int index = indexFor(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        double newLoadFactor = (size + 1) / (double) table.length;
        if (newLoadFactor > LOAD_FACTOR_THRESHOLD) {
            rehash();
            index = indexFor(key);
            bucket = table[index];
        }

        bucket.add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        lastGetComparisons = 0;
        int index = indexFor(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            lastGetComparisons++;
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        int index = indexFor(key);
        LinkedList<Entry<K, V>> bucket = table[index];
        Iterator<Entry<K, V>> iterator = bucket.iterator();

        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            if (entry.key.equals(key)) {
                V removedValue = entry.value;
                iterator.remove();
                size--;
                return removedValue;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        int index = indexFor(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return table.length;
    }

    public double loadFactor() {
        return size / (double) table.length;
    }

    public int getLastGetComparisons() {
        return lastGetComparisons;
    }

    public int bucketIndex(K key) {
        return indexFor(key);
    }

    public int bucketSize(int index) {
        if (index < 0 || index >= table.length) {
            throw new IllegalArgumentException("Invalid bucket index.");
        }
        return table[index].size();
    }

    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + " -> " + table[i]);
        }
    }

    private void rehash() {
        LinkedList<Entry<K, V>>[] oldTable = table;
        createTable(oldTable.length * 2);
        size = 0;

        for (LinkedList<Entry<K, V>> bucket : oldTable) {
            for (Entry<K, V> entry : bucket) {
                put(entry.key, entry.value);
            }
        }
    }
}
