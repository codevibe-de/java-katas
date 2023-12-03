package streams;

public record Account(
        String number,
        AccountType type,
        long balance,
        Person holder
) {
    public enum AccountType {
        CHECKING,
        SAVINGS
    }
}

