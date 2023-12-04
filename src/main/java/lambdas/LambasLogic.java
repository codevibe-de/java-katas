package lambdas;

import java.util.Set;
import java.util.function.*;

public class LambasLogic {

    public Supplier<String> generateSupplier(String stringToSupply) {
        return null;
    }

    public Consumer<Integer> generateConsumer(Set<Integer> collectingSet) {
        return null;
    }

    public Function<Integer, String> generatePrefixingFunction(String prefix) {
        return null;
    }

    public void performTransformationPipeline(Supplier<Integer> supplier, Predicate<Integer> predicate, Consumer<Integer> consumer) {
    }

    public BiFunction<String, Integer, String> getStringRepeaterMethodReference() {
        return null;
    }

    private String repeatString(String s, int count) {
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < count; n++) {
            sb.append(s);
        }
        return sb.toString();
    }

}
