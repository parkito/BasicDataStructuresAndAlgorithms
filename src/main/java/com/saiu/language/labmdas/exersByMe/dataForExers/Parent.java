package exersByMe.dataForExers;

import java.util.Collection;

/**
 * @author Artem Karnov @date 17.02.2017.
 *         artem.karnov@t-systems.com
 */

public class Parent extends Citizen {
    private Collection<Citizen> child;
    private ParentStatus parentStatus;

    private enum ParentStatus {
        GOOD, BAD, QUESTIONED

    }

    public Parent(long id, String name, String secondName, String thirdName, Parent mother, Parent father, int age, Sex sex, Profession profession, Collection<Work> works) {
        super(id, name, secondName, thirdName, mother, father, age, sex, profession, works);
    }

    public void addChildren(Citizen children) {
        child.add(children);
        parentStatus = ParentStatus.GOOD;
    }

    public void changeParentStatus(String status) {
        try {
            parentStatus = ParentStatus.valueOf(status);
        } catch (Exception ex) {
        }
    }
}
