package algorithm_m.fiveAdapter.binTree;

import algorithm_m.fourAdapter.MyQueue;

import java.util.Stack;

public class BinTree implements BinTreeInterface {

    /**
     * 为了在与binNode为null时（空树状态）保持一致性，增设stature方法，获取节点的高度。
     *
     * @param binNode
     * @return
     */
    public int stature(BinNode binNode) {
        if (binNode == null)
            return -1;
        return binNode.height;
    }

    public static class BinNode {
        public BinNode parent;
        public BinNode leftChild;
        public BinNode rightChild;
        public int data;
        int height = 0;//初始时，高度为0


        /**
         * 构造一个节点，并制定其parent
         *
         * @param parent
         * @param data
         */
        public BinNode(BinNode parent, int data) {
            this.parent = parent;
            this.data = data;
        }

        /**
         * 将元素e作为左孩子插入
         *
         * @param e
         * @return
         */
        public BinNode insertAsLC(int e) {
            BinNode binNode = new BinNode(this, e);
            this.leftChild = binNode;
            return binNode;
        }

        /**
         * 将元素e作为右孩子插入
         *
         * @param e
         * @return
         */
        public BinNode insertAsRC(int e) {
            BinNode binNode = new BinNode(this, e);
            this.rightChild = binNode;
            return binNode;
        }

        /**
         * 该节点的后代的总数，即以该节点为子树的规模
         * <p>
         * 为了保证时效，不增设成员变量，而是动态获取
         *
         * @return
         */
        public int size() {
            int size = 1;
            if (leftChild != null || rightChild != null) {//递归基

                //分而治之

                if (leftChild != null) {
                    size = size + leftChild.size();//递归计入左子树规模
                }
                if (rightChild != null) {
                    size = size + rightChild.size();
                }
            }
            return size;
        }

        public boolean hasLeftChild() {
            return leftChild != null;
        }

        public boolean hasRightChild() {
            return rightChild != null;
        }

        /**
         * 节点的直接后继（中序遍历序列中的后一个节点）
         *
         * @return
         */
        public BinNode succ() {
            BinNode s = this;
            if (s.hasRightChild()) {//从右子树的左分支上查找直接后继
                s = s.rightChild;
                while (s.hasLeftChild()) s = s.leftChild;
            } else {
                while (s.isRightChild()) {//在自己所在的右分支上一直向上查找
                    s = s.parent;
                }
                s = s.parent;
            }
            return s;
        }

        public boolean isRightChild() {
            if (!isRoot()&&parent.rightChild == this) {
                return true;
            }
            return false;
        }

        public boolean isLefChild(){
            if(!isRoot()&&parent.leftChild==this){
                return true;
            }
            return false;
        }

        private boolean isRoot(){
            return parent==null?true:false;
        }
    }

