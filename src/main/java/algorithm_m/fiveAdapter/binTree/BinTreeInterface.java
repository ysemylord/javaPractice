package algorithm_m.fiveAdapter.binTree;

import algorithm_m.fourAdapter.MyQueue;

public interface BinTreeInterface {
    /**
     * 将某一元素作为根节点插入
     *
     * @param e
     */
    public BinTree.BinNode insertAsRoot(int e);

    /**
     * 将元素e作为书中节点bindNode节点的左孩子插入（binNode原来没有左孩子）
     *
     * @param binNode
     * @param e
     * @return
     */
    public BinTree.BinNode insertAsLC(BinTree.BinNode binNode, int e);

    /**
     * 将元素e作为节点bindNode节点的右孩子插入(bindNode原来没有右孩子)
     *
     * @param binNode
     * @param e
     * @return
     */
    public BinTree.BinNode insertAsRC(BinTree.BinNode binNode, int e);

    /**
     * 先序遍历子树
     *
     * @param root 子树的根
     */
    public void preTraversal(BinTree.BinNode root);

    public void inTraversal(BinTree.BinNode root);

    /**
     * 后序遍历
     * @param root
     */
    public void postTraversal(BinTree.BinNode root);

    /**
     * 深度遍历
     */
    public void traversalLevel(BinTree.BinNode root);


}
