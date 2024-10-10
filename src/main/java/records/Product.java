package records;

import java.util.Comparator;

public record Product(
        long id,
        String name,
        int priceInCents
) implements Comparable<Product> {

    @Override
    public int compareTo(Product that) {
        return Comparator.comparingInt(Product::priceInCents)
                .thenComparing(Comparator.comparing(Product::name))
                .compare(this, that);
    }

    public Product(long id) {
        this(id, "", 0);
    }
}
