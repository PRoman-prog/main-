import java.util.ArrayList;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinarySearchTreeNodesWithTwoChildren {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = null;

        while (true) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            root = insert(root, num);
        }

        ArrayList<Integer> nodesWithTwoChildren = new ArrayList<>();
        collectNodesWithTwoChildren(root, nodesWithTwoChildren);

        for (int node : nodesWithTwoChildren) {
            System.out.println(node);
        }
    }

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void collectNodesWithTwoChildren(TreeNode root, ArrayList<Integer> nodesWithTwoChildren) {
        if (root == null) {
            return;
        }

        // In-order traversal to collect nodes in ascending order
        collectNodesWithTwoChildren(root.left, nodesWithTwoChildren);

        if (root.left != null && root.right != null) {
            nodesWithTwoChildren.add(root.val);
        }

        collectNodesWithTwoChildren(root.right, nodesWithTwoChildren);
    }
}