    BinNode root;
    protected int size;

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size;
    }

    public BinNode getRoot() {
        return root;
    }

    /**
     * 更新节点的高度
     *
     * @return
     */
    public int updateHeight(BinNode binNode) {
        int height = 1 + Math.max(stature(binNode.leftChild), stature(binNode.rightChild));
        return height;
    }

    /**
     * 更新节点binNode及其祖先的高度
     * 在插入LC,RC会调用此方法更新祖先的高度,这样保证了BinNode.height的时效性
     *
     * @return
     */
    public void updateHeightAbove(BinNode binNode) {
        while (binNode != null) {
            updateHeight(binNode);
            binNode = binNode.parent;
        }
    }

    /**
     * 将某一元素作为根节点插入
     *
     * @param e
     */
    public BinNode insertAsRoot(int e) {
        size = 1;

        return root=new BinNode(null, e);
    }

    /**
     * 将元素e作为书中节点bindNode节点的孩子插入
     *
     * @param binNode
     * @param e
     * @return
     */
    public BinNode insertAsLC(BinNode binNode, int e) {
        size++;
        binNode.insertAsLC(e);
        updateHeightAbove(binNode);
        return binNode.leftChild;
    }

    /**
     * 将元素e作为书中节点bindNode节点的孩子插入
     *
     * @param binNode
     * @param e
     * @return
     */
    public BinNode insertAsRC(BinNode binNode, int e) {
        size++;
        binNode.insertAsRC(e);
        updateHeightAbove(binNode);
        return binNode.rightChild;
    }

    /**
     * 先序遍历子树
     *
     * @param root 子树的根
     */
    public void preTraversal(BinNode root) {
        if (root == null) return;
        System.out.println(root.data);//访问根节点
        preTraversal(root.leftChild);
        preTraversal(root.rightChild);
    }

    /**
     * 先序遍历子树
     * 迭代算法
     *
     * @param root 子树的根
     */
    public void preTraversalI(BinNode root) {
        Stack<BinNode> binNodeStack = new Stack<>();
        binNodeStack.push(root);
        while (!binNodeStack.isEmpty()) {
            BinNode partRoot = binNodeStack.pop();//访问根节点
            System.out.println(partRoot.data);

            //因为栈是LIFO,所以右孩子先进栈
            if (partRoot.hasRightChild()) binNodeStack.push(partRoot.rightChild);
            if (partRoot.hasLeftChild()) binNodeStack.push(partRoot.leftChild);
        }
    }

    /**
     * 先序遍历子树
     * 迭代方法
     * 将一颗树划分为做侧链和右子树
     *
     * @param root
     */
    public void preTraversalII(BinNode root) {
        Stack<BinNode> rightChildTree = new Stack<>();

        while (true) {
            visitAlongLeftBranch(root, rightChildTree);
            if (rightChildTree.isEmpty()) {
                return;
            }
            root = rightChildTree.pop();
        }
    }


    /**
     * @param partRoot       左侧链的根
     * @param rightChildTree 右子树
     */
    private void visitAlongLeftBranch(BinNode partRoot, Stack<BinNode> rightChildTree) {
        while (partRoot != null) {
            System.out.println(partRoot.data);//访问左侧链
            if (partRoot.hasRightChild()) rightChildTree.push(partRoot.rightChild);//收纳右子树
            partRoot = partRoot.leftChild;
        }
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void inTraversal(BinNode root) {
        if (root == null) return;
        inTraversal(root.leftChild);
        System.out.println(root.data);
        inTraversal(root.rightChild);

    }


    /**
     * 中序遍历的迭代实现
     *
     * @param root
     */
    public void inTraversalI(BinNode root) {
        Stack<BinNode> leftBranch = new Stack<>();
        while (true) {
            goAloginLeftBranch(root, leftBranch);//收纳左分支
            if (leftBranch.isEmpty()) break;
            root = leftBranch.pop();//x点为没有做孩子的点或者左孩子已经访问了的点
            System.out.println(root.data);
            root = root.rightChild;

        }
    }

    /**
     * 收纳左分支
     *
     * @param parRoot
     * @param leftBranch
     */
    private void goAloginLeftBranch(BinNode parRoot, Stack<BinNode> leftBranch) {
        while (parRoot != null) {
            leftBranch.push(parRoot);
            parRoot = parRoot.leftChild;
        }
    }


    /**
     * 后序遍历
     *
     * @param root
     */
    public void postTraversal(BinNode root) {
        if (root == null) return;
        inTraversal(root.leftChild);
        inTraversal(root.rightChild);
        System.out.println(root.data);
    }

    /**
     * 深度遍历
     */
    public void traversalLevel(BinNode root) {
        MyQueue<BinNode> binNodeQueue = new MyQueue<>();
        binNodeQueue.enQue(root);
        while (!binNodeQueue.isEmpty()) {
            BinNode visitedNode = binNodeQueue.deQue();
            System.out.println(visitedNode.data);
            if (visitedNode.hasLeftChild()) binNodeQueue.enQue(visitedNode.leftChild);
            if (visitedNode.hasRightChild()) binNodeQueue.enQue(visitedNode.rightChild);
        }

    }

    // 实现中序遍历的迭代器,其实是中序遍历迭代版的变种
    public class BTInIterator {
        Stack<BinNode> leftBranch = new Stack<>();
        public BTInIterator(BinNode root) {
              goAloginLeftBranch(root,leftBranch);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !leftBranch.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
               BinNode binNode=leftBranch.pop();
               goAloginLeftBranch(binNode.rightChild,leftBranch);
               return binNode.data;
        }
    }

    public BTInIterator getInIterator(){
        return new BTInIterator(getRoot());
    }

}
