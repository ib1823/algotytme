import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CatalogueAnalytics {

    private Set<String> seenIsbns = new HashSet<>();
    private Set<String> duplicateIsbns = new HashSet<>();
    private Set<String> uniqueAuthors = new HashSet<>();
    private Map<Integer, Integer> booksPerYear;

    private int inputRecordCount;
    private int uniqueBookCount;

    public CatalogueAnalytics(Map<Integer, Integer> booksPerYear) {
        this.booksPerYear = booksPerYear;
    }

    public void analyze(List<Book> batch) {
        seenIsbns.clear();
        duplicateIsbns.clear();
        uniqueAuthors.clear();
        booksPerYear.clear();
        inputRecordCount = 0;
        uniqueBookCount = 0;

        for (Book book : batch) {
            inputRecordCount++;

            String isbn = book.getIsbn();
            if (seenIsbns.contains(isbn)) {
                duplicateIsbns.add(isbn);
                continue;
            }

            seenIsbns.add(isbn);
            uniqueBookCount++;

            uniqueAuthors.add(book.getAuthor());
            booksPerYear.merge(book.getYear(), 1, Integer::sum);
        }
    }

    public int getInputRecordCount() {
        return inputRecordCount;
    }

    public int getUniqueBookCount() {
        return uniqueBookCount;
    }

    public Set<String> getDuplicateIsbns() {
        return duplicateIsbns;
    }

    public Set<String> getUniqueAuthors() {
        return uniqueAuthors;
    }

    public Map<Integer, Integer> getBooksPerYear() {
        return booksPerYear;
    }
}
