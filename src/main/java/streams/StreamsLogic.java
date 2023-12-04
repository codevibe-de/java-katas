package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsLogic {

    public List<String> mapToUppercase(List<String> input) {
        return input.stream()
                .map(String::toUpperCase)
                .toList();
    }

    public List<String> removeElementsWithFourOrMoreCharacters(List<String> input) {
        return input.stream()
                .filter(s -> s.length() < 4)
                .toList();
    }

    public Stream<String> sortStrings(List<String> input) {
        return input.stream().sorted();
    }

    public List<Integer> sortIntegers(List<String> input) {
        return input.stream()
                .map(Integer::parseInt)
                .sorted()
                .toList();
    }

    public Integer sum(List<Integer> input) {
        return input.stream()
                .mapToInt(n -> n)
                .sum();
    }

    public List<Integer> sortListsOfIntegersInDescendingOrder(List<List<String>> listOfLists) {
        return listOfLists.stream()
                .flatMap(Collection::stream)
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    public IntStream transformIntoIntStream(Integer[] input1, int numbersFrom, int numbersUpTo) {
        return Stream.concat(
                Arrays.stream(input1),
                IntStream.rangeClosed(numbersFrom, numbersUpTo).boxed()
        ).mapToInt(n -> n);
    }

    // digit sum == Quersumme
    public Integer calculateDigitSum(Integer input) {
        return input.toString()
                .chars()
                .map(ch -> Character.digit(ch, 10))
                .reduce(0, Integer::sum);
    }

    public Set<String> getCheckingAccountWithNegativeBalance(List<Account> accounts) {
        return accounts.stream()
                .filter(a -> a.type() == Account.AccountType.CHECKING)
                .filter(a -> a.balance() < 0)
                .map(Account::number)
                .collect(Collectors.toSet());
    }

    public Map<Person, List<Account>> groupByHolder(List<Account> accounts) {
        return accounts.stream()
                .collect(Collectors.groupingBy(Account::holder));
    }

}
