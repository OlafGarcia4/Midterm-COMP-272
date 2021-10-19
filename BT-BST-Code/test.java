import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test {
    private BinaryTree <String> test1;
    @Before
    public void setUp(){
        test1= new BinaryTree<>("1");
    }
    @After
    public void teardown(){
        test1 = null;
    }
    @Test
    public void size(){
        Node<String> n1 =test1.addLeft(test1.root,"2");
        Node<String> n2 = test1.addRight(test1.root,"3");
        test1.addLeft(n1,"4");
        test1.addLeft(n2,"y");
        test1.addRight(n2,"z");
        test1.height(test1.root);
        assertEquals(2,test1.height(test1.root));
    }
    @Test
    public void leaf(){
        Node<String> n1 =test1.addLeft(test1.root,"2");
        Node<String> n2 = test1.addRight(test1.root,"3");
        test1.addLeft(n1,"4");

        assertEquals(false,test1.isLeaf(n1));
        assertEquals(true,test1.isLeaf(n2));
    }
    @Test
    public void level(){
        Node<String> n1 =test1.addLeft(test1.root,"2");
        Node<String> n2 = test1.addRight(test1.root,"3");
        test1.addLeft(n1,"4");
        test1.addLeft(n2,"y");
        test1.addRight(n2,"z");

       assertEquals(2,test1.nodeLevel(n2.right));

    }
}
