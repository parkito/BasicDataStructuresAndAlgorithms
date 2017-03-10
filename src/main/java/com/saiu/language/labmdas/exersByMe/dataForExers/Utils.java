package exersByMe.dataForExers;

/**
 * @author Artem Karnov @date 17.02.2017.
 *         artem.karnov@t-systems.com
 */

public class Utils {
    public static Parent makeParent(Citizen person) {
        Parent result = (Parent) person;
        result.changeParentStatus("GOOD");
        return result;
    }

}
