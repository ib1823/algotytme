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
        /*
         * STUDENT TASK 4
         * Apply Set and Map to the incoming batch problem.
         */
        throw new UnsupportedOperationException(
                "TODO Task 4: implement analyze()");
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
