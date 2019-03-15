package algorithm_m.leetcode.BSTIterator173;

import algorithm_m.fiveAdapter.binTree.BinTree;
import algorithm_m.leetcode.TreeNode;

import java.util.Stack;


public class BSTIterator {

    Stack<TreeNode> leftBranch = new Stack<>();

    public BSTIterator(TreeNode root) {
        goAloginLeftBranch(root, leftBranch);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !leftBranch.isEmpty();

    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode binNode = leftBranch.pop();
        goAloginLeftBranch(binNode.right, leftBranch);
        return binNode.val;
    }

    /**
     * 收纳左分支
     *
     * @param parRoot
     * @param leftBranch
     */
    private void goAloginLeftBranch(TreeNode parRoot, Stack<TreeNode> leftBranch) {
        while (parRoot != null) {
            leftBranch.push(parRoot);
            parRoot = parRoot.left;
        }
    }
}

