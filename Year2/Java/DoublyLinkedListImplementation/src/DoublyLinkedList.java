public class DoublyLinkedList<E> {
    private static class Node<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            prev = p;
            next = n;
        }
        public E getElement(){
            return element;
        }
        public Node<E> getPrev(){
            return prev;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setPrev(Node<E> p){
            prev = p;
        }
        public void setNext(Node<E> n){
            next = n;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList(){
        header = new Node<>(null,null,null);
        trailer = new Node<>(null,header,null);
        header.setNext(trailer);
    }

    private void addBetween(E e, Node<E> prev, Node<E> next){
        Node<E> newest = new Node<>(e,prev,next);
        prev.setNext(newest);
        next.setPrev(newest);
        size++;
    }

    public void addLast(E e){
        addBetween(e,trailer.getPrev(),trailer);
    }

    public void printAll(){
        Node<E> currentNode = header.getNext();
        while(currentNode != null){
            if(currentNode == trailer)
                break;
            System.out.print(currentNode.getElement() + " ");
            currentNode = currentNode.getNext();
        }
        System.out.println("");
    }

    private Boolean exists = false;
    Node<E> left;
    Node<E> right;
    Node<E> midpoint;

    public void setupSearch() {
        left = header.getNext();
        right = trailer.getPrev();
    }

    public int findMidpoint(){
        Node<E> counter = left;
        int c = 1;
        while(counter != right){
            counter = counter.getNext();
            c++;
        }
        return c/2;
    }

    public void setMidpoint(){
        Node<E> counter = left;
        int c = 1;
        while(counter != right){
            counter = counter.getNext();
            c++;
        }
        int half = c/2;
        for(int x=0;x<half;x++)
            midpoint = midpoint.getNext();
    }

    public Boolean searchList(int i) throws NullPointerException {

        midpoint = left;
        setMidpoint();
        int cool = findMidpoint();

        if(i > (int)trailer.getPrev().getElement() || i < (int)header.getNext().getElement()) {
            exists = false;
            System.out.println(i + ": " + exists);
            return exists;
        }
        System.out.println("midpoint = " + (int)midpoint.getElement());
        if(i > (int)midpoint.getElement()) {
            int why = findMidpoint();
            for (int c = 0; c < why; c++) {
                left = left.getNext();
                //System.out.println(left.getElement());
                //System.out.println(c + " : " + cool);
            }
            return searchList(i);
        }
        else if(i < (int)midpoint.getElement()) {
            int why = findMidpoint();
            for (int c = 0; c < why; c++) {
                right = right.getPrev();
                //System.out.println(right.getElement());
                //System.out.println(c + " : " + cool);
            }
            return searchList(i);
        }
        else if(i == (int)midpoint.getElement()) {
            exists = true;
            System.out.println(i + ": " + exists);
            System.out.println("-------------");
            return exists;
        }
        System.out.println(exists);
        return exists;
    }

}
