import java.util.LinkedList;

class HashTable<K, V> {

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private LinkedList<Entry<K, V>>[] table;
    private int size;

    public HashTable() {
        table = new LinkedList[5];
        size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    table[index].remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

public class Main1 {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();
        System.out.println(hashTable.size());
        System.out.println(hashTable.isEmpty());
        hashTable.put("apple", 1);
        hashTable.put("banana", 4);
        hashTable.put("pear", 3);
        hashTable.put("grape", 7);
        System.out.println(hashTable.isEmpty());
        System.out.println(hashTable.get("grape"));
        hashTable.put("grape", 9);
        System.out.println(hashTable.get("grape"));
        hashTable.remove("pear");
        System.out.println(hashTable.get("pear"));
        System.out.println(hashTable.size());
    }
}