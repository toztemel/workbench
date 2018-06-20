package concurrent;

public class CallByValue {

    public static void main(String[] args) {
        String s = new String("abcd");
        method(s);
        System.out.println(s);
        method2(s);
        System.out.println(s);

        int x = 0;
        method(x);
        System.out.println(x);

        Bean b = new Bean();
        b.setName("first");
        method(b);
        System.out.println(b.getName());
        method2(b);
        System.out.println(b.getName());
    }

    private static void method(Bean b) {
        b.setName("second");
    }

    private static void method2(Bean b) {
        b = null;
    }

    private static class Bean {
        String name;

        void setName(String s) {
            name = s;
        }

        String getName() {
            return name;
        }
    }

    private static void method(int x) {
        x = 1;
    }

    private static void method2(String s) {
        s = null;
    }

    private static void method(String s) {
        s = new String("dcba");
    }
}
