package ctci.arrays;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

class MatrixHandler {

    void rotateMatrixInPlace(int[][] image) {
        if (image.length == 0 || image.length != image[0].length) {
            return;
        }
        for (int i = 0; i < image.length/2; i++) {
            for (int j = i; j < image.length-1-i; j++) {
                int piece1 = image[i][j];
                int piece2 = image[j][image.length - 1 - i];
                int piece3 = image[image.length - 1 - i][image.length - 1 - j];
                int piece4 = image[image.length - 1 - j][i];

                image[j][image.length - 1 - i] = piece1;
                image[image.length - 1 - i][image.length - 1 - j] = piece2;
                image[image.length - 1 - j][i] = piece3;
                image[i][j] = piece4;
            }
        }
    }

    void zeroifyMatrix(int[][] input) {
        List<Pair<Integer, Integer>> zeroCells = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 0) {
                    zeroCells.add(new Pair<>(i, j));
                }
            }
        }

        for (Pair<Integer, Integer> p : zeroCells) {
            int i = p.getKey();
            int j = p.getValue();

            for (int k = 0; k < input[0].length; k++) {
                input[i][k] = 0;
            }
            for (int k = 0; k < input.length; k++) {
                input[k][j] = 0;
            }
        }
    }

}
