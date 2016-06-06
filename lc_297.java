/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder str = new StringBuilder();
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
        int count = 1;
        while(!q.isEmpty()){
            if(count == 0) break;
            count = 0;
            int sz = q.size();
            for(int i = 0; i < sz; i++){
                TreeNode cur = q.poll();
                if(cur == null) {str.append(","+"null");continue;}
                str.append(str.length()==0?cur.val:","+cur.val);
                if( cur.left != null) {count++;}
                if( cur.right != null){count++;}
                q.add(cur.left);
                q.add(cur.right);
            }
        }
        return str.toString();   
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[]strs = data.split(",");
        List<TreeNode>list = new ArrayList<>();
        for(int i = 0; i< strs.length; i++){
            if(strs[i].equals("null")) list.add(null);
            else list.add(new TreeNode(Integer.valueOf(strs[i])));
        }
        int root = 0,fast = 1;
        while(fast < strs.length){
            if(list.get(root) != null) {list.get(root).left = list.get(fast++);list.get(root).right = list.get(fast++);}
            root++;
        }
        return list.get(0);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

///////////////////////////////////////////
public class Codec {
    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
