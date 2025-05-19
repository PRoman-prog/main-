import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinarySearchTreeDepth {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = null;

        while (true) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }

            if (!contains(root, num)) {
                root = insert(root, num);
                int depth = getDepth(root, num);
                System.out.println(depth);
            }
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

    public static boolean contains(TreeNode root, int val) {
        if (root == null) {
            return false;
        }

        if (val < root.val) {
            return contains(root.left, val);
        } else if (val > root.val) {
            return contains(root.right, val);
        } else {
            return true;
        }
    }

    public static int getDepth(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }

        if (val < root.val) {
            return getDepth(root.left, val) + 1;
        } else if (val > root.val) {
            return getDepth(root.right, val) + 1;
        } else {
            return 1;
        }
    }
}
