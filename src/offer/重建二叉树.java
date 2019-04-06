package offer;

import java.util.HashMap;
import java.util.Map;

public class 重建二叉树 {
    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     * @param pre
     * @param in
     * @return
     */
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for(int i=0;i<in.length;i++){
            map.put(in[i],i);
        }
        return create(pre,0,pre.length-1,0);
    }

    public TreeNode create(int[] pre,int left,int right,int len){
        if(right<left)   //只有一个元素的是可以添加的；
            return null;
        TreeNode treeNode=new TreeNode(pre[left]);
        int index=map.get(pre[left]);
        int leftTreeSize=index-len;
        treeNode.left=create(pre,left+1,left+leftTreeSize,0);
        treeNode.right=create(pre,left+1+leftTreeSize,right,leftTreeSize+1);
        return treeNode;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}