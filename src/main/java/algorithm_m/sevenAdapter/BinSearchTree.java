package algorithm_m.sevenAdapter;

import algorithm_m.fiveAdapter.binTree.BinTree;

public class BinSearchTree extends BinTree implements BinSearchTreeInterface {
    @Override
    public BinNode search(int e) {
        SearchInResult searchInResult = new SearchInResult();
        BinNode binNode = searchIn(getRoot(), e, searchInResult);
        return binNode;
    }

    /**
     * 插入节点
     * 根据BST的定义，插入得节点都在叶子节点上，不会在树中间的节点
     * @param e
     * @return
     */
    @Override
    public BinNode insert(int e) {
        SearchInResult searchInResult = new SearchInResult();
        BinNode x = searchIn(getRoot(), e, searchInResult);
        if (x == null) {//禁止重复（其实这里可以改写成，如果重复就进行覆盖覆盖，就像Map一样）

            //x为null，无法知道x的父节点，也无法知道插入位置是父节点的左孩子还是右孩子,所以要利用SearchResult中记录的hot
            BinNode hot = searchInResult.hot;
            x = new BinNode(hot, e);//插入节点到hot节点的连接

            //hot节点到插入节点的连接
            if (searchInResult.dirct == 0) {
                hot.leftChild = x;
            } else if (searchInResult.dirct == 1) {
                hot.rightChild = x;
            }
            size++;
            updateHeightAbove(x);
        }
        return x;
    }

    /**
     * @param v              子树的根节点
     * @param e              要查找的元素
     * @param searchInResult
     * @return 查找的元素
     */
    private BinNode searchIn(BinNode v, int e, SearchInResult searchInResult) {//尾递归可改为迭代

        if (v == null) {
            return null;
        }

        if (v != null && v.data == e) {
            searchInResult.searchedNode = v;
            return v;
        }

        searchInResult.hot = v;

        if (e < v.data) {
            searchInResult.dirct = 0;
            return searchIn(v.leftChild, e, searchInResult);
        } else {
            searchInResult.dirct = 1;
            return searchIn(v.rightChild, e, searchInResult);
        }
    }

    /**
     * 使用SearchInResult来保存searchIn的结果
     */
    private class SearchInResult {
        BinNode searchedNode;//查找到的节点
        BinNode hot;//查找到的节点的父节点。因为如果查找到的点是一个哨兵节点，此时searchedNode=null,无法通过searchedNode.parent检索到其父节点
        int dirct = -1;//0左孩子，1右孩子

    }

    public boolean remove(int e) {
        SearchInResult searchInResult = new SearchInResult();
        BinNode x = searchIn(getRoot(), e, searchInResult);
        if (x == null) return false;//没有找到元素e
        removeAt(x, searchInResult.hot);
        size--;
        updateHeightAbove(searchInResult.hot);
        return true;
    }

    private BinNode removeAt(BinNode x, BinNode hot) {
        BinNode w = x;//w为实际删除的点
        hot = x.parent;
        BinNode succ = null;//succ为删除的点的接替者

        //-------x的孩子的各种情况
        if ((x.leftChild == null && x.rightChild != null) || (x.leftChild == null && x.rightChild == null)) {//只有右孩子，或者左右孩子饿都没有
            //用x的右子树替换x
            w = x;
            succ = w.rightChild;

            //hot到succ的连接
            if (w.isRightChild()) {
                hot.rightChild = succ;
            } else {
                hot.leftChild = succ;
            }

        } else if (x.leftChild != null && x.rightChild == null) {//只有左还在
            //用x的左子树替换x
            w = x;
            succ = w.leftChild;

            if (hot.rightChild == w) {
                hot.rightChild = succ;
            } else {
                hot.leftChild = succ;
            }
        } else {//孩子双全
            //x与直接后继交换数据
            int temp = x.data;
            BinNode directSucc = x.succ();
            x.data = directSucc.data;
            directSucc.data = temp;

            //succ接替w
            w = directSucc;
            succ = directSucc.rightChild;
            if (w.isRightChild()) {
                w.parent.rightChild = succ;
            } else {
                w.parent.leftChild = succ;
            }
        }
        //---------

        //设置w,succ变量，是为了忽略x的各种情况，将以下步骤统一
        hot = w.parent;//hot记录下被删除点的父节点；
        if (succ != null) {
            succ.parent = hot;//succ到hot的连接
        }
        return w;

    }
}
