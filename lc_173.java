/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    TreeNode p = null;
    private Stack<TreeNode>s = new Stack<>();
    public BSTIterator(TreeNode root) {
        p = root;
       // s.push(p);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() { //push the left line to stack;
        while(p!=null){
           s.push(p);
           p = p.left;
        }
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmp = s.pop();
        p = tmp.right;
        return tmp.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
