public class Run {
    public static void main (String[] args){
        ArrayQueue queue1 = new ArrayQueue(5);
        queue1.enqueue('A');
        queue1.enqueue('B');
        queue1.enqueue('C');
        queue1.enqueue('D');
        queue1.enqueue('E');

        queue1.dequeue();
        queue1.dequeue();

        queue1.enqueue('F');
        queue1.enqueue('G');

        queue1.print();
    }
}
