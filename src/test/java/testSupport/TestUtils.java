package testSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Karnov @date 22.02.2017.
 *         artem.karnov@t-systems.com
 */
public class TestUtils {
    public static List<String> getStringsOfNumbers(int from, int to) {
        List<String> strings = new ArrayList<String>();
        for (int i = from; i < to; i++) {
            strings.add(String.valueOf(i));
        }
        return strings;
    }
}
