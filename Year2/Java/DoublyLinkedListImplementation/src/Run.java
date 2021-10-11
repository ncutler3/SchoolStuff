import java.util.*;

public class Run {
    public static void main(String[] args) {
        DoublyLinkedList sortList = new DoublyLinkedList();
        int[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        for(int c=0; c<numbers.length;c++)
            sortList.addLast(numbers[c]);
        sortList.printAll();
        try {
            sortList.setupSearch();
            sortList.searchList(15);
            sortList.setupSearch();
            sortList.searchList(99);
        }catch(Exception NullPointerException){
            System.out.println("NULL issue");
        }
    }
}
