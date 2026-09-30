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

        /*
         * STUDENT TASK 1 EXPERIMENT
         * Build a second tree with the same books inserted in
         * alphabetical title order. Predict before running.
         * Compare size, height, in-order output, and one search count.
         */
    }
}
