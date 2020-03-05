import org.junit.Test;

public class DiamondOperatorImprovements {


    /**************************************************
     * Ready
     **************************************************/
    interface MyClass<T> {
        int process();
    }



    /**************************************************
     * Test
     **************************************************/
    @Test
    public void testAnonymousClasses(){
        // You can omit the generic type declaration of anonymous classes.
        MyClass<Integer> some = new MyClass<>(){
            @Override
            public int process() {
                return 0;
            }
        };
        assert some.process() == 0;
    }

}
