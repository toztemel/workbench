package testdome;

import java.util.HashSet;

public class TreeLeaves {

	public static int getNumOfLeaves(int[] tree) {

		int length = tree.length;
		HashSet<Integer> set = new HashSet();

		for (int i = 0; i < length; i++) {
			if (tree[i] == -1) {
				set.add(new Integer(tree[i]));
			}
			Integer o = new Integer(tree[i]);
			if (set.contains(o)) {
				continue;
			} else {
				set.add(o);
			}
		}

		return length - set.size() + 1;
	}

	public static void main(String[] args) {
		System.out.println(TreeLeaves.getNumOfLeaves(new int[] { 1, 3, 1, -1, 3, 1 , 3 }));
	}
}