package sort_compare;

public record Song(
        String isrc,
        String title,
        String artist,
        int year
) implements Comparable<Song> {

    @Override
    public int compareTo(Song other) {
        return this.title.compareTo(other.title);
    }

}
