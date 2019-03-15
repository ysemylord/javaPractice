package algorithm_m.fiveAdapter;

import algorithm_m.fiveAdapter.binTree.BinTree;

public class LevelTraverse {

    public static void main(String[] args) {
        BinTree binTree = new BinTree();
        BinTree.BinNode root = binTree.insertAsRoot(1);
        BinTree.BinNode leftChild = binTree.insertAsLC(root, 2);
        BinTree.BinNode rightChild = binTree.insertAsRC(root, 3);
        BinTree.BinNode fourNode = binTree.insertAsLC(leftChild, 4);
        binTree.insertAsRC(leftChild, 5);
        binTree.traversalLevel(root);

    }


}
