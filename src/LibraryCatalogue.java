public class LibraryCatalogue {

    private BinarySearchTree<Book> titleIndex;
    private HashTable<String, Book> isbnIndex;

    public LibraryCatalogue() {
        titleIndex = new BinarySearchTree<>();
        isbnIndex = new HashTable<>(10);
    }

    public boolean addBook(Book book) {
        /* STUDENT TASK 3: keep both indexes consistent. */
        throw new UnsupportedOperationException(
                "TODO Task 3: implement addBook()");
    }

    public Book findByIsbn(String isbn) {
        /* STUDENT TASK 3: use the most suitable index. */
        throw new UnsupportedOperationException(
                "TODO Task 3: implement findByIsbn()");
    }

    public boolean removeBook(String isbn) {
        /*
         * STUDENT TASK 3
         * Hint: obtain the Book object before removing the ISBN entry.
         */
        throw new UnsupportedOperationException(
                "TODO Task 3: implement removeBook()");
    }

    public void printAllByTitle() {
        throw new UnsupportedOperationException(
                "TODO Task 3: implement printAllByTitle()");
    }

    public int size() {
        throw new UnsupportedOperationException(
                "TODO Task 3: implement size()");
    }

    public int titleIndexSize() {
        return titleIndex.size();
    }

    public int isbnIndexSize() {
        return isbnIndex.size();
    }
}
