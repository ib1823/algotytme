import java.util.List;

public class Task3CatalogueExperiment {

    public static void main(String[] args) {
        LibraryCatalogue catalogue = new LibraryCatalogue();
        List<Book> books = AssignmentData.fiveBooks();

        // 1) Verifiserer at fem bøker legges inn i begge indeksene.
        for (Book book : books) {
            catalogue.addBook(book);
        }

        printSizes("after 5 additions", catalogue);

        // 2) Verifiserer ISBN-oppslag i hash-indeksen.
        System.out.println("find 9780000000003 -> " + catalogue.findByIsbn("9780000000003"));

        // 3) Verifiserer at duplikat ISBN avvises uten å endre indeksene.
        Book duplicate = new Book(
                "9780000000003",
                "A Different Title",
                "A Different Author",
                2026);

        System.out.println("add duplicate ISBN -> " + catalogue.addBook(duplicate));
        printSizes("after duplicate attempt", catalogue);

        // 4) Verifiserer fjerning av eksisterende ISBN fra begge indeksene.
        System.out.println("remove 9780000000001 -> " + catalogue.removeBook("9780000000001"));
        printSizes("after removal", catalogue);

        // 5) Verifiserer at fjerning av ikke-eksisterende ISBN returnerer false.
        System.out.println("remove 9780000000999 -> " + catalogue.removeBook("9780000000999"));
        printSizes("after missing removal attempt", catalogue);

        // 6) Verifiserer alfabetisk utskrift fra titleIndex (BST in-order).
        System.out.println("remaining books:");
        catalogue.printAllByTitle();
    }

    private static void printSizes(String step, LibraryCatalogue catalogue) {
        System.out.println(
                step + " | size()=" + catalogue.size()
                        + " | BST=" + catalogue.titleIndexSize()
                        + " | Hash=" + catalogue.isbnIndexSize());
    }
}
