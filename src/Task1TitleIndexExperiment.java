import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Task1TitleIndexExperiment {

    public static void main(String[] args) {
        List<Book> books = AssignmentData.fiveBooks();

        // 1) Bygger BST med opprinnelig innsettingsrekkefølge fra AssignmentData.
        BinarySearchTree<Book> originalOrderTree = new BinarySearchTree<>();
        for (Book book : books) {
            originalOrderTree.insert(book);
        }

        // 2) Demonstrerer at in-order traversal gir alfabetisk tittelrekkefølge.
        System.out.println("=== Original insertion order: in-order traversal ===");
        originalOrderTree.inOrder();

        // 3) Demonstrerer søk: én bok som finnes og én som ikke finnes.
        Book existingBook = books.get(2); // The Pragmatic Programmer
        Book foundBook = originalOrderTree.search(existingBook);
        System.out.println("\nSearch (exists): " + foundBook);
        System.out.println("Comparisons (exists): " + originalOrderTree.getLastSearchComparisons());

        Book missingBook = new Book("0000000000000", "Not In Catalogue", "Unknown", 0);
        Book missingResult = originalOrderTree.search(missingBook);
        System.out.println("\nSearch (missing): " + missingResult);
        System.out.println("Comparisons (missing): " + originalOrderTree.getLastSearchComparisons());

        // 4) Demonstrerer sletting av "Clean Code" og at treet fortsatt kan traverseres riktig.
        Book cleanCode = books.get(1);
        originalOrderTree.delete(cleanCode);
        System.out.println("\n=== After deleting Clean Code ===");
        originalOrderTree.inOrder();

        // 5) Bygger treet på nytt, sletter "Effective Java", og skriver ut resultatet.
        BinarySearchTree<Book> rebuiltTree = new BinarySearchTree<>();
        for (Book book : books) {
            rebuiltTree.insert(book);
        }
        Book effectiveJava = books.get(0);
        rebuiltTree.delete(effectiveJava);
        System.out.println("\n=== Rebuilt tree, after deleting Effective Java ===");
        rebuiltTree.inOrder();

        // 6) Bygger nytt tre med samme bøker i alfabetisk tittelrekkefølge.
        List<Book> alphabeticallySortedBooks = new ArrayList<>(books);
        alphabeticallySortedBooks.sort(Comparator.comparing(Book::getTitle).thenComparing(Book::getIsbn));

        BinarySearchTree<Book> alphabeticalOrderTree = new BinarySearchTree<>();
        for (Book book : alphabeticallySortedBooks) {
            alphabeticalOrderTree.insert(book);
        }

        // 7) Demonstrerer eksperimentet: høyde + søkesammenligninger for "The Pragmatic Programmer".
        Book pragmaticProgrammer = books.get(2);

        originalOrderTree = new BinarySearchTree<>();
        for (Book book : books) {
            originalOrderTree.insert(book);
        }
        originalOrderTree.search(pragmaticProgrammer);

        alphabeticalOrderTree.search(pragmaticProgrammer);

        System.out.println("\n=== Experiment: same books, different insertion order ===");
        System.out.println("Original order tree height: " + originalOrderTree.height());
        System.out.println("Original order search comparisons (The Pragmatic Programmer): "
            + originalOrderTree.getLastSearchComparisons());
        System.out.println("Alphabetical order tree height: " + alphabeticalOrderTree.height());
        System.out.println("Alphabetical order search comparisons (The Pragmatic Programmer): "
            + alphabeticalOrderTree.getLastSearchComparisons());
    }
}
