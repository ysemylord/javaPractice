package algorithm_m.fiveAdapter;

import algorithm_m.fiveAdapter.binTree.BinTree;

public class InTraverse {

    public static void main(String[] args) {
        BinTree binTree = new BinTree();
        BinTree.BinNode root = binTree.insertAsRoot(1);
        BinTree.BinNode leftChild = binTree.insertAsLC(root, 2);
        BinTree.BinNode rightChild = binTree.insertAsRC(root, 3);
        binTree.insertAsLC(leftChild,4);
        binTree.insertAsRC(leftChild,5);
        binTree.inTraversal(root);
        System.out.println("--------------");
        binTree.inTraversalI(root);

        System.out.println("\n");
        System.out.println(leftChild.data+"的直接后继是"+leftChild.succ().data);

        System.out.println("使用迭代方式访问");
        BinTree.BTInIterator  btInIterator=binTree.getInIterator();
        while(btInIterator.hasNext()){
            System.out.println(btInIterator.next());
        }

    }


}
