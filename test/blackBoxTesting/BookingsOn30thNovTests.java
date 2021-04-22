package blackBoxTesting;

import static com.github.stefanbirkner.systemlambda.SystemLambda.*;
import static org.junit.jupiter.api.Assertions.*;

import au.edu.sccs.csp3105.NBookingPlanner.Planner;
import blackBoxTesting.common.ConsoleOutput;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

class BookingsOn30thNovTests {
    Planner planner;

    @BeforeEach
    void setUp() {
        planner = Mockito.spy(Planner.class);
        Mockito.doNothing().when(planner).mainMenu();
    }

    @AfterEach
    void tearDown() {
        planner = null;
    }

    @Tag("NOV30")
    @DisplayName("NOV30_1")
    @Test
    void NOV30_ValidSchedulingAMeetingOnThe30thNovTest() throws Exception {
        String start_month = "11";
        String start_day = "30";
        String start_hour = "9";
        String end_hour = "10";
        String room_id = "JO18.330";
        String name = "Mark Colin";
        String done = "done";
        String desc = "Happy Days";

        String expected = ConsoleOutput.getValidScheduledMeetingOutput();
        String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
                start_month,
                start_day,
                start_hour,
                end_hour,
                room_id,
                name,
                done,
                desc
        ).execute(() -> planner.scheduleMeeting()));

        assertEquals(expected, actual);
    }

    @Tag("NOV30")
    @DisplayName("NOV30_3")
    @Test
    void NOV30_InvalidScheduleOnTheThirteenthMonthTest() throws Exception {
        String start_month = "13";
        String start_day = "30";
        String start_hour = "9";
        String end_hour = "10";
        String room_id = "JO18.330";
        String name = "Mark Colin";
        String done = "done";
        String desc = "Happy Days";

        String notExpected = ConsoleOutput.getValidScheduledMeetingOutput();
        String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
                start_month,
                start_day,
                start_hour,
                end_hour,
                room_id,
                name,
                done,
                desc
        ).execute(() -> planner.scheduleMeeting()));

        assertNotEquals(notExpected, actual);
    }


    @Tag("NOV30")
    @DisplayName("NOV30_4")
    @Test
    void NOV30_InvalidScheduleOnThe31DayTest() throws Exception {
        String start_month = "11";
        String start_day = "31";
        String start_hour = "9";
        String end_hour = "10";
        String room_id = "JO18.330";
        String name = "Mark Colin";
        String done = "done";
        String desc = "Happy Days";

        String notExpected = ConsoleOutput.getValidScheduledMeetingOutput();
        String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
                start_month,
                start_day,
                start_hour,
                end_hour,
                room_id,
                name,
                done,
                desc
        ).execute(() -> planner.scheduleMeeting()));

        assertNotEquals(notExpected, actual);
    }

    @Tag("NOV30")
    @DisplayName("NOV30_2")
    @Test
    void NOV30_ValidBookAVacationFrom29to30thNovTest() throws Exception {
        String start_month = "11";
        String end_month = "11";
        String start_day = "29";
        String end_day = "30";
        String name = "Mark Colin";

        String expected = ConsoleOutput.getValidVacationsOutput();
        String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
                start_month,
                end_month,
                start_day,
                end_day,
                name
        ).execute(() -> planner.scheduleVacation()));

        assertEquals(expected, actual);
    }

    @Tag("NOV30")
    @DisplayName("NOV30_5 - NOV30_8")
    @ParameterizedTest(name = "#{index}- Test with Argument={arguments}")
    @CsvSource({
            "13,11,29,30,Mark Colin", //NOV30_5
            "11,13,29,30,Mark Colin", //NOV30_6
            "11,11,31,30,Mark Colin", //NOV30_7
            "11,11,29,31,Mark Colin"  //NOV30_8
    })
    void NOV30_InvalidVacationsDaysOnNov30Test(String start_month, String end_month, String start_day, String end_day, String name) throws Exception {
        String expected = ConsoleOutput.getValidVacationsOutput();
        String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
                start_month,
                start_day,
                end_month,
                end_day,
                name
        ).execute(() -> planner.scheduleVacation()));

        assertNotEquals(expected, actual);
    }

}
