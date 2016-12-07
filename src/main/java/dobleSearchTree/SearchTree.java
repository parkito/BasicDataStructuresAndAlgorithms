package dobleSearchTree;

import exceptions.MistakenIndex;

/**
 * @author Artem Tarnov @date 08.12.16.
 *         artem.karnov@t-systems.com
 **/
public class SearchTree<T> {
    public int compareTo(T o) {
        return 0;
    }

    private List<T> root;

    public SearchTree() {
        root = null;
    }

    public void add(T element) {
    }

    public void find(T element) {
    }

    public T get(Long index) throws MistakenIndex {
        return null;
    }

    public Long indexOf(T element) {
        return null;
    }

    public void remove(T element) {
    }
}

