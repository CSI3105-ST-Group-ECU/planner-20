package blackBoxTesting;

import static com.github.stefanbirkner.systemlambda.SystemLambda.*;
import static org.junit.jupiter.api.Assertions.*;

import au.edu.sccs.csp3105.NBookingPlanner.Planner;
import blackBoxTesting.common.ConsoleOutput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BookingsOn30thNovTests {

    @Test
    void NOV30_SchedulingAMeetingOnThe30thNovTest() throws Exception {
        String expected = ConsoleOutput.getValidScheduledMeetingOutput();

        String actual = tapSystemOutNormalized(() -> catchSystemExit(() -> withTextFromSystemIn(
                "1",
                "11",
                "30",
                "9",
                "10",
                "JO18.330",
                "Mark Colin",
                "done",
                "Happy Days",
                "0").execute(() -> Planner.main(null))));

        assertEquals(expected, actual);
    }

    @Test
    void NOV30_InvalidScheduleOnTheThirteenthMonthTest() throws Exception {
        String notExpected = ConsoleOutput.getValidScheduledMeetingOutput();

        String actual = tapSystemOutNormalized(() -> catchSystemExit(() -> withTextFromSystemIn(
                "1",
                "13",
                "30",
                "9",
                "10",
                "JO18.330",
                "Mark Colin",
                "done",
                "Happy Days",
                "0").execute(() -> Planner.main(null))));

        assertNotEquals(notExpected, actual);
    }

    @Test
    void NOV30_InvalidScheduleOnThe31DayTest() throws Exception {
        String notExpected = ConsoleOutput.getValidScheduledMeetingOutput();

        String actual = tapSystemOutNormalized(() -> catchSystemExit(() -> withTextFromSystemIn(
                "1",
                "11",
                "31",
                "9",
                "10",
                "JO18.330",
                "Mark Colin",
                "done",
                "Happy Days",
                "0").execute(() -> Planner.main(null))));

        assertNotEquals(notExpected, actual);
    }

    @Test
    void NOV30_ValidBookAVacationFrom29to30thNovTest() throws Exception {
        String expected = ConsoleOutput.getValidVacationsOutput();

        String actual = tapSystemOutNormalized(() -> catchSystemExit(() -> withTextFromSystemIn(
                "2",
                "11",
                "11",
                "29",
                "30",
                "Mark Colin",
                "0").execute(() -> Planner.main(null))));

        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "#{index}- Test with Argument={arguments}")
    @CsvSource({
            "2,13,11,29,30,Mark Colin", //NOV30_4
            "2,11,13,29,30,Mark Colin", //NOV30_5
            "2,11,11,31,30,Mark Colin", //NOV30_6
            "2,11,11,29,31,Mark Colin"  //NOV30_7
    })
    void NOV30_InvalidVacationsOnCertainDaysTest(String option, String start_month, String end_month, String start_day, String end_day, String name) throws Exception {
        String expected = ConsoleOutput.getValidVacationsOutput();

        String actual = tapSystemOutNormalized(() -> catchSystemExit(() -> withTextFromSystemIn(
                option,
                start_month,
                start_day,
                end_month,
                end_day,
                name,
                "0").execute(() -> Planner.main(null))));

        assertNotEquals(expected, actual);
    }

}
