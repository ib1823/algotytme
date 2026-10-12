public class LibraryCatalogue {

    private BinarySearchTree<Book> titleIndex;
    private HashTable<String, Book> isbnIndex;

    public LibraryCatalogue() {
        titleIndex = new BinarySearchTree<>();
        isbnIndex = new HashTable<>(10);
    }

    public boolean addBook(Book book) {
        if (isbnIndex.containsKey(book.getIsbn())) {
            return false;
        }

        titleIndex.insert(book);
        isbnIndex.put(book.getIsbn(), book);
        return true;
    }

    public Book findByIsbn(String isbn) {
        return isbnIndex.get(isbn);
    }

    public boolean removeBook(String isbn) {
        Book bookToRemove = isbnIndex.get(isbn);
        if (bookToRemove == null) {
            return false;
        }

        boolean removedFromTitleIndex = titleIndex.delete(bookToRemove);
        Book removedFromIsbnIndex = isbnIndex.remove(isbn);
        return removedFromTitleIndex && removedFromIsbnIndex != null;
    }

    public void printAllByTitle() {
        titleIndex.inOrder();
    }

    public int size() {
        return isbnIndex.size();
    }

    public int titleIndexSize() {
        return titleIndex.size();
    }

    public int isbnIndexSize() {
        return isbnIndex.size();
    }
}
