
public class BinaryTreeVerification <E extends Comparable<E>> extends BinaryTree<E> {


public boolean isBST(){
    Node node = root;
    if (root == null)
        return true;

    if (root.left != null && root.left.getInfo().compareTo(root.getInfo()) > 0) {
        return false;
    }
    if (root.right != null && root.right.getInfo().compareTo(root.getInfo()) > 0) {
        return false;
    }
    return true;
}

public boolean isFull(Node root) {
    Node node=root;
    if(node == null)
            return true;
    if(node.left == null && node.right == null )
        return true;
    if((node.left!=null) && (node.right!=null))
        return (isFull(node.left) && isFull(node.right));

    return false;

}




}