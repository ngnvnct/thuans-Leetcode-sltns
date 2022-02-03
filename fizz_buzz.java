import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class fizz_buzz {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else if (i % 15 == 0) {
                res.add("FizzBuzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }

    @Test
    public void testFizzBuzz() {
        int n = 5;
        List<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("1");
        expectedOutput.add("2");
        expectedOutput.add("Fizz");
        expectedOutput.add("4");
        expectedOutput.add("Buzz");
        assertEquals(expectedOutput, fizzBuzz(n));
    }
}
