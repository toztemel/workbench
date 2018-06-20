package main.java.annotations;

/**
 * Created by tayfuno on 14/01/16.
 */
public class Demo {

    public static void main(String[] args) throws Exception {
        TestAnnotationParser parser = new TestAnnotationParser();
        parser.parse(Annotated.class);
    }
}
