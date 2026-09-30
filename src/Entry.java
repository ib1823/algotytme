public class Entry<K, V> {
    protected K key;
    protected V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "[" + key + ", " + value + "]";
    }
}
