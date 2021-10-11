import java.util.ArrayList;
import java.util.Iterator;

public class LinkedTree<E> extends AbstractTree<E> implements Tree<E>{

    public LinkedTree(E rootData){
        root = new Node<E>(null,null,null);
        root.element = rootData;
        root.children = new ArrayList<>();
    }

    public static class Node<E> implements Position<E>{
        private E element;
        private Node<E> parent;
        private ArrayList<Node<E>> children;

        public Node(E e, Node<E> above, ArrayList<Node<E>> childs){
            element = e;
            parent = above;
            children = childs;
        }

        public E getElement(){
            return element;
        }
        public Node<E> getParent(){
            return parent;
        }
        public ArrayList<Node<E>> getChildren(){
            return children;
        }

        public void setElement(E e){
            element = e;
        }
        public void setParent(Node<E> parentNode){
            parent = parentNode;
        }
        public void setChildren(ArrayList<Node<E>> childrenList){
            children = childrenList;
        }
    }

    protected Node<E> createNode(E e, Node<E> parent, ArrayList<Node<E>> childs) {
        return new Node<E>(e,parent,childs);
    }

    protected Node<E> root = null;
    private int size = 0;

    public LinkedTree(){}

    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if(!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>) p;
        if(node.getParent() == node)
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    public Position<E> addRoot(E e) throws IllegalStateException {
        if(!isEmpty()) throw new IllegalStateException("Tree is not empty");
        root = createNode(e, null, null);
        size = 1;
        return root;
    }

    public Position<E> addChild(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        //Node<E> parent = node;
        ArrayList childs = new ArrayList<>();
        Node<E> child = createNode(e, parent, childs);
        int s;
        if(parent.getChildren() == null)
            s = 0;
        else
            s = parent.getChildren().size();
        parent.getChildren().add(s,child);
        return child;
    }

    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }

    @Override
    public int numChildren(Position<E> p) throws IllegalArgumentException {
        Node<E> node =validate(p);
        int count = 0;
        for(int c = 0; c < node.children.size(); c++)
            count++;
        return count;
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        ArrayList<Position<E>> snapshot = new ArrayList<>();
        Node<E> node = validate(p);
        for(int c=0; c<node.children.size(); c++)
            snapshot.set(c, node.children.get(c));
        return snapshot;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    public void printPreOrder(Node<E> node){
        if(node == null)
            return;
        System.out.print(node.getElement() + "-->");

        for(int c=0; c<node.children.size();c++)
            printPreOrder(node.children.get(c));
    }

    public void printPostOrder(Node<E> node){
        if(node == null)
            return;

        for(int c=0; c<node.children.size();c++)
            printPostOrder(node.children.get(c));
        System.out.print(node.getElement() + "-->");
    }
}
