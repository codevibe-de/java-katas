package streams;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static streams.Account.AccountType.CHECKING;
import static streams.Account.AccountType.SAVINGS;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StreamsTest {

    private final StreamsLogic streamsLogic = new StreamsLogic();

    @Test
    @Order(1)
    public void shouldMapStringsToUpperCase() {
        List<String> input = asList("This", "is", "java", "8");
        List<String> result = streamsLogic.mapToUppercase(input);
        assertThat(result).containsExactly("THIS", "IS", "JAVA", "8");
    }

    @Test
    @Order(2)
    public void shouldRemoveElementsWithMoreThanThreeCharacters() {
        List<String> input = asList("This", "is", "java", "8");
        List<String> result = streamsLogic.removeElementsWithFourOrMoreCharacters(input);
        assertThat(result).containsExactly("is", "8");
    }

    @Test
    @Order(3)
    public void shouldSortStrings() throws Exception {
        List<String> input = Arrays.asList("C", "F", "A", "D", "B", "E");
        Stream<String> result = streamsLogic.sortStrings(input);
        assertThat(result).containsExactly("A", "B", "C", "D", "E", "F");
    }

    @Test
    @Order(4)
    public void shouldSortIntegers() throws Exception {
        List<String> input = Arrays.asList("2", "4", "12", "3");
        List<Integer> result = streamsLogic.sortIntegers(input);
        assertThat(result).containsExactly(2, 3, 4, 12);
    }

    @Test
    @Order(5)
    public void shouldSumIntegersInCollection() {
        List<Integer> input = asList(1, 2, 3, 4, 5);
        Integer result = streamsLogic.sum(input);
        assertThat(result).isEqualTo(1 + 2 + 3 + 4 + 5);
    }

    @Test
    @Order(6)
    public void shouldSortListsOfIntegersInDescendingOrder() throws Exception {
        List<String> input1 = Arrays.asList("12", "3");
        List<String> input2 = Arrays.asList("99", "2", "4");
        List<Integer> result = streamsLogic.sortListsOfIntegersInDescendingOrder(List.of(input1, input2));
        assertThat(result).containsExactly(99, 12, 4, 3, 2);
    }

    @Test
    @Order(7)
    public void shouldTransformIntoIntStream() {
        Integer[] input1 = new Integer[]{2, 3, 5, 7, 11};
        int numbersFrom = 100;
        int numbersUpTo = 102;
        IntStream intStream = streamsLogic.transformIntoIntStream(input1, numbersFrom, numbersUpTo);
        assertThat(intStream).containsExactly(2, 3, 5, 7, 11, 100, 101, 102);
    }

    @Test
    @Order(8)
    public void shouldCalculateDigitSum() {
        Integer input = 123456;
        Integer result = streamsLogic.calculateDigitSum(input);
        assertThat(result).isEqualTo(1 + 2 + 3 + 4 + 5 + 6);
    }

    // --- tests including Accounts and Persons ---

    private final Person stevePresso = new Person("Steve", "Presso", LocalDate.of(1988, 3, 2));
    private final Person carlCox = new Person("Carl", "Cox", LocalDate.of(1962, 7, 29));

    private final List<Account> accounts = List.of(
            new Account("88332200", CHECKING, 2100, stevePresso),
            new Account("88332201", CHECKING, -20, stevePresso),
            new Account("88332210", SAVINGS, 17200, stevePresso),
            new Account("77711100", CHECKING, -400, carlCox),
            new Account("77711100", CHECKING, 23400, carlCox)
    );

    @Test
    @Order(9)
    void filterAndMap() {
        var accountNumbers = streamsLogic.getCheckingAccountNumbersWithNegativeBalance(accounts);
        assertThat(accountNumbers).hasSize(2);
        assertThat(accountNumbers).containsOnly("88332201", "77711100");
    }

    @Test
    @Order(10)
    void shouldGroupByHolder() {
        Map<Person, List<Account>> accountsByHolder = streamsLogic.groupByHolder(accounts);
        assertThat(accountsByHolder).containsKeys(stevePresso, carlCox);
        assertThat(accountsByHolder.get(stevePresso)).hasSize(3);
        assertThat(accountsByHolder.get(carlCox)).hasSize(2);
    }
}
