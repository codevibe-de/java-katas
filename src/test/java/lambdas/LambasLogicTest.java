package lambdas;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.*;

import static org.assertj.core.api.Assertions.assertThat;

class LambasLogicTest {

    private final LambasLogic lambasLogic = new LambasLogic();

    @Test
    void shouldGenerateSupplier() {
        Supplier<String> result = lambasLogic.generateSupplier("hello");
        assertThat(result).isNotNull();
        String output = result.get();
        assertThat(output).isEqualTo("hello");
    }

    @Test
    void shouldGenerateConsumer() {
        Set<Integer> collectingSet = new HashSet<>();
        Consumer<Integer> result = lambasLogic.generateConsumer(collectingSet);
        assertThat(result).isNotNull();
        result.accept(42);
        assertThat(collectingSet).containsOnly(42);
    }

    @Test
    void shouldGeneratePrefixingFunction() {
        Function<Integer, String> result = lambasLogic.generatePrefixingFunction("ABC-");
        assertThat(result).isNotNull();
        String output = result.apply(123);
        assertThat(output).isEqualTo("ABC-123");
    }

    @Test
    void shouldPerformTransformationPipeline() {
        // given
        ArrayDeque<Integer> numbers = new ArrayDeque<>(List.of(1, 2, 3, 4, 5));
        List<Integer> collectingList = new ArrayList<>();
        Supplier<Integer> supplier = () -> numbers.isEmpty() ? null : numbers.pop();
        Predicate<Integer> predicate = (n) -> n % 2 == 0;
        Consumer<Integer> consumer = (n) -> collectingList.add(n);
        // when
        lambasLogic.performTransformationPipeline(supplier, predicate, consumer);
        // then
        assertThat(collectingList).containsExactly(2, 4);
    }

    @Test
    void shouldUseMethodReference() {
        BiFunction<String, Integer, String> result = lambasLogic.getStringRepeaterMethodReference(); // todo
        assertThat(result).isNotNull();
        var output = result.apply("-", 5);
        assertThat(output).isEqualTo("-----");
    }

}