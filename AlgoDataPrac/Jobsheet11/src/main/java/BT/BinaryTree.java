package BT;

public class BinaryTree {
    Node root;
    int size;

    BinaryTree() {
        Node root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    void add(int data) {
        if (isEmpty()) root = new Node(data);
        else {
            Node current = root;
            while (true) {
                if (data < current.data) {
                    if (current.left != null) current = current.left;
                    else {
                        current.left = new Node(data);
                        break;
                    }
                }
                else if (data > current.data) {
                    if (current.right != null) current = current.right;
                    else {
                        current.right = new Node(data);
                        break;
                    }
                }
                else {
                    break;
                }
            }
        }
    }

    boolean find(int data) {
        boolean found = false;
        Node current = root;
        while (current != null) {
            if (current.data == data) {
                found = true;
                break;
            }
            else if (data < current.data) current = current.left;
            else current = current.right;
        }
        return found;
    }

    void traversePreOrder (Node node) {
        if (node != null) {
            System.out.println(" " + node.data);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    void traversePostOrder (Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.println(" " + node.data);
        }
    }
    void traverseInOrder (Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.println(" " + node.data);
            traverseInOrder(node.right);
        }
    }

    Node getSuccessor(Node del) {
        Node successor = del.right;
        Node successorParent = del;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    void delete(int data) {
        if (isEmpty()) {
            System.out.println("Tree is empty");
            return;
        }

        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while (current != null) {
            if (current.data == data) break;
            else if (data < current.data) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            }
            else {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }

        if (current == null) {
            System.out.println("Couldn't find data!");
            return;
        }
        else {
            if (current.left == null && current.right == null) {
                if (current == root) root = null;
                else {
                    if (isLeftChild) parent.left = null;
                    else parent.right = null;
                }
            }
            else if (current.left == null) {
                if (current == root) root = current.right;
                else {
                    if (isLeftChild) parent.left = current.right;
                    else parent.right = current.right;
                }
            }
            else if (current.right == null) {
                if (current == root) root = current.left;
                else {
                    if (isLeftChild) parent.left = current.left;
                    else parent.right = current.left;
                }
            }
            else {
                Node successor = getSuccessor(current);
                if (current == root) root = successor;
                else {
                    if (isLeftChild) parent.left = successor;
                    else parent.right = successor;
                }
                successor.left = current.left;
            }
        }
    }

    void recursiveAdd(int data) {
        recursiveAdd(data, root);
    }

    void recursiveAdd(int data, Node parent) {
        if (isEmpty()) {
            root = new Node(data);
            return;
        }
        if (data < parent.data) {
            if (parent.left != null) recursiveAdd(data, parent.left);
            else parent.left = new Node(data);
        }
        else if (data > parent.data) {
            if (parent.right != null) recursiveAdd(data, parent.right);
            else parent.right = new Node(data);
        }
    }

    void displayLargestAndSmallest() {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        Node current = root;
        while (current != null) {
            if (current.data < smallest) smallest = current.data;
            current = current.left;
        }

        current = root;
        while (current != null) {
            if (current.data > largest) largest = current.data;
            current = current.right;
        }

        System.out.println("Smallest: " + smallest);
        System.out.println("Largest: " + largest);
    }

    void displayLeafData(Node node) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            System.out.println(node.data + " ");
            return;
        }
        displayLeafData(node.left);
        displayLeafData(node.right);
    }

    int countLeaves(int count, Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return count + 1;
        return  countLeaves(count, node.left) + countLeaves(count, node.right);
    }
}