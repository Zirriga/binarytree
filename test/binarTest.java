import org.junit.Test;

import static org.junit.Assert.*;

public class binarTest {
    //@Test
    //public void containsKey(){

        //assertEquals();
    //}

   // @Test
    //public void get() { }

    @Test
    public void add() {
        binar a = new binar();
        a.add(1,1);
        assertEquals(1, a.get(1));
    }

    @Test
    public void remove() {
        binar a = new binar();
        a.add(1,1);
        a.add(2,2);
        a.remove(2);
        assertEquals(false, a.containsKey(2));
    }

}