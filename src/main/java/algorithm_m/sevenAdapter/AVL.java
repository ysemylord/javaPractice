package algorithm_m.sevenAdapter;

public class AVL extends BinSearchTree {


    /**
     * 选取左右孩子的最高者
     * @return
     */
    private BinNode tallerChild(BinNode x){
        if(stature(x.leftChild)>stature((x.rightChild))){
            return x.leftChild;
        } else if(stature(x.rightChild)>stature((x.leftChild))){
            return x.rightChild;
        }else{
            return x.isLefChild()?x.leftChild:x.rightChild;//等高则同侧
        }
    }

    /**
     * 判断一个节点是AVL条件下的平衡
     * @param
     * @return
     */
    public boolean isAVLBalance(BinNode x){
         return Math.abs(balance(x))<=1;//左右子树高度差不超过1
    }

    public int balance(BinNode x){
        return stature(x.leftChild)-stature(x.rightChild);
    }


    /**
     * 重新连接中序遍历的3个节点，及其子树
     * @param a
     * @param b
     * @param c
     * @param t0
     * @param t1
     * @param t2
     * @param t3
     * @return
     */
    private BinNode connect34(BinNode a, BinNode b, BinNode c, BinNode t0, BinNode t1, BinNode t2, BinNode t3) {
        a.leftChild = t0;
        if (t0 != null) {
            t0.parent = a;
        }
        c.rightChild = t1;
        if (t1 != null) {
            t1.parent = a;
        }
        updateHeight(a);

        b.leftChild = a;
        b.rightChild = c;
        updateHeight(b);

        c.leftChild = t2;
        if (t2 != null) {
            t2.parent = c;
        }
        c.rightChild = t3;
        if (t3 != null) {
            t3.parent = c;
        }
        updateHeightAbove(c);
        return b;
    }

    /**
     * 找到节点v
     * 对应的3个节点，及其子树
     *
     * @param v
     * @return
     */
    public BinNode roate(BinNode v) {
        BinNode p = v.parent, g = p.parent;
        //每种情况要配合相应的图解才能理解清楚
        if (v.isRightChild()) {
            if (p.isRightChild()) {//zag
                p.parent = g.parent;//向上连接
                return connect34(g, p, v, g.leftChild, p.leftChild, v.leftChild, v.rightChild);
            } else {//zig,zag

            }
        } else if (v.isLefChild()) {

            if (p.isLefChild()) {
                p.parent = g.parent;
                return connect34(v, p, g, v.leftChild, v.rightChild, p.rightChild, g.rightChild);
            }

            if (p.isRightChild()) {
                v.parent = g.parent;
                return connect34(g, v, p, p.leftChild, v.leftChild, v.rightChild, g.rightChild);
            } else {
               p.parent=g.parent;
               return connect34(p,v,g,p.leftChild,v.leftChild,v.rightChild,g.rightChild);
            }
        }
        return null;//不可能发生
    }
}
