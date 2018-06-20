package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tayfuno on 06/04/16.
 */
public class Solution {

    public static void main(String[] args) {
        String A="welcometojava";
        int length=3;
        List list = new ArrayList();
        for(int i =0; i<A.length()-2; i++) {
            String substring = A.substring(i, i+3);
            list.add(substring);
        }
        Collections.sort(list);
        System.out.println(list.get(0));
        System.out.println(list.get(list.size()-1));
    }
}
