import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Task4AnalyticsExperiment {

    public static void main(String[] args) {
        List<Book> batch = AssignmentData.batchWithDuplicates();

        runOne(batch, new HashMap<>());
        System.out.println();
        runOne(batch, new LinkedHashMap<>());
        System.out.println();
        runOne(batch, new TreeMap<>());
    }

    private static void runOne(List<Book> batch, Map<Integer, Integer> map) {
        CatalogueAnalytics analytics = new CatalogueAnalytics(map);
        analytics.analyze(batch);

        System.out.println("Map type: " + map.getClass().getSimpleName());
        System.out.println("input records = " + analytics.getInputRecordCount());
        System.out.println("unique ISBN values = " + analytics.getUniqueBookCount());
        System.out.println("duplicate ISBN values = " + analytics.getDuplicateIsbns());
        System.out.println("unique authors = " + analytics.getUniqueAuthors());
        System.out.println("books per year = " + analytics.getBooksPerYear());
    }
}
