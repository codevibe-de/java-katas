package lambdas;

import java.util.Set;
import java.util.function.*;

public class LambdasLogic {

    public Supplier<String> generateSupplier(String stringToSupply) {
        return () -> stringToSupply;
    }

    public Consumer<Integer> generateConsumer(Set<Integer> collectingSet) {
        return collectingSet::add; // return n -> collectingSet.add(n);
    }


    public Function<Integer, String> generatePrefixingFunction(String prefix) {
        return n -> prefix + n;
    }

    public void performTransformationPipeline(Supplier<Integer> supplier, Predicate<Integer> predicate, Consumer<Integer> consumer) {
        while (true) {
            var item = supplier.get();
            if (item == null) {
                return;
            }
            if (predicate.test(item)) {
                consumer.accept(item);
            }
        }
    }

    // returns a reference to the repeatString method below
    public BiFunction<String, Integer, String> getStringRepeaterMethodReference() {
        return this::repeatString;
    }

    private String repeatString(String s, int count) {
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < count; n++) {
            sb.append(s);
        }
        return sb.toString();
    }

}
