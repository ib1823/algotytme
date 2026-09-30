import java.util.ArrayList;
import java.util.List;

public class AssignmentData {

    public static List<Book> fiveBooks() {
        List<Book> books = new ArrayList<>();

        books.add(new Book("9780000000001", "Effective Java", "Joshua Bloch", 2018));
        books.add(new Book("9780000000002", "Clean Code", "Robert C. Martin", 2008));
        books.add(new Book("9780000000003", "The Pragmatic Programmer", "David Thomas and Andrew Hunt", 2019));
        books.add(new Book("9780000000004", "Algorithms", "Robert Sedgewick and Kevin Wayne", 2011));
        books.add(new Book("9780000000005", "Head First Java", "Kathy Sierra and Bert Bates", 2022));

        return books;
    }

    public static List<Book> batchWithDuplicates() {
        List<Book> batch = new ArrayList<>(fiveBooks());
        batch.add(new Book("9780000000002", "Clean Code", "Robert C. Martin", 2008));
        batch.add(new Book("9780000000001", "Effective Java", "Joshua Bloch", 2018));
        return batch;
    }
}
