package annotations;

/**
 * Created by tayfuno on 14/01/16.
 */
public class Annotated {

    @Test(info = "AWESOME")
    public void testThis(String parameter) {
        System.out.println("This is " + parameter);

    }
}
