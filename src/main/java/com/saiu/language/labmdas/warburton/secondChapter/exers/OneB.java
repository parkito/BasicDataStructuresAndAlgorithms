package com.saiu.language.labmdas.warburton.secondChapter.exers;


import com.saiu.language.labmdas.warburton.dataForChaptersExers.SampleData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Artyom Karnov on 27.11.16.
 * artyom-karnov@yandex.ru
 **/
public class OneB {
    public static void main(String[] args) {
        OneB oneB = new OneB();
        System.out.println(oneB.getArtistInfo("John Coltrane"));
    }

    public List<String> getArtistInfo(String name) {
        List<String> result = new ArrayList<>();
        result = SampleData.threeArtists().filter(artist -> artist.getName().equals(name))
                .map(artist -> "Members: {" + artist.getMembers().collect(Collectors.toList()) + "} Nation" + artist.getNationality())
                .collect(Collectors.toList());
        return result;
    }


}
