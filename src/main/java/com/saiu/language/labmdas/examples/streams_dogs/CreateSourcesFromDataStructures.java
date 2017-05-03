package com.saiu.language.labmdas.examples.streams_dogs;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Artem Karnov @date 03.05.2017.
 *         artem.karnov@t-systems.com
 */

public class CreateSourcesFromDataStructures {
    //Get all children of node parent as stream
    public static Stream<Node> children(Node parent) {
        NodeList nodeList = parent.getChildNodes();
        return IntStream
                .range(0, nodeList.getLength())
                .mapToObj(nodeList::item);
    }

    //Create source with index
    public static <T> Stream<IndexExampleClass<T>> withIndex(List<T> list) {
        return IntStream
                .range(0, list.size())
                .mapToObj(idx -> new IndexExampleClass<>(idx, list.get(idx)));
    }
}
