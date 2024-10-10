package records;

import java.util.Comparator;

public record Product(
        long id,
        String name,
        int priceInCents
) implements Comparable<Product> {

    public Product {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be null or blank");
        }
        if (priceInCents < 0) {
            throw new IllegalArgumentException("Price must not be less than 0");
        }
    }

    public Product(long id) {
        this(id, "", 0);
    }


    @Override
    public int compareTo(Product that) {
        return Comparator.comparingInt(Product::priceInCents)
                .thenComparing(Product::name)
                .compare(this, that);
    }

}
