package datetime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.*;

class DateTimeLogicTest {

    private final DateTimeLogic dateTimeLogic = new DateTimeLogic();

    @Test
    void shouldCreateDate() {
        LocalDate result = dateTimeLogic.createDateForThisYearsXmas();
        Assertions.assertThat(result).hasDayOfMonth(24);
        Assertions.assertThat(result).hasMonth(Month.DECEMBER);
        Assertions.assertThat(result).hasYear(LocalDate.now().getYear());
    }

    @Test
    void shouldParseAndPostponeForTwoWeeks() {
        String input = "2007-12-03";
        LocalDate result = dateTimeLogic.parseAndPostponeForTwoWeeks(input);
        Assertions.assertThat(result).hasDayOfMonth(17);
        Assertions.assertThat(result).hasMonth(Month.DECEMBER);
        Assertions.assertThat(result).hasYear(2007);
    }

    @Test
    void shouldConvertToSydneyZone() {
        ZonedDateTime input = ZonedDateTime.now(ZoneId.of("Europe/Berlin"));
        ZonedDateTime result = dateTimeLogic.convertToSydneyZone(input);
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isEqualTo(input);
        Assertions.assertThat(result.getZone()).isEqualTo(ZoneId.of("Australia/Sydney"));
    }

    @Test
    void shouldPrintIntervalBetweenInstantsInEnglishNotation() {
        LocalDateTime input1 = LocalDateTime.parse("2007-12-03T10:15:30");
        LocalDateTime input2 = LocalDateTime.parse("2007-12-03T11:18:42");
        String result = dateTimeLogic.printIntervalBetweenInstantsInEnglishNotation(input1, input2);
        Assertions.assertThat(result).isEqualTo("1h 3' 12\"");
    }

    @Test
    void shouldCalculateDaysInMonth() {
        int result = dateTimeLogic.calculateDaysInMonth(2000, 2);
        Assertions.assertThat(result).isEqualTo(29);
    }
}