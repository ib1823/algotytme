import java.util.List;

public class Task2HashTableExperiment {

    public static void main(String[] args) {
        isbnLookupExperiment();
        System.out.println();
        collisionExperiment();
        System.out.println();
        rehashingExperiment();
    }

    private static void isbnLookupExperiment() {
        System.out.println("=== Oppgave 2: ISBN-oppslag ===");
        // Demonstrerer at ISBN brukes som nøkkel i HashTable<String, Book>.
        HashTable<String, Book> isbnIndex = new HashTable<>(10);
        List<Book> books = AssignmentData.fiveBooks();

        for (Book book : books) {
            isbnIndex.put(book.getIsbn(), book);
        }

        // Hent eksisterende ISBN og kontroller at vi får "Head First Java".
        Book existingResult = isbnIndex.get("9780000000005");
        String existingTitle = existingResult == null ? null : existingResult.getTitle();
        System.out.println("get(9780000000005) -> " + existingResult);
        System.out.println("title check (expected Head First Java): " + existingTitle);
        System.out.println("comparisons for existing get: " + isbnIndex.getLastGetComparisons());

        // Hent ISBN som ikke finnes; forventet resultat er null.
        Book missingResult = isbnIndex.get("9780000000999");
        System.out.println("get(9780000000999) -> " + missingResult);
        System.out.println("comparisons for missing get: " + isbnIndex.getLastGetComparisons());

        // Sjekker containsKey for et ISBN som finnes.
        System.out.println("containsKey(9780000000002) -> " + isbnIndex.containsKey("9780000000002"));

        // Viser grunnmålinger etter innsettingene.
        System.out.println("size = " + isbnIndex.size());
        System.out.println("capacity = " + isbnIndex.capacity());
        System.out.printf("loadFactor = %.3f%n", isbnIndex.loadFactor());
    }

    private static void collisionExperiment() {
        System.out.println("=== Kollisjonseksperiment ===");
        // Nøklene 2, 12, 22, 32 havner i samme bucket når kapasitet er 10.
        HashTable<Integer, String> table = new HashTable<>(10);

        table.put(2, "Value-2");
        table.put(12, "Value-12");
        table.put(22, "Value-22");
        table.put(32, "Value-32");

        int collisionBucket = table.bucketIndex(2);
        System.out.println("bucketIndex(2) = " + collisionBucket);
        System.out.println("bucketIndex(12) = " + table.bucketIndex(12));
        System.out.println("bucketIndex(22) = " + table.bucketIndex(22));
        System.out.println("bucketIndex(32) = " + table.bucketIndex(32));
        System.out.println("bucketSize(" + collisionBucket + ") = " + table.bucketSize(collisionBucket));

        // Viser at oppslag fortsatt virker med separate chaining.
        System.out.println("get(22) = " + table.get(22));
        System.out.println("comparisons for get(22) = " + table.getLastGetComparisons());
    }

    private static void rehashingExperiment() {
        System.out.println("=== Rehashingeksperiment ===");
        // Startkapasitet 4; ved fjerde innsetting trigges rehashing (terskel 0.75).
        HashTable<Integer, String> table = new HashTable<>(4);

        for (int key = 0; key <= 3; key++) {
            table.put(key, "V" + key);
            System.out.printf(
                    "after put(%d): size=%d capacity=%d loadFactor=%.3f%n",
                    key,
                    table.size(),
                    table.capacity(),
                    table.loadFactor());
        }
    }
}
