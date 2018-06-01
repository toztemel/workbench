package hierarchy;

import annotations.Preference;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class HumanTest {

    @Test
    public void test() {

        Thing boy = new Woman() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };
        Class[] classes = boy.getClass().getInterfaces();
        Optional<Class> first = Arrays.stream(classes).filter(c -> c.isAnnotationPresent(Preference.class)).findFirst();

        if (first.isPresent()) {
            assertEquals("Slim", ((Preference) first.get().getAnnotation(Preference.class)).value());
        } else {
            fail("Preference does not exist");
        }
    }
}