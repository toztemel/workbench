package ctci.arrays;

import java.util.LinkedList;

class StringCompressor {


    String compress(char[] str) {
        CompressedString output = new CompressedString();

        char c = str[0];
        int cCount = 1;

        for (int i = 1; i < str.length; i++) {
            if (str[i] == c) {
                cCount++;
            } else {
                output.insertFragment(c, cCount);
                c = str[i];
                cCount = 1;
            }
        }

        output.insertFragment(c, cCount);

        return output.isCompressed(str.length) ? output.generateString() : new String(str);
    }

    private static class CompressedString extends LinkedList<String> {

        private int size = 0;

        private void insertFragment(char c, int cCount) {
            String s = Character.toString(c) + cCount;
            addLast(s);
            size += (1 + String.valueOf(cCount).length());
        }


        private String generateString() {
            StringBuilder sb = new StringBuilder();
            while (!isEmpty()) {
                sb.append(removeFirst());
            }
            return sb.toString();
        }

        private boolean isCompressed(int originalSize) {
            return size < originalSize;
        }
    }

}
