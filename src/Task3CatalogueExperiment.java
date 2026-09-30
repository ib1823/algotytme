import java.util.List;

public class Task3CatalogueExperiment {

    public static void main(String[] args) {
        LibraryCatalogue catalogue = new LibraryCatalogue();
        List<Book> books = AssignmentData.fiveBooks();

        for (Book book : books) {
            catalogue.addBook(book);
        }

        printSizes("after 5 additions", catalogue);
        System.out.println("find 9780000000003 -> " + catalogue.findByIsbn("9780000000003"));

        Book duplicate = new Book(
                "9780000000003",
                "A Different Title",
                "A Different Author",
                2026);

        System.out.println("add duplicate ISBN -> " + catalogue.addBook(duplicate));
        printSizes("after duplicate attempt", catalogue);

        System.out.println("remove 9780000000001 -> " + catalogue.removeBook("9780000000001"));
        printSizes("after removal", catalogue);

        System.out.println("remaining books:");
        catalogue.printAllByTitle();
    }

    private static void printSizes(String step, LibraryCatalogue catalogue) {
        System.out.println(
                step + " | BST=" + catalogue.titleIndexSize()
                        + " | Hash=" + catalogue.isbnIndexSize());
    }
}
