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

        tableA.get(78);
        int comparisonsA = tableA.getLastGetComparisons();
        tableB.get(78);
        int comparisonsB = tableB.getLastGetComparisons();

        System.out.printf(
                "Capacity 11: size=%d loadFactor=%.3f comparisons=%d%n",
                tableA.size(), tableA.loadFactor(), comparisonsA);

        System.out.printf(
                "Capacity 53: size=%d loadFactor=%.3f comparisons=%d%n",
                tableB.size(), tableB.loadFactor(), comparisonsB);
    }
}
