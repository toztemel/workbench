package test.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tayfuno on 06/05/14.
 */
public class WildcardsTest {


    public static void main(String[] args) {
        List<Integer> l1;
        List<Double> l2;
        List<Number> l3;
        List<? extends Number> l4;

        List<Integer> li = Arrays.asList(1, 2, 3);
        List<String>  ls = Arrays.asList("one", "two", "three");

        printWildcardList(li);
        printWildcardList(ls);

        List<Integer> intList0 = new ArrayList<Integer>();
//        List<Number>  numList0 = intList0;  // ERROR. List<Integer> is NOT a subtype of List<Number>
        List<? extends Integer> intList = new ArrayList<Integer>();
        List<? extends Number>  numList = intList;  // OK. List<? extends Integer> is a subtype of List<? extends Number>

    }

    public static void process(List<? extends Number> list) {
        for (Number elem : list) {
            // ...
        }
    }

    public static void printList(List<Object> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    public static void printWildcardList(List<?> list) {
        for (Object elem : list)
            System.out.print(elem + " ");
        System.out.println();
    }

    public static void addNumbers (List <? super Integer> list) {
        for (int i = 1; i <=10; i++) {
            list.add(i);
        }
    }

}
