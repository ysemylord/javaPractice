package algorithm_m.sevenAdapter;

public class BinSearchTreeDemo {
    public static void main(String[] args) {
        BinSearchTree binTree=new BinSearchTree();
        binTree.insertAsRoot(100);
        binTree.insert(12);
        binTree.insert(9);
        binTree.insert(2);
        binTree.insert(200);
        binTree.insert(201);
        binTree.insert(178);
        binTree.insert(180);
        binTree.insert(185);
        binTree.insert(13);
        binTree.remove(200);
        binTree.remove(12);
        binTree.inTraversal(binTree.getRoot());
    }
}
