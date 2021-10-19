import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BinaryTree<E> {

    int size;
    Node<E> root;
    
    public BinaryTree () {
     size =0;
     root=null;
    }
    
    
    public BinaryTree(E val) {
        root = new Node(val);
        // root node only
        size=1;
        
    }
    public boolean isEmpty() {
        return size==0;
    }
    
    
    public Node<E> addLeft(Node<E> node, E val) {
        Node<E> n = new Node(val);
        node.addLeft(n);
        size++;
        return n;
    }
    
    public Node<E> addRight(Node<E> node, E val) {
        
       Node<E> n = new Node(val);
        node.addRight(n);
        size++;
        return n ;
    } 
    
    public void preOrder(Node<E> n) {
        
        if (n==null) return;
        System.out.println(n.getInfo());
        preOrder(n.getLeft());
        preOrder(n.getRight());
        
    }
    
    public void inOrder(Node<E> n) {
        
        if (n==null) return;
        inOrder(n.getLeft());
        System.out.println(n.getInfo());
        inOrder(n.getRight());
        
    }
    
    public void postOrder(Node<E> n) {
        
        if (n==null) return;
        
        postOrder(n.getLeft());
        postOrder(n.getRight());
        System.out.println(n.getInfo());
        
    }
	//Calculates and returns the height of this BinaryTree. Height of a tree with only root node
    //is 0.
	public int height(Node root){
        {
            if (root == null) {
                return 0;
            }

            Queue<Node> q = new LinkedList();
            q.add(root);
            int height = -1;

            while (1 == 1) {
                int nCount = q.size();
                if (nCount == 0)
                    return height;
                height++;

                while (nCount > 0) {
                    Node nwnode = q.peek();
                    q.remove();
                    if (nwnode.left != null)
                        q.add(nwnode.left);
                    if (nwnode.right != null)
                        q.add(nwnode.right);
                    nCount--;
                }
            }
        }

           /** int hgL = height(root.left);
            int hgR = height(root.right);

            if (hgL > hgR) {
                return (hgL + 1);
            }
            else {
                return (hgR + 1);
            }
*/

	}
	//Returns true if node v is a leaf and false if it is not a leaf. If v is null throw exception
	public boolean isLeaf(Node<E> v){
        if(v == null){
            try {
                throw new Exception("Node is null...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(v.left == null && v.right==null){
            return true;
        }
        return false;
		
	}
	//Calculates and returns the level number of a specific node in the BinaryTree. The level
    //number of root is 0. The level number of each child of the root is 1 and so on. If v is null
    //throw exception.
	public int nodeLevel (Node<E> v) {
        int level = 0;
        Node n = v;
        while (n != null && n.parent != null) {
            level++;
            n = n.parent;
        }
        return level;


		
	}
	//Prints each node info (label) in a breadth-first traversal of the binary Tree starting from
    //the root, for a non-empty tree. If empty, throw an exception.
	public void breadthFirstTraversal(Node<E> root) {

        Queue<Node> bft = new LinkedList<Node>();
        if (root == null)
            return;
        bft.add(root);
        while (!bft.isEmpty()) {
            Node n = (Node) bft.remove();
            System.out.print(" " + n.getInfo());
            if (n.left != null)
                bft.add(n.left);
            if (n.right != null)
                bft.add(n.right);
        }
        

	}
	//Calculates and returns the height of a node in the binary tree. The height of a leaf node
    //is 0. The height of any node p in the binary tree is the number of edges from the node to
    //the farthest leaf node in the subtree rooted at p. Example: In the tree below, height of
    //node 5 is 2. Height of the root is 3. Height of node 2 is 1. Height of node 7 is 0
	public int nodeHeight(Node<E> v){
        int hgt = height(root);
        int lvl =nodeLevel(v);


        return hgt-lvl;

	}
	//Calculates and returns the average Level of the binary tree. This is the sum of the level
    //number of every node of the tree divided by the number of nodes. For the binary tree
    //above, the averageLevel= (0+1+1+2+2+2+3)/7 = 11/7=1.57
	//public double averageLevel(){
		
	//}
    public static void main(String[] args){
        
       // BinaryTree<String> bt = new BinaryTree<>("cat");
      // bt.addLeft(bt.root,"dog");
       // bt.addRight(bt.root,"mouse");
       BinaryTree<String> bt = new BinaryTree<>("-");
       Node<String> n1 =bt.addLeft(bt.root,"*");
       Node<String> n2 = bt.addRight(bt.root,"/");
       bt.addLeft(n1,"x");
       bt.addRight(n1,"y");
       bt.addLeft(n2,"y");
       bt.addRight(n2,"z");
       bt.postOrder(bt.root);

        System.out.println(bt.height(bt.root));
        System.out.println(
        );

        bt.breadthFirstTraversal(bt.root);
        System.out.println();
        System.out.println();
        System.out.println(bt.nodeHeight(n1));



    }
    
}
