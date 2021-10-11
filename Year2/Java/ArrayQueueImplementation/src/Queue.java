public interface Queue<E>{
    int size();

    boolean isEmpty();

    E first();

    void enqueue(E e);

    E dequeue();
}