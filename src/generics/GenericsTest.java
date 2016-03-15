package test.generics;

/**
 * E element
 * K key
 * N number
 * T type
 * V value
 * S,U,V 2nd, 3rd and 4th types
 * <p/>
 * Created by tayfuno on 06/05/14.
 */
public class GenericsTest {

    public static void main(String[] args) {
        GenericBox<Integer> box = new GenericBox<Integer>();
        GenericBox<String> sBox = new GenericBox<String>();

        Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", new Integer(2));
        Pair<Integer, String> p2 = new OrderedPair<Integer, String>(new Integer(1), "one");
        Pair<Integer, String> p3 = new OrderedPair<Integer, String>(new Integer(2), "two");
//       Requires JAVA 7
//       Pair<Integer, String> pDiamond = new OrderedPair<>(new Integer(1), "one");

        OrderedPair<String, GenericBox<Integer>> pBox = new OrderedPair<String, GenericBox<Integer>>("primes", new GenericBox<Integer>());

        boolean same = compare(p3, p2);
        same = GenericsTest.<Integer, String>compare(p3, p2);

    }

    static <K, V> boolean compare (Pair<K,V> p1, Pair<K,V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p2.getValue().equals(p1.getValue());
    }

    static interface Pair<K, V> {
        K getKey();

        V getValue();
    }

    static class Box {
        private Object object;

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }

    }

    static class GenericBox<T> {
        private T t;

        public void set(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }

    }

    static class OrderedPair<K, V> implements Pair<K, V> {
        private K key;
        private V value;

        public OrderedPair (K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }
}
