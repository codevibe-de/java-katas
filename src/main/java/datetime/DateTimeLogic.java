package datetime;

import java.time.*;

public class DateTimeLogic {

    public LocalDate createDateForThisYearsXmas() {
        return LocalDate.now().withMonth(Month.DECEMBER.getValue()).withDayOfMonth(24);
    }

    public ZonedDateTime convertToSydneyZone(ZonedDateTime input) {
        return input.withZoneSameInstant(ZoneId.of("Australia/Sydney"));
    }

    public LocalDate parseAndPostponeForTwoWeeks(String input) {
        var date = LocalDate.parse(input);
        return date.plusWeeks(2);
    }

    public String printIntervalBetweenInstantsInEnglishNotation(LocalDateTime input1, LocalDateTime input2) {
        var duration = Duration.between(input1, input2);
        var hours = duration.toHours();
        duration = duration.minusHours(hours);
        var minutes = duration.toMinutes();
        duration = duration.minusMinutes(minutes);
        return String.format("%dh %d' %d\"",
                hours, minutes, duration.toSeconds());
    }

    public int calculateDaysInMonth(int year, int month) {
        YearMonth yearMonthObject = YearMonth.of(year, month);
        return yearMonthObject.lengthOfMonth();
    }
}
