package test.generics;

/**
 * Created by tayfuno on 06/05/14.
 */
public class BoundedParameterTypesTest {

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.setT(new Integer(10));
// ERROR        integerBox.inspect("text ");
        integerBox.inspect(new Double(1.0));
    }

    static class Box<T> {
        private T t;

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        public <U extends Number> void inspect(U u) {
            System.out.println("T :" + t.getClass().getName());
            System.out.println("U :" + u.getClass().getName());
        }
    }

    static class NaturalNumber<T extends Integer> {
        private T n;

        NaturalNumber(T n) {
            this.n = n;
        }

        public T getN() {
            return n;
        }

        public boolean isEven () {
            return n.intValue() % 2 == 0;
        }

    }

    static class MultiBoundedNumber <T extends A & B & C> {

    }

    static class A {

    }

    static interface B {

    }

    static interface C {

    }
}
