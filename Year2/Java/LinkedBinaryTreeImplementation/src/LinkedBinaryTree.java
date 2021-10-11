import java.util.IllegalFormatCodePointException;
import java.util.Iterator;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        public E getElement() {
            return element;
        }
        public Node<E> getParent() {
            return parent;
        }
        public Node<E> getLeft() {
            return left;
        }
        public Node<E> getRight() {
            return right;
        }

        public void setElement(E e) {
            element = e;
        }
        public void setParent(Node<E> parentNode) {
            parent = parentNode;
        }
        public void setLeft(Node<E> leftChild) {
            left = leftChild;
        }
        public void setRight(Node<E> rightChild) {
            right = rightChild;
        }
    }

    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(e,parent,left,right);
    }

    protected Node<E> root = null;
    private int size = 0;

    public LinkedBinaryTree(){}

    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if(!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>) p;
        if(node.getParent() == node)
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    public int size() {
        return size;
    }

    public Position<E> root() {
        return root;
    }

    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    public Position<E> addRoot(E e) throws IllegalStateException {
        if(!isEmpty()) throw new IllegalStateException("Tree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if(parent.getLeft() != null)
            throw new IllegalArgumentException("p already has a left child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if(parent.getRight() != null)
            throw new IllegalArgumentException("p already has a right child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void inOrder(Node<E> node) {
        if(node == null)
            return;
        inOrder(node.left);
        System.out.printf("%s", node.element);
        inOrder(node.right);
    }


    //much like the inorder i had to create a second function that took an element as well as a node in order for it
    //to be able to go deeper than the root's left and right children.
    public void add(E e) {
        int x = 0;
        if(isEmpty()) { // if tree is empty sets root to e
            addRoot(e);
            x = (int) root.element;
            return;
        }
        else {
            x = (int) root.element; // i had a lot of issues with comparing e to node elements, so i just set everything to an integer to protect my sanity
            if (x < (int) e) {
                if (root.right == null)
                    addRight(root, e);
                else if (root.right.element != null) {
                    Node<E> node = root.right;
                    add(e, node);
                }
            }
            else if (x > (int) e) { // i have cases for if e is smaller or larger than x

                if (root.left == null)
                    addLeft(root, e);
                else if (root.left.element != null) {
                    Node<E> node = root.left;
                    add(e, node);
                }
            }
            else if (x == (int) e) //case for if the number you are trying to add is already in the list (assuming we dont want duplicates)
                System.out.println("element you want to add is identical to another already in the list");
        }
    }

    //secondary add function to take the output of the initial add and allow it to go past a depth of 1
    public void add(E e, Node<E> node) {
        int x = (int) node.element;
        if (x < (int) e) { // continued with the casting to an int cuz it was working well
            if (node.right == null)
                addRight(node, e);
            else if (node.right.element != null) {
                node = node.right;
                add(e, node);
            }
        } else if (x > (int) e) {
            if (node.left == null)
                addLeft(node, e);
            else if (node.left.element != null) {
                node = node.left;
                add(e, node);
            }
        } else
            System.out.println("element you want to add is identical to another already in the list");
    }


    // so i followed a similar proccess to how inorder works, with initially passing just an element and then passing root
    // and an element onto another find function where it would reference 'node' instead of just root so it could
    // properly traverse the tree
    public boolean find(E e){
        return findSubtree(e, root);
    }

    public boolean findSubtree(E e, Node<E> node){
        if(node == null)
            return false;
        if(node.getElement() == e)
            return true;
        return findSubtree(e, (int) node.getElement() < (int) e ? node.getRight() : node.getLeft());
    }
}
