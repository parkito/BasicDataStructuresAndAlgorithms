package dobleSearchTree;

import exceptions.MistakenIndex;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Tarnov @date 08.12.16.
 *         artem.karnov@t-systems.com
 **/
public class SearchTree<T> {
    private TreeList<T> root;
    private static long generationNumber;

    public int compareTo(T o) {
        return 0;
    }

    private List<T> root;

    public SearchTree() {
        root = null;
    }

    // TODO: 12.12.2016   I hate my code
    // TODO: 12.12.2016 Although i wrote more effective code than Lafore (without addidion Note variable)
    public void add(long key, T element) {
        if (root == null) {
            root = new TreeList<T>(key, element);
        } else {
            TreeList currentList = root;
            while (true) {
                //choosing the branch of the tree (new key > current key -> we go to right branch )
                if (key >= currentList.getKey()) {
                    if (currentList.getRightChildren() == null) {
                        //we come to end of the right branch
                        //we add element and finish this operation
                        currentList.setRightChildren(new TreeList(key, element));
                        return;
                    }
                    //it isn't end of the branch, so move on
                    currentList = currentList.getRightChildren();

                } else {
                    if (currentList.getLeftChildren() == null) {
                        //we come to end of the left branch
                        //we add element and finish this operation
                        currentList.setLeftChildren(new TreeList(key, element));
                        return;
                    }
                    //it isn't end of the branch, so move on
                    currentList = currentList.getLeftChildren();

                }
            }

        }

    }

    public T find(long key) {
        TreeList currentList = root;
        while (currentList != null) {
            if (key == currentList.getKey())
                return (T) currentList.getData();
            else if (key > currentList.getKey()) {
                currentList = currentList.getRightChildren();
            } else {
                currentList = currentList.getLeftChildren();
            }
        }
        return null;
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

    public void showTree() {
        generationNumber = 0;
        List<TreeList> rootOfTheTree = new ArrayList<TreeList>();
        rootOfTheTree.add(root);
        System.out.println("Root " + rootOfTheTree);
        System.out.println("----------------------------------------------");
        getChildrenLevel(rootOfTheTree);
    }

    // TODO: 12.12.2016 to remove last  empty level
    public List<TreeList> getChildrenLevel(List<TreeList> parentLevel) {
        List<TreeList> childrenLevel = new ArrayList<TreeList>();
        for (TreeList currentList : parentLevel) {
            if (currentList.getLeftChildren() != null) {
                childrenLevel.add(currentList.getLeftChildren());
            }
            if (currentList.getRightChildren() != null) {
                childrenLevel.add(currentList.getRightChildren());
            }
        }
        System.out.println("Gen " + ++generationNumber + "  " + childrenLevel);
        System.out.println("----------------------------------------------");
        if (childrenLevel.size() > 0)
            return getChildrenLevel(childrenLevel);
        else return null;
    }

    public void showListInfo(TreeList list) {
        System.out.println(list);
        System.out.println("Children " + list.getLeftChildren() + "   " + list.getRightChildren());
    }
}

