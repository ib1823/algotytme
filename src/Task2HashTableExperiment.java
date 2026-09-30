import java.util.List;

public class Task2HashTableExperiment {

    public static void main(String[] args) {
        isbnLookup();
        System.out.println();
        collisionExperiment();
        System.out.println();
        rehashingExperiment();
    }

    private static void isbnLookup() {
        System.out.println("=== ISBN lookup ===");
        HashTable<String, Book> index = new HashTable<>(10);
        List<Book> books = AssignmentData.fiveBooks();

        for (Book book : books) {
            index.put(book.getIsbn(), book);
        }

        System.out.println("9780000000005 -> " + index.get("9780000000005"));
        System.out.println("9780000000999 -> " + index.get("9780000000999"));
        System.out.println("contains 9780000000002 -> " + index.containsKey("9780000000002"));
        System.out.println("size = " + index.size());
    }

    private static void collisionExperiment() {
        System.out.println("=== Collision experiment ===");
        HashTable<Integer, String> table = new HashTable<>(10);

        table.put(2, "A");
        table.put(12, "B");
        table.put(22, "C");
        table.put(32, "D");

        System.out.println("bucket index for 22 = " + table.bucketIndex(22));
        System.out.println("bucket size at index 2 = " + table.bucketSize(2));
        table.printTable();

        System.out.println("get(22) = " + table.get(22));
        System.out.println("comparisons for get(22) = " + table.getLastGetComparisons());
        System.out.println("remove(12) = " + table.remove(12));
        System.out.println("get(12) after removal = " + table.get(12));
    }

    private static void rehashingExperiment() {
        System.out.println("=== Rehashing experiment ===");
        HashTable<Integer, String> table = new HashTable<>(4);

        for (int key = 0; key <= 3; key++) {
            table.put(key, "V" + key);
            System.out.printf(
                    "after key %d: size=%d capacity=%d loadFactor=%.3f%n",
                    key,
                    table.size(),
                    table.capacity(),
                    table.loadFactor());
        }
    }
}
