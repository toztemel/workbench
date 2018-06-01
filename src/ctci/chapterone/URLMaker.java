package ctci.chapterone;

class URLMaker {

    String replaceAllAndMakeUrl(String str, int length) {
        str = str.trim();
        return str.replaceAll(" ", "%20");
    }

    void loopAndMakeURL(char[] str, int length) {
        int insertIndex = str.length - 1;
        boolean replace = false;
        int charCounter = 0;
        for (int i = str.length - 1; i >= 0; i--) {
            char c = str[i];
            if (c == ' ') {
                if (replace) {
                    str[insertIndex--] = '0';
                    str[insertIndex--] = '2';
                    str[insertIndex--] = '%';
                } else {
                    continue;
                }
            } else {
                str[insertIndex--] = c;
                replace = true;
                charCounter++;
                if (charCounter == length) {
                    break;
                }
            }
        }
    }

}
