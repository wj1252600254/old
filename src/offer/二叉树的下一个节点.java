package offer;

public class 二叉树的下一个节点 {
    /**
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     *
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null)
            return null;
        if (pNode.right != null) {
            TreeLinkNode right = pNode.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        } else {
            /*
            代码可以精简
             */
            if (pNode.next != null) {
                TreeLinkNode parent=pNode.next;
                if(parent.left==pNode)
                    return parent;
                else {
                    while (parent.next!=null){
                        pNode=parent;
                        parent=parent.next;
                        if(parent.left==pNode){
                            return parent;
                        }
                    }
                }
            }
            return null;
        }


    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}