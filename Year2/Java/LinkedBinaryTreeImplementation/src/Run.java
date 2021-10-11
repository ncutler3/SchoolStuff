public class Run {
    public static void main(String[] args) {
        int[] nums = {5,4,20,15,3,1, 50, 7, 9};
        LinkedBinaryTree<Integer> list = new LinkedBinaryTree<>();

        for (int c = 0; c < nums.length; c++)
            list.add(nums[c]); //fill tree with values using the add function(s)

        for (Position<Integer> e : list.inorder()) {
            System.out.println(e.getElement()); //printing out the tree using inorder
        }

        System.out.println(list.find(2)); //searching for an element that is not in the tree
        System.out.println(list.find(50)); //searching for an element that is in the tree
    }
}
