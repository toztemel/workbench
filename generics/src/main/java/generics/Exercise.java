package test.generics;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by tayfuno on 06/05/14.
 */
public class Exercise {

    public static void main(String[] args) {
        Exercise e = new Exercise();
        e.run();
        e.runExchange();

    }

    private void runExchange() {
        String[] array = {"one", "two", "three"};
        swap(array, 1, 2);
        assert (array[0].equals("one"));
        assert (array[1].equals("three"));
        assert (array[2].equals("two"));
        System.out.println("1 " + array[0]);
        System.out.println("2 " + array[1]);
        System.out.println("3 " + array[2]);

        Integer[] array2 = {1, 2, 3};
        swap(array2, 1, 2);
        assert (array2[0] == 1);
        assert (array2[1] == 3);
        assert (array2[2] == 5);
        System.out.println("1 " + array2[0]);
        System.out.println("2 " + array2[1]);
        System.out.println("3 " + array2[2]);

        System.out.println("Replaced array elements");
    }

    private <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void run() {
        Collection<Integer> col = Arrays.asList(1, 2, 3, 4);
        System.out.println(countOddIntegers(col, new OddPredicate()));
    }

    private <T> int countOddIntegers(Collection<T> c, UnaryPredicate<T> pre) {
        int count = 0;
        for (T element : c) {
            if (pre.test(element)) {
                count++;
            }
        }
        return count;
    }

    interface UnaryPredicate<T> {
        public boolean test(T t);
    }

    class OddPredicate implements UnaryPredicate<Integer> {

        @Override
        public boolean test(Integer integer) {
            return integer % 2 != 0;
        }
    }
}
