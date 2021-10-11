public class Run {
    public static void main(String[] args){
        SortedPriorityQueue<Integer, String> appointments = new SortedPriorityQueue<Integer, String>();

        appointments.insert(11, "Alice");
        appointments.insert(3, "Bob");
        appointments.insert(11, "Cat");
        appointments.insert(11, "Dan");
        appointments.insert(1, "Eric");

        for(int c=0;c<5; c++){
            System.out.println(appointments.removeMin().getValue());
        }
    }
}
