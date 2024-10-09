package sort_compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortAndCompareLogic {

    public List<Song> sortInNaturalOrder(List<Song> songs) {
        var sorted = new ArrayList<>(songs);
        // any of these 3 lines will work:
        sorted.sort(null);
        sorted.sort(Comparator.naturalOrder());
        Collections.sort(sorted);
        return sorted;
    }


    public List<Song> sortByArtist(List<Song> songs) {
        var sorted = new ArrayList<>(songs);
        // any of these 2 lines will work:
        sorted.sort((s1, s2) -> s1.artist().compareTo(s2.artist()));
        sorted.sort(Comparator.comparing(Song::artist));
        return sorted;
    }


    public List<Song> sortByIsrcCountryCodeThenYear(List<Song> songs) {
        var sorted = new ArrayList<>(songs);
        sorted.sort(Comparator
                .comparing((Song s) -> s.isrc().substring(0, 2))
                .thenComparing(Song::year)
        );
        return sorted;
    }
}
