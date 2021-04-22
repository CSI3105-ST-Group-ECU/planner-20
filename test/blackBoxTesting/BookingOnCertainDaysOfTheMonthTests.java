package blackBoxTesting;

import au.edu.sccs.csp3105.NBookingPlanner.Planner;
import blackBoxTesting.common.ConsoleOutput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static com.github.stefanbirkner.systemlambda.SystemLambda.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Deprecated
class BookingOnCertainDaysOfTheMonthTests {

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

    @Tag("DAYS")
    @DisplayName("DAYS_1 - DAYS_31")
    @ParameterizedTest(name = "#{index}- Valid Test with Argument={arguments}")
    @CsvSource({
            "3,1,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_1
            "3,2,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_2
            "3,3,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_3
            "3,4,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_4
            "3,5,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_5
            "3,6,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_6
            "3,7,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_7
            "3,8,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_8
            "3,9,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_9
            "3,10,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_10
            "3,11,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_11
            "3,12,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_12
            "3,13,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_13
            "3,14,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_14
            "3,15,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_15
            "3,16,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_16
            "3,17,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_17
            "3,18,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_18
            "3,19,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_19
            "3,20,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_20
            "3,21,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_21
            "3,22,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_22
            "3,23,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_23
            "3,24,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_24
            "3,25,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_25
            "3,26,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_26
            "3,27,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_27
            "3,28,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_28
            "3,29,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_29
            "3,30,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_30
            "3,31,9,10,JO18.330,Mark Colin,done,happy days"  //DAYS_31
    })
    void DAYS_ValidSchedulingAMeetingOnACertainDayOfTheMonthTest(String start_month, String start_day, String start_hour, String end_hour, String room_id, String name, String done, String desc) throws Exception {
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

    @Tag("DAYS")
    @DisplayName("DAYS_32 - DAYS_33")
    @ParameterizedTest(name = "#{index}- Invalid Test with Argument={arguments}")
    @CsvSource({
            "3,32,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_32
            "3,0,9,10,JO18.330,Mark Colin,done,happy days"  //DAYS_33
    })
    void DAYS_InvalidSchedulingAMeetingOnACertainDayOfTheMonthTest(String start_month, String start_day, String start_hour, String end_hour, String room_id, String name, String done, String desc) throws Exception {
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

    @Tag("VDAYS")
    @DisplayName("VDAYS_1 - VDAYS_31")
    @ParameterizedTest(name = "#{index}- Valid Test with Argument={arguments}")
    @CsvSource({
            "3,3,1,2,Mark Colin",     //VDAYS_1
            "3,3,2,3,Mark Colin",     //VDAYS_2
            "3,3,3,4,Mark Colin",     //VDAYS_3
            "3,3,4,5,Mark Colin",     //VDAYS_4
            "3,3,5,6,Mark Colin",     //VDAYS_5
            "3,3,6,7,Mark Colin",     //VDAYS_6
            "3,3,7,8,Mark Colin",     //VDAYS_7
            "3,3,8,9,Mark Colin",     //VDAYS_8
            "3,3,9,10,Mark Colin",    //VDAYS_9
            "3,3,10,11,Mark Colin",   //VDAYS_10
            "3,3,11,12,Mark Colin",   //VDAYS_11
            "3,3,12,13,Mark Colin",   //VDAYS_12
            "3,3,13,14,Mark Colin",   //VDAYS_13
            "3,3,14,15,Mark Colin",   //VDAYS_14
            "3,3,15,16,Mark Colin",   //VDAYS_15
            "3,3,16,17,Mark Colin",   //VDAYS_16
            "3,3,17,18,Mark Colin",   //VDAYS_17
            "3,3,18,19,Mark Colin",   //VDAYS_18
            "3,3,19,20,Mark Colin",   //VDAYS_19
            "3,3,20,21,Mark Colin",   //VDAYS_20
            "3,3,21,22,Mark Colin",   //VDAYS_21
            "3,3,22,23,Mark Colin",   //VDAYS_22
            "3,3,23,24,Mark Colin",   //VDAYS_23
            "3,3,24,25,Mark Colin",   //VDAYS_24
            "3,3,25,26,Mark Colin",   //VDAYS_25
            "3,3,26,27,Mark Colin",   //VDAYS_26
            "3,3,27,28,Mark Colin",   //VDAYS_27
            "3,3,28,29,Mark Colin",   //VDAYS_28
            "3,3,29,30,Mark Colin",   //VDAYS_29
            "3,3,30,31,Mark Colin",   //VDAYS_30
            "3,3,31,2,Mark Colin"   //VDAYS_31
    })
    void VDAYS_ValidBookAVacationOnACertainDayOfTheMonthTest(String start_month, String end_month, String start_day, String end_day, String name) throws Exception {
        String notExpected = ConsoleOutput.getValidVacationsOutput();
        String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
                start_month,
                start_day,
                end_month,
                end_day,
                name
        ).execute(() -> planner.scheduleVacation()));

        assertEquals(notExpected, actual);
    }

    @Tag("VDAYS")
    @DisplayName("VDAYS_32 - VDAYS_33")
    @ParameterizedTest(name = "#{index}- Invalid Test with Argument={arguments}")
    @CsvSource({
            "3,3,32,3,Mark Colin",   //VDAYS_32
            "3,3,0,4,Mark Colin",   //VDAYS_33
            "3,3,1,32,Mark Colin",   //VDAYS_32
            "3,3,2,0,Mark Colin"    //VDAYS_33
    })
    void VDAYS_InvalidVacationOnACertainDayOfTheMonthTest(String start_month, String end_month, String start_day, String end_day, String name) throws Exception {
        String notExpected = ConsoleOutput.getValidVacationsOutput();
        String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
                start_month,
                start_day,
                end_month,
                end_day,
                name
        ).execute(() -> planner.scheduleVacation()));

        assertNotEquals(notExpected, actual);
    }
}
