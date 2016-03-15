package annotations;

import java.lang.reflect.Method;

/**
 * Created by tayfuno on 14/01/16.
 */
public class TestAnnotationParser {

    public void parse(Class<?> clazz) throws Exception {
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test test = method.getAnnotation(Test.class);
                String info = test.info();
                if ("AWESOME".equals(info)) {
                    System.out.println("info is awesome");
                    method.invoke(Annotated.class.newInstance(), info);
                }
            }

        }
    }
}
