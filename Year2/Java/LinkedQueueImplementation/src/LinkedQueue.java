public class LinkedQueue<E> implements Queue<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    public LinkedQueue(){}

    public int size(){
        return list.size();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public void enqueue(E element){
        list.addLast(element);
    }
    public E first(){
        return list.first();
    }
    public E dequeue(){
        return list.removeFirst();
    }

    public <E> void quickSort(Queue<E> a, PointComparator comp){
        int n = a.size();
        if(n < 2)
            return;
        E pivot = a.first();
        Queue<E> L = new LinkedQueue<>();
        Queue<E> E = new LinkedQueue<>();
        Queue<E> G = new LinkedQueue<>();
        while(!a.isEmpty()) {
            E element = a.dequeue();
            int c = comp.compare(element, pivot);
            if(c < 0)
                L.enqueue(element);
            else if(c == 0)
                E.enqueue(element);
            else
                G.enqueue(element);
        }
        quickSort(L,comp);
        quickSort(G, comp);

        while(!L.isEmpty())
            a.enqueue(L.dequeue());
        while(!E.isEmpty())
            a.enqueue(E.dequeue());
        while(!G.isEmpty())
            a.enqueue(G.dequeue());
    }

    public void print() {
        SinglyLinkedList.Node<E> currentNode = this.list.getHead();
        String s = "";
        while(currentNode != null){
            s += currentNode.getElement().toString() + "  ";
            currentNode = currentNode.getNext();
        }
        System.out.println(s);
    }

}
