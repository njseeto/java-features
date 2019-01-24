import org.junit.Test;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Predicate;

public class Lambdas {

    @Test
    public void Length(){
        Function<String, Integer> lengthFunction = (String s) -> s.length();
        String a = "hello";
        Integer b = lengthFunction.apply(a);

        assert(b == 5);
    }

    @Test
    public void TheMeaningOfLife(){
        IntSupplier intSupplier = () -> 42;
        Integer c = intSupplier.getAsInt();

        assert(c == 42);
    }

    @Test
    public void number(){
        IntSupplier intSupplier = () -> {
            int previous = 0;
            int current = 1;

            int nextValue = previous + current;
            previous = current;
            current = nextValue;
            return previous;

        };

        Integer c = intSupplier.getAsInt();
        assert(c == 1);

        c = intSupplier.getAsInt();
        assert(c == 1);
    }

    @Test
    public void Add(){
        BinaryOperator<Long> add = (x, y) -> x + y;
         Long x = Long.valueOf(2);
         Long y = Long.valueOf(3);
         Long a = add.apply(x, y);

         assert(a == 5);
    }

    @Test
    public void GreaterThanFive(){
        Predicate<Integer> atLeast5 = x -> x > 5;
        boolean a = atLeast5.test(6);
        boolean b = atLeast5.test(1);

        assert(a == true);
        assert(b == false);
    }
}
