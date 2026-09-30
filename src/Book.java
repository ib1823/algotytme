public class Book implements Comparable<Book> {

    private String isbn;
    private String title;
    private String author;
    private int year;

    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Book other) {
        /*
         * STUDENT TASK 1
         * Use the business rule from the assignment:
         * 1. title is the main comparison
         * 2. ISBN is used when two titles are equal
         */
        throw new UnsupportedOperationException(
                "TODO Task 1: implement Book.compareTo()");
    }

    @Override
    public String toString() {
        return title + " (" + isbn + ")";
    }
}
