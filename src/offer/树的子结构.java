package offer;

public class 树的子结构 {
    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1==null||root2==null)
            return false;      //下面判断和这边判断的目的想一哈！
        return sub(root1,root2)||sub(root1.left,root2)||sub(root1.right,root2);
    }

    public boolean sub(TreeNode r1, TreeNode r2) {
        if (r2 == null)
            return true;
        if (r1 == null)
            return false;   //此时，r2已经不为null了
        if (r1.val != r2.val)
            return false;
        return sub(r1.left, r2.left) && sub(r1.right, r2.right);
    }
}
