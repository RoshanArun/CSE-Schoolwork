package edu.ser222.m03_02;

/**
 * A binary search tree based implementation of a symbol table.
 * 
 * Completion time: (your completion time)
 *
 * @author (your name), Sedgewick, Acuna
 * @version (version)
 */
import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class CompletedBST<Key extends Comparable<Key>, Value> implements BST<Key, Value> {
    private Node<Key, Value> root;

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null)
            return 0;
        else
            return x.N;
    }

    @Override
    public Value get(Key key) {
        Node<Key, Value> iter = root;

        while (iter != null) {
            int cmp = key.compareTo(iter.key);

            if (cmp < 0)
                iter = iter.left;
            else if (cmp > 0)
                iter = iter.right;
            else
                return iter.val;
        }

        return null;
    }
    
    

    @Override
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    

    @Override
    public Key min() {
        if (root == null)
            throw new NoSuchElementException();
        return min(root).key;
    }

    private Node<Key, Value> min(Node x) {
        if (x.left == null)
            return x;
        return min(x.left);
    }

    @Override
    public Key max() {
        if (root == null)
            throw new NoSuchElementException();
        return max(root).key;
    }

    private Node<Key, Value> max(Node x) {
        if (x.right == null)
            return x;
        return max(x.right);
    }

    @Override
    public Key floor(Key key) {
        if (root == null)
            throw new NoSuchElementException();

        Node<Key, Value> x = floor(root, key);
        if (x == null)
            return null;
        return x.key;
    }

    private Node<Key, Value> floor(Node<Key, Value> x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return x;
        if (cmp < 0)
            return floor(x.left, key);
        Node<Key, Value> t = floor(x.right, key);
        if (t != null)
            return t;
        else
            return x;
    }

    @Override
    public Key select(int k) {
        return select(root, k).key;
    }

    private Node<Key, Value> select(Node x, int k) {
        if (x == null)
            return null;
        int t = size(x.left);
        if (t > k)
            return select(x.left, k);
        else if (t < k)
            return select(x.right, k - t - 1);
        else
            return x;
    }

    @Override
    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node<Key, Value> x) {
        // Return number of keys less than x.key in the subtree rooted at x.
        if (x == null)
            return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return rank(key, x.left);
        else if (cmp > 0)
            return 1 + size(x.left) + rank(key, x.right);
        else
            return size(x.left);
    }

    @Override
    public void deleteMin() {
        if (root == null) throw new NoSuchElementException();
        root = deleteMin(root);}
    private Node<Key, Value> deleteMin(Node x) {
        //If left node is null,return right node
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left); //set left node to result 
        x.N = size(x.left) + size(x.right) + 1; return x;
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node put(Node<Key, Value> x, Key key, Value val) {
    if (x == null) return new Node(key, val, 1);
    int cmp = key.compareTo(x.key);
    if (cmp < 0) x.left = put(x.left, key, val);
    else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val; x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    //Sequencial search(unordered LL, S:N/2, I:N, order supp)
    //Binary search(Ordered Array, S:lgN, I:N, no) (N!, 2^n, n, logN ,1)
    //avg case (domain of keys is random inserted), BST - 1.39lgN(yes)
    //InOrder: IO(root.left), visit root, IO(root.right) (LTR), BT-2 Children
    //Preorder: visit root, PO(root.left), PO(root.right) (<) Worst case:Stilted
    //Post Order: PO(root.left), PO(root.right), visit root (>) BC: balanced
    private Value get(Node<Key, Value> x, Key key) { //(Value val)
    if (x == null) return null; //not found - null, //bst ordered/heap not 
    int cmp = key.compareTo(x.key); //compares given k to current node k
    if (cmp < 0) return get(x.left, key); //recursively search left subtree
    else if (cmp > 0) return get(x.right, key); //^ right subtree
    else return x.val; //if key equal return node value, key=immut/value=mut
    //return new Node(key, val, 1); if (cmp < 0) x.left = put(x.left, key, val);
    //else x.val = val; x.N = size(x.left) + size(x.right) + 1; return x
    //if equal update x, set size of left/right subtree + 1, return root

        }

    private Node<Key, Value> delete(Node<Key, Value> x, Key key) {
    if (x == null)return null; //nothing to delete
    int cmp = key.compareTo(x.key); 
    if (cmp < 0) x.left = delete(x.left, key); //left subtree
    else if (cmp > 0) x.right = delete(x.right, key); //right subtree
    else { //symbol table more flexible for adding/deleting records
        if (x.right == null) return x.left; //return left
        if (x.left == null) return x.right; //return right
        Node t = x; //two children, use t as a temp variable
        x = min(t.right); //sets x to minimum of x's right subtree
        x.right = deleteMin(t.right); //delete min node from right subtree
        x.left = t.left; //sets old subtree of x to be a child of successor
    } x.N = size(x.left) + size(x.right) + 1; return x;
    }

    @Override
    public Iterable<Key> keys() {
        if (root == null)
            return new LinkedList<>();
        else
            return keys(min(), max());
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new LinkedList<>();
        keys(root, queue, lo, hi);
        return queue;
    }
    private void keys(Node<Key, Value> x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return; //if node is null return
    // Get the comparison values of the low/high values against the node's key
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0)   //recursively call method on the node's left child
            keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0)
            queue.add(x.key); // add the node's key to the queue
        if (cmphi > 0)// recursively call the method on the node's right child
            keys(x.right, queue, lo, hi);}

    public Key ceiling(Key key) {
        // SKIP, UNNEEDED
        return null;
    }

    public Node getRoot() {
        return root;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("The ST is empty!");
        }

        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null)
            return x.left;

        x.right = deleteMax(x.right);

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public int size(Key lo, Key hi) {
        if (lo.compareTo(hi) > 0)
            return 0;
        if (contains(hi))
            return rank(hi) - rank(lo) + 1;
        else
            return rank(hi) - rank(lo);
    }

    @Override
    public Value getFast(Key key) {
        Node<Key, Value> one = root;

        while (one != null) {
            int cmp = key.compareTo(one.key);

            if (cmp < 0)
                one = one.left;
            else if (cmp > 0)
                one = one.right;
            else
                return one.val;
        }

        return null;
    }

    @Override
    public void putFast(Key key, Value val) {
        Node<Key, Value> one = root;

        Node<Key, Value> newNode = new Node<>(key, val, 1);

        if (root == null) {
            root = newNode;
            return;
        }

        while (true) {
            int cmp = key.compareTo(one.key);

            if (cmp < 0) {
                if (one.left != null)
                    one = one.left;
                else {
                    one.left = newNode;
                    break;
                }
            } else if (cmp > 0) {
                if (one.right != null)
                    one = one.right;
                else {
                    one.right = newNode;
                    break;
                }
            } else {
                one.val = val;
                break;
            }
        }
    }

    public void balance() {
        LinkedList<Node> nodes = new LinkedList<Node>();
        sortNodes(nodes, root);
        root = balanceTree(nodes, 0, size() - 1);
        // Update the node sizes
        updateNodeSizes(root);
    }
    private void sortNodes(LinkedList<Node> nodes, Node n) {
        if (n == null) {
            return;
        }
        sortNodes(nodes, n.left);
        nodes.add(n);
        sortNodes(nodes, n.right);
    }
    private Node balanceTree(LinkedList<Node> nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (start + end) / 2;
        if ((start + end) % 2 == 1) {
            middle++;
        }
        Node middleNode = nodes.get(middle);
        middleNode.left = balanceTree(nodes, start, middle - 1);
        middleNode.right = balanceTree(nodes, middle + 1, end);
        // Update the size of the current node
        middleNode.N = 1 + size(middleNode.left) + size(middleNode.right);
        return middleNode;
    }
    private void updateNodeSizes(Node n) {
        if (n == null) {
            return;
        }
        updateNodeSizes(n.left);
        n.N = 1 + size(n.left) + size(n.right);
        updateNodeSizes(n.right);
    }










    public String displayLevel(Key key) {
        StringBuilder sb = new StringBuilder();
        Node<Key, Value> node = getNode(root, key);

        if (node == null)
            return "empty";

        Queue<Node<Key, Value>> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node<Key, Value> current = queue.remove();

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);

            sb.append(current.val);
            sb.append(" ");
        }

        return sb.toString();
    }

    private Node<Key, Value> getNode(Node<Key, Value> node, Key key) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if (cmp == 0)
            return node;
        else if (cmp < 0)
            return getNode(node.left, key);
        else
            return getNode(node.right, key);
    }

    /**
     * entry point for testing.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BST<Integer, String> bst = new CompletedBST();

        bst.put(10, "TEN");
        bst.put(3, "THREE");
        bst.put(1, "ONE");
        bst.put(5, "FIVE");
        bst.put(2, "TWO");
        bst.put(7, "SEVEN");

        System.out.println("Before balance:");
        System.out.println(bst.displayLevel(10)); // root

        System.out.println("After balance:");
        bst.balance();
        System.out.println(bst.displayLevel(5)); // root
    }
}
