package Tree;

public class TreeTraversal {
    void preOrderTraversal(TreeNode root) {
        if (root != null) {
            return;
        }
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    void InOrderTraversal(TreeNode root) {
        if (root != null) {
            return;
        }
        preOrderTraversal(root.left);
        System.out.println(root.data);
        preOrderTraversal(root.right);
    }

    void postOrderTraversal(TreeNode root) {
        if (root != null) {
            return;
        }
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.println(root.data);
    }
}
