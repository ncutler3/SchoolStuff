public class Run {
    public static void main(String[] args){
        LinkedTree<String> fileTree = new LinkedTree("/user/rt/courses/");

        fileTree.addChild(fileTree.root(), "cs016/");

        fileTree.addChild(fileTree.root.getChildren().get(0), "grades");
        fileTree.addChild(fileTree.root.getChildren().get(0), "homeworks/");
        fileTree.addChild(fileTree.root.getChildren().get(0), "programs/");

        fileTree.addChild(fileTree.root.getChildren().get(0).getChildren().get(1), "hw1");
        fileTree.addChild(fileTree.root.getChildren().get(0).getChildren().get(1), "hw2");
        fileTree.addChild(fileTree.root.getChildren().get(0).getChildren().get(1), "hw3");
        fileTree.addChild(fileTree.root.getChildren().get(0).getChildren().get(2), "pr1");
        fileTree.addChild(fileTree.root.getChildren().get(0).getChildren().get(2), "pr2");
        fileTree.addChild(fileTree.root.getChildren().get(0).getChildren().get(2), "pr3");

        fileTree.addChild(fileTree.root(), "cs252/");
        fileTree.addChild(fileTree.root.getChildren().get(1), "projects/");
        fileTree.addChild(fileTree.root.getChildren().get(1), "grades");

        fileTree.addChild(fileTree.root.getChildren().get(1).getChildren().get(0), "papers/");
        fileTree.addChild(fileTree.root.getChildren().get(1).getChildren().get(0), "demos/");

        fileTree.addChild(fileTree.root.getChildren().get(1).getChildren().get(0).getChildren().get(0), "buylow");
        fileTree.addChild(fileTree.root.getChildren().get(1).getChildren().get(0).getChildren().get(0), "sellhigh");
        fileTree.addChild(fileTree.root.getChildren().get(1).getChildren().get(0).getChildren().get(1), "market");

        System.out.println("PreOrder:");
        fileTree.printPreOrder(fileTree.root);
        System.out.println("");

        System.out.println("PostOrder:");
        fileTree.printPostOrder(fileTree.root);
    }
}
