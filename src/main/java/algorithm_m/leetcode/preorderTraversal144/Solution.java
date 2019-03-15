package algorithm_m.leetcode.preorderTraversal144;

import algorithm_m.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> vistedNodeVal = new ArrayList<>();
        Stack<TreeNode> rightChildTrees = new Stack<>();
        while (true) {
            visiteAlongLeftBranch(root, rightChildTrees, vistedNodeVal);
            if(rightChildTrees.isEmpty()){
                break;
            }
            root=rightChildTrees.pop();
        }
        return vistedNodeVal;
    }

    /**
     * 访问做侧链，收纳右子树
     *
     * @param partNode
     * @param rightChildTrees
     * @param visitedNode
     */
    private void visiteAlongLeftBranch(TreeNode partNode, Stack<TreeNode> rightChildTrees, List<Integer> visitedNode) {

        while (partNode != null) {
            visitedNode.add(partNode.val);//访问左侧链
            if (partNode.right != null) rightChildTrees.push(partNode.right);//收纳右子树
            partNode = partNode.left;
        }
    }
}
