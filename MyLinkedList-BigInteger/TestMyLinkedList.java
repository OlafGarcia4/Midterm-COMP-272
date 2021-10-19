
import static org.junit.Assert.*;

import jdk.swing.interop.SwingInterOpUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMyLinkedList {
    private MyLinkedList<Integer> test1;
    @Before
    public void setUp(){
        test1= new MyLinkedList<>();
    }

    @After
    public void teardown(){
        test1=null;
    }

    @Test
    public void makeUnq(){

        test1.addFirst(3);
        test1.addFirst(1);
        test1.addFirst(4);
        test1.addFirst(5);
        test1.addFirst(3);
        test1.addFirst(2);
        test1.addFirst(4);
        test1.addFirst(7);

        test1.uniqueList();


    }
    @Test
    public void cmmnVals(){
        test1.addFirst(3);
        test1.addFirst(1);
        test1.addFirst(4);
        test1.addFirst(3);
        test1.addFirst(3);
        test1.addFirst(2);
        test1.addFirst(4);
        test1.addFirst(7);

        MyLinkedList<Integer> test2 = new MyLinkedList<>();
        test2.addFirst(3);
        test2.addFirst(1);
        test2.addFirst(4);
        test2.addFirst(5);
        test2.addFirst(3);
        test2.addFirst(2);
        test2.addFirst(4);
        test2.addFirst(7);

        System.out.println();
        test1.commonValues(test2);
}
    @Test
    public void unite(){
        MyLinkedList <Integer> test3 = new MyLinkedList<>();
        test3.addFirst(3);
        test3.addFirst(1);
        test3.addFirst(4);
        test3.addFirst(5);
        test3.addFirst(3);
        test3.addFirst(2);
        test3.addFirst(4);
        test3.addFirst(7);

        test1.addFirst(3);
        test1.addFirst(1);
        test1.addFirst(4);
        test1.addFirst(3);
        test1.addFirst(3);
        test1.addFirst(2);
        test1.addFirst(4);
        test1.addFirst(7);

        test1.union(test3).printListForward();

    }



}
