public class ToolboxSmokeTest {

    public static void main(String[] args) {
        System.out.println("=== Supplied BST smoke test ===");
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int value : values) {
            tree.insert(value);
        }
        System.out.println("size = " + tree.size());
        System.out.println("height = " + tree.height());
        System.out.println("search 60 = " + tree.search(60));
        System.out.println("comparisons = " + tree.getLastSearchComparisons());
        System.out.println("in-order:");
        tree.inOrder();

        System.out.println();
        System.out.println("=== Supplied HashTable smoke test ===");
        HashTable<Integer, String> table = new HashTable<>(10);
        table.put(2, "A");
        table.put(12, "B");
        table.put(22, "C");
        table.put(32, "D");
        System.out.println("get(22) = " + table.get(22));
        System.out.println("comparisons = " + table.getLastGetComparisons());
        table.printTable();
    }
}
