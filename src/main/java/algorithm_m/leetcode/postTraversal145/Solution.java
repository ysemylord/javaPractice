package algorithm_m.leetcode.postTraversal145;

import algorithm_m.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> integerList = new ArrayList<>();
        traversal(root, integerList);
        return integerList;
    }

    private void traversal(TreeNode root, List<Integer> rootList) {
        if (root == null) {
            return;
        }
        traversal(root.left, rootList);
        traversal(root.right, rootList);
        rootList.add(root.val);
    }
}
