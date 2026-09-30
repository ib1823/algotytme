import java.util.List;

public class Task1TitleIndexExperiment {

    public static void main(String[] args) {
        List<Book> books = AssignmentData.fiveBooks();

        BinarySearchTree<Book> originalOrder = new BinarySearchTree<>();
        for (Book book : books) {
            originalOrder.insert(book);
        }

        System.out.println("=== Original insertion order ===");
        System.out.println("size = " + originalOrder.size());
        System.out.println("height = " + originalOrder.height());
        System.out.println("in-order:");
        originalOrder.inOrder();

        Book valgtBok = books.get(2);

        Book resultat = originalOrder.search(valgtBok);
        System.out.println("search result = " + resultat);
        System.out.println("search comparisons = " + originalOrder.getLastSearchComparisons());

        Book ikkeFunnet= new Book(
            "not-found-isbn", 
            "en bok som ikke finnes",
            null,
            0);


        Book resultatIkkeFunnet = originalOrder.search(ikkeFunnet);
        System.out.println("search result (not found) = " + resultatIkkeFunnet);
        System.out.println("search comparisons (not found) = " + originalOrder.getLastSearchComparisons()); 

        Book cleanCode= books.get(1 );
        boolean deletedBook = originalOrder.delete(cleanCode);
        System.out.println("deleted book = " + (deletedBook ? cleanCode : null));
        System.out.println("size after deletion = " + originalOrder.size());
        System.out.println("height after deletion = " + originalOrder.height());
        System.out.println("in-order after deletion:");
        originalOrder.inOrder();

        BinarySearchTree<Book> rebuiltOrder = new BinarySearchTree<>();
        for (Book book : books) {
            rebuiltOrder.insert(book);
        }
        Book effectiveJava = books.get(0);
        boolean deletedEffectiveJava =
        rebuiltOrder.delete(effectiveJava);
        System.out.println("deleted book =" + (deletedEffectiveJava ?
            effectiveJava : null));
        System.out.println("size after deletion = " + rebuiltOrder.size());
        System.out.println("height after deletion = " + rebuiltOrder.height());
        System.out.println("in-order after deletion:");
        rebuiltOrder.inOrder();

        System.out.println("==Alphabetical title order==");
        BinarySearchTree<Book> alphabeticalOrder = new BinarySearchTree<>();
    
        alphabeticalOrder.insert(books.get(3)); //algorythms
        alphabeticalOrder.insert(books.get(1)); //clean code
        alphabeticalOrder.insert(books.get(0)); //effective java
        alphabeticalOrder.insert(books.get(4)); //head first Java
        alphabeticalOrder.insert(books.get(2)); //Pragmatic Programmer

        System.out.println("size = " + alphabeticalOrder.size());
        System.out.println("height = " + alphabeticalOrder.height());
        System.out.println("in-order:");
        alphabeticalOrder.inOrder();

        Book searchAlphabetical = books.get(0);
        Book resultAlphabetical = alphabeticalOrder.search(searchAlphabetical);
        System.out.println("search result (alphabetical) = " + resultAlphabetical);
        System.out.println("search comparisons (alphabetical) = " + alphabeticalOrder.getLastSearchComparisons());
        /*
         * STUDENT TASK 1 EXPERIMENT
         * Build a second tree with the same books inserted in
         * alphabetical title order. Predict before running.
         * Compare size, height, in-order output, and one search count.
         */
    }
}
