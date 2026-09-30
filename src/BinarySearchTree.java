public class BinarySearchTree<E extends Comparable<E>> {

    private Node<E> root;
    private int size;
    private int lastSearchComparisons;

    public void insert(E element) {
        boolean[] inserted = {false};
        root = insert(root, element, inserted);
        if (inserted[0]) {
            size++;
        }
    }

    private Node<E> insert(Node<E> current, E element, boolean[] inserted) {
        if (current == null) {
            inserted[0] = true;
            return new Node<>(element);
        }

        int comparison = element.compareTo(current.element);
        if (comparison < 0) {
            current.left = insert(current.left, element, inserted);
        } else if (comparison > 0) {
            current.right = insert(current.right, element, inserted);
        }
        return current;
    }

    public E search(E element) {
        lastSearchComparisons = 0;
        Node<E> result = search(root, element);
        return result == null ? null : result.element;
    }

    private Node<E> search(Node<E> current, E element) {
        if (current == null) {
            return null;
        }

        lastSearchComparisons++;
        int comparison = element.compareTo(current.element);

        if (comparison == 0) {
            return current;
        }
        if (comparison < 0) {
            return search(current.left, element);
        }
        return search(current.right, element);
    }

    public boolean delete(E element) {
        boolean[] deleted = {false};
        root = delete(root, element, deleted);
        if (deleted[0]) {
            size--;
        }
        return deleted[0];
    }

    private Node<E> delete(Node<E> current, E element, boolean[] deleted) {
        if (current == null) {
            return null;
        }

        int comparison = element.compareTo(current.element);

        if (comparison < 0) {
            current.left = delete(current.left, element, deleted);
            return current;
        }
        if (comparison > 0) {
            current.right = delete(current.right, element, deleted);
            return current;
        }

        deleted[0] = true;

        if (current.left == null) {
            return current.right;
        }
        if (current.right == null) {
            return current.left;
        }

        E successor = findMin(current.right);
        current.element = successor;
        current.right = deleteSuccessor(current.right, successor);
        return current;
    }

    private Node<E> deleteSuccessor(Node<E> current, E element) {
        if (current == null) {
            return null;
        }

        int comparison = element.compareTo(current.element);
        if (comparison < 0) {
            current.left = deleteSuccessor(current.left, element);
        } else if (comparison > 0) {
            current.right = deleteSuccessor(current.right, element);
        } else {
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            E successor = findMin(current.right);
            current.element = successor;
            current.right = deleteSuccessor(current.right, successor);
        }
        return current;
    }

    private E findMin(Node<E> current) {
        Node<E> node = current;
        while (node.left != null) {
            node = node.left;
        }
        return node.element;
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<E> current) {
        if (current == null) {
            return;
        }
        inOrder(current.left);
        System.out.println(current.element);
        inOrder(current.right);
    }

    public int size() {
        return size;
    }

    public int height() {
        return height(root);
    }

    private int height(Node<E> current) {
        if (current == null) {
            return -1;
        }
        return 1 + Math.max(height(current.left), height(current.right));
    }

    public int getLastSearchComparisons() {
        return lastSearchComparisons;
    }
}
