package algorithm_m.leetcode.inOrderTraversal94;

import algorithm_m.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> integerList = new ArrayList<>();
        traversal(root, integerList);
        return integerList;
    }

    private void traversal(TreeNode root, List<Integer> rootList) {
        if (root == null) {
            return;
        }
        traversal(root.left, rootList);
        rootList.add(root.val);
        traversal(root.right, rootList);
    }

}
