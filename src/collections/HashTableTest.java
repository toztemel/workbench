package collections;

import org.junit.Test;

import java.util.Hashtable;
import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.assertThat;

/**
 * Created by tayfuno on 04/04/16.
 */
public class HashTableTest {

    @Test
    public void testTableOpen() {
        Hashtable<String, Integer> table = new Hashtable();

        System.out.println("one:" + "one".hashCode());
        System.out.println("another one:" + "one".hashCode());
        System.out.println("String one:" + new String("one").hashCode());

        table.put("one", 1);
        table.put("two", 2);
        table.put("two", 3);

        assertThat(table.size(), is(2));
    }


    @Test
    public void testHashCollision() {
        Hashtable<MyKey, Integer> table = new Hashtable();

        MyKey k1 =new MyKey("one");
        MyKey k2 = new MyKey("two");

        table.put(k1,1);
        table.put(k2,2);

        assertThat(table.size(), is(1));
        assertThat(table.get(k1), is(1));
    }

    class MyKey {

        String s;

        MyKey(String value) {
            s = value;
        }

        @Override
        public boolean equals(Object obj) {
            return s.equals(((MyKey)obj).s);
        }

        @Override
        public int hashCode() {
            return 123456;
        }
    }
}
