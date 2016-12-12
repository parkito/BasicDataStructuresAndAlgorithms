package dobleSearchTree;

/**
 * @author Artem Tarnov @date 08.12.16.
 *         artem.karnov@t-systems.com
 **/
public class List<T> {
    private long key;
    private T data;
    private List<T> leftChildren;
    private List<T> rightChildren;

    public void showList() {
        System.out.println("{ " + key + ") " + data + " }");
    }

}
