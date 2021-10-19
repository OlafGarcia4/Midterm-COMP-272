import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMyBigInterger {
    MyBigInteger test1;
    @Before
    public void setUp(){
        test1 = new MyBigInteger("2000");
    }
    @After
    public void teardown(){
        test1 = null;
    }

    @Test
    public void product(){
        MyBigInteger test2 = new MyBigInteger("4");
        System.out.println(test1.multiply(test2));

    }


    @Test
    public void oddOrEven(){
        System.out.println(test1.even());
    }

}
