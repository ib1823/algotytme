public class Task5PerformanceExperiment {

    public static void main(String[] args) {
        bstExperiment();
        System.out.println();
        hashTableExperiment();
    }

    private static void bstExperiment() {
        System.out.println("=== BST: same values, different shape ===");

        int[] treeAValues = {
                50, 30, 70, 20, 40, 60, 80,
                10, 25, 35, 45, 55, 65, 75, 90
        };

        int[] treeBValues = {
                10, 20, 25, 30, 35, 40, 45, 50,
                55, 60, 65, 70, 75, 80, 90
        };

        BinarySearchTree<Integer> treeA = new BinarySearchTree<>();
        BinarySearchTree<Integer> treeB = new BinarySearchTree<>();

        for (int value : treeAValues) {
            treeA.insert(value);
        }
        for (int value : treeBValues) {
            treeB.insert(value);
        }

        treeA.search(90);
        int comparisonsA = treeA.getLastSearchComparisons();
        treeB.search(90);
        int comparisonsB = treeB.getLastSearchComparisons();

        System.out.println(
                "Tree A: size=" + treeA.size()
                        + " height=" + treeA.height()
                        + " searchComparisons=" + comparisonsA);

        System.out.println(
                "Tree B: size=" + treeB.size()
                        + " height=" + treeB.height()
                        + " searchComparisons=" + comparisonsB);

        System.out.println("Explanation: Tree B is inserted in ascending order, so it becomes more skewed.");
        System.out.println("A taller/skewed BST usually needs more comparisons for search.");
    }

    private static void hashTableExperiment() {
        System.out.println("=== Hash table: same keys, different distribution ===");

        int[] keys = {1, 12, 23, 34, 45, 56, 67, 78};

        HashTable<Integer, String> tableA = new HashTable<>(11);
        HashTable<Integer, String> tableB = new HashTable<>(53);

        for (int key : keys) {
            tableA.put(key, "V" + key);
            tableB.put(key, "V" + key);
        }

        // Bucket-fordeling: viser hvor mange elementer som havner i hver relevant bucket.
        System.out.println("Bucket distribution (capacity 11):");
        printBucketDistribution(tableA, keys);
        System.out.println("Bucket distribution (capacity 53):");
        printBucketDistribution(tableB, keys);

        tableA.get(78);
        int comparisonsA = tableA.getLastGetComparisons();
        tableB.get(78);
        int comparisonsB = tableB.getLastGetComparisons();

        System.out.printf(
                "Capacity 11: size=%d loadFactor=%.3f get(78) comparisons=%d%n",
                tableA.size(), tableA.loadFactor(), comparisonsA);

        System.out.printf(
                "Capacity 53: size=%d loadFactor=%.3f get(78) comparisons=%d%n",
                tableB.size(), tableB.loadFactor(), comparisonsB);

        System.out.println("Explanation: Better key distribution gives fewer collisions and often fewer get() comparisons.");
        System.out.println("Lower load factor helps by reducing crowding, but perfect performance is not guaranteed.");
        System.out.println("If many keys still collide in the same bucket, get() can still require multiple comparisons.");
    }

    private static void printBucketDistribution(HashTable<Integer, String> table, int[] keys) {
        for (int key : keys) {
            int index = table.bucketIndex(key);
            int bucketSize = table.bucketSize(index);
            System.out.println("key " + key + " -> bucket " + index + " (bucketSize=" + bucketSize + ")");
        }
    }
}
