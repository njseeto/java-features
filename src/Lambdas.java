import org.junit.Test;

import javax.swing.text.DateFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

import static java.util.Arrays.asList;
import static java.util.Arrays.parallelPrefix;
import static org.junit.Assert.assertEquals;

public class Lambdas {

    @Test
    public void Length(){
        Function<String, Integer> lengthFunction = s -> s.length();
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
            int current = 1;
            return current;
        };

        Integer c = intSupplier.getAsInt();
        assert(c == 42);

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

    @Test
    public void DateFormatter() throws ParseException {
        ThreadLocal<DateFormatter> formatter = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("DD-MMM-YYYY")));
        System.out.println(formatter.get().valueToString(01-01-2019));
    }

    @Test
    public void Quote(){
        Function<Integer, String> addLetter = a -> a + "a";
        Function<Integer, String> intToString = Object::toString;
        Function<String, String> quote = s -> "'" + s + "'";

        Function<Integer, String> quoteIntToString = quote.compose(addLetter);
        quoteIntToString = quote.compose(intToString);
        //quoteIntToString = quote.compose(addLetter);

        String a = quoteIntToString.apply(5);

        assertEquals("'5'", a);
    }

    @Test
    public void LittleLetters(){
        Consumer<String> c = (x) -> System.out.println(x.toLowerCase());
        c.accept("HOW DO I TEST THIS?");
     }

}
