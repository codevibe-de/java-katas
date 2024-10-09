package sort_compare;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SortAndCompareLogicTest {

    List<Song> songs = List.of(
            new Song("USAT29902209", "Don't Stop Believin'", "Journey", 1981),
            new Song("USWB19901507", "Bohemian Rhapsody", "Queen", 1975),
            new Song("GBUM71029604", "Hotel California", "Eagles", 1976),
            new Song("USWB10300858", "Sweet Child o' Mine", "Guns N' Roses", 1987),
            new Song("USWB10002576", "Stairway to Heaven", "Led Zeppelin", 1971)
    );

    private final SortAndCompareLogic sortAndCompareLogic = new SortAndCompareLogic();

    @Test
    void sortInNaturalOrder() {
        List<Song> sorted = sortAndCompareLogic.sortInNaturalOrder(songs);
        assertThat(sorted).isNotNull();
        assertThat(sorted).hasSize(5);
        assertThat(sorted.get(0).title()).isEqualTo("Bohemian Rhapsody");
        assertThat(sorted.get(1).title()).isEqualTo("Don't Stop Believin'");
        assertThat(sorted.get(2).title()).isEqualTo("Hotel California");
        assertThat(sorted.get(3).title()).isEqualTo("Stairway to Heaven");
        assertThat(sorted.get(4).title()).isEqualTo("Sweet Child o' Mine");
    }


    @Test
    void sortByTitle() {
        List<Song> sorted = sortAndCompareLogic.sortByArtist(songs);
        assertThat(sorted).isNotNull();
        assertThat(sorted).hasSize(5);
        assertThat(sorted.get(0).artist()).isEqualTo("Eagles");
        assertThat(sorted.get(1).artist()).isEqualTo("Guns N' Roses");
        assertThat(sorted.get(2).artist()).isEqualTo("Journey");
        assertThat(sorted.get(3).artist()).isEqualTo("Led Zeppelin");
        assertThat(sorted.get(4).artist()).isEqualTo("Queen");
    }


    @Test
    void sortByIsrcCountryCodeThenYear() {
        List<Song> sorted = sortAndCompareLogic.sortByIsrcCountryCodeThenYear(songs);
        assertThat(sorted).isNotNull();
        assertThat(sorted).hasSize(5);
        assertThat(sorted.get(0).isrc()).isEqualTo("GBUM71029604");
        assertThat(sorted.get(1).isrc()).isEqualTo("USWB10002576");
        assertThat(sorted.get(2).isrc()).isEqualTo("USWB19901507");
        assertThat(sorted.get(3).isrc()).isEqualTo("USAT29902209");
        assertThat(sorted.get(4).isrc()).isEqualTo("USWB10300858");
    }

}