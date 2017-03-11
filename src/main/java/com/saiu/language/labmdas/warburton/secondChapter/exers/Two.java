package com.saiu.language.labmdas.warburton.secondChapter.exers;


import com.saiu.language.labmdas.warburton.dataForChaptersExers.Artist;
import com.saiu.language.labmdas.warburton.dataForChaptersExers.SampleData;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Artyom Karnov on 28.11.16.
 * artyom-karnov@yandex.ru
 **/
public class Two {
    public static void main(String[] args) {
        int totalMembers = 0;
        for (Artist artist : SampleData.getThreeArtists()) {
            Stream<Artist> members = artist.getMembers();
            totalMembers += members.count();
        }
        System.out.println(totalMembers);
        Two two = new Two();
        System.out.println(two.internalInterator(SampleData.getThreeArtists()));
    }

    public int internalInterator(List<Artist> artists) {
        int result = 0;
        result = (int) artists.stream().flatMap(artist -> artist.getMembers()).count();
        return result;
    }
}
