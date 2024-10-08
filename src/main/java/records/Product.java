package records;

public record Product(
        long id,
        String name,
        int priceInCents
) implements Comparable<Product> {

    @Override
    public int compareTo(Product that) {
        return Long.compare(this.id, that.id);
    }

    public Product(long id) {
        this(id, "", 0);
    }
}
