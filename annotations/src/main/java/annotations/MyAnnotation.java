package main.java.annotations;

import java.lang.annotation.*;

/**
 * Created by tayfuno on 07/04/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Documented
@interface MyAnnotation {

    String value() default "000";
    String name();
    int age();
    String[] newNames();
}


@MyAnnotation(
        value = "123",
        name = "tayfun",
        age = 32,
        newNames = {"Tayfun", "Typhoon"}
)
class MyAnnotatedClass{

}

class MySubClass extends MyAnnotatedClass {
    public static void main(String[] args) {
        MySubClass s = new MySubClass();
    }
}