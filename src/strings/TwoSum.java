package strings;

/**
 * Created by tayfuno on 06/04/16.
 */
public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
        for(int i = 0; i < list.length; i++) {
            for (int j = i+1; j<list.length; j++) {
                if (list[i]+list[j]==sum) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12);
        System.out.println(indices[0] + " " + indices[1]);
    }
}