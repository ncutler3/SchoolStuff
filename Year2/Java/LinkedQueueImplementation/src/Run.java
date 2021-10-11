public class Run {
    public static void main(String[] args){

        LinkedQueue queue = new LinkedQueue();
        Point a = new Point(5,6);
        Point b = new Point(7,10);
        Point c = new Point(50,4);
        Point d = new Point(7,3);

        queue.enqueue(a);
        queue.enqueue(b);
        queue.enqueue(c);
        queue.enqueue(d);

        queue.print();

        PointComparator comparator = a;
        queue.quickSort(queue,comparator);

        queue.print();
    }
}
