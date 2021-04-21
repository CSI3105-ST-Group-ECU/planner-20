package blackBoxTesting;

import au.edu.sccs.csp3105.NBookingPlanner.Planner;
import blackBoxTesting.common.ConsoleOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.github.stefanbirkner.systemlambda.SystemLambda.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BookingOnCertainDaysOfTheMonthTests {

    @ParameterizedTest(name = "#{index}- Valid Test with Argument={arguments}")
    @CsvSource({
            "1,3,1,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_1
            "1,3,2,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_2
            "1,3,3,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_3
            "1,3,4,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_4
            "1,3,5,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_5
            "1,3,6,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_6
            "1,3,7,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_7
            "1,3,8,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_8
            "1,3,9,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_9
            "1,3,10,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_10
            "1,3,11,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_11
            "1,3,12,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_12
            "1,3,13,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_13
            "1,3,14,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_14
            "1,3,15,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_15
            "1,3,16,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_16
            "1,3,17,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_17
            "1,3,18,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_18
            "1,3,19,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_19
            "1,3,20,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_20
            "1,3,21,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_21
            "1,3,22,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_22
            "1,3,23,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_23
            "1,3,24,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_24
            "1,3,25,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_25
            "1,3,26,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_26
            "1,3,27,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_27
            "1,3,28,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_28
            "1,3,29,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_29
            "1,3,30,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_30
            "1,3,31,9,10,JO18.330,Mark Colin,done,happy days"  //DAYS_31
    })
    void DAYS_ValidSchedulingAMeetingOnACertainDayOfTheMonthTest(String option, String start_month, String start_day, String start_hour, String end_hour, String room_id, String name, String done, String desc) throws Exception {
        String expected = ConsoleOutput.getValidScheduledMeetingOutput();

        String actual = tapSystemOutNormalized(() -> catchSystemExit(() -> withTextFromSystemIn(
                option,
                start_month,
                start_day,
                start_hour,
                end_hour,
                room_id,
                name,
                done,
                desc,
                "0").execute(() -> Planner.main(null))));

        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "#{index}- Invalid Test with Argument={arguments}")
    @CsvSource({
            "1,3,32,9,10,JO18.330,Mark Colin,done,happy days", //DAYS_32
            "1,3,-1,9,10,JO18.330,Mark Colin,done,happy days"  //DAYS_33
    })
    void DAYS_InvalidSchedulingAMeetingOnACertainDayOfTheMonthTest(String option, String start_month, String start_day, String start_hour, String end_hour, String room_id, String name, String done, String desc) throws Exception {
        String notExpected = ConsoleOutput.getValidScheduledMeetingOutput();

        String actual = tapSystemOutNormalized(() -> catchSystemExit(() -> withTextFromSystemIn(
                option,
                start_month,
                start_day,
                start_hour,
                end_hour,
                room_id,
                name,
                done,
                desc,
                "0").execute(() -> Planner.main(null))));

        assertNotEquals(notExpected, actual);
    }

    @ParameterizedTest(name = "#{index}- Valid Test with Argument={arguments}")
    @CsvSource({
            "2,3,3,1,2,Mark Colin",     //VDAYS_1
            "2,3,3,2,3,Mark Colin",     //VDAYS_2
            "2,3,3,3,4,Mark Colin",     //VDAYS_3
            "2,3,3,4,5,Mark Colin",     //VDAYS_4
            "2,3,3,5,6,Mark Colin",     //VDAYS_5
            "2,3,3,6,7,Mark Colin",     //VDAYS_6
            "2,3,3,7,8,Mark Colin",     //VDAYS_7
            "2,3,3,8,9,Mark Colin",     //VDAYS_8
            "2,3,3,9,10,Mark Colin",    //VDAYS_9
            "2,3,3,10,11,Mark Colin",   //VDAYS_10
            "2,3,3,11,12,Mark Colin",   //VDAYS_11
            "2,3,3,12,13,Mark Colin",   //VDAYS_12
            "2,3,3,13,14,Mark Colin",   //VDAYS_13
            "2,3,3,14,15,Mark Colin",   //VDAYS_14
            "2,3,3,15,16,Mark Colin",   //VDAYS_15
            "2,3,3,16,17,Mark Colin",   //VDAYS_16
            "2,3,3,17,18,Mark Colin",   //VDAYS_17
            "2,3,3,18,19,Mark Colin",   //VDAYS_18
            "2,3,3,19,20,Mark Colin",   //VDAYS_19
            "2,3,3,20,21,Mark Colin",   //VDAYS_20
            "2,3,3,21,22,Mark Colin",   //VDAYS_21
            "2,3,3,22,23,Mark Colin",   //VDAYS_22
            "2,3,3,23,24,Mark Colin",   //VDAYS_23
            "2,3,3,24,25,Mark Colin",   //VDAYS_24
            "2,3,3,25,26,Mark Colin",   //VDAYS_25
            "2,3,3,26,27,Mark Colin",   //VDAYS_26
            "2,3,3,27,28,Mark Colin",   //VDAYS_27
            "2,3,3,28,29,Mark Colin",   //VDAYS_28
            "2,3,3,29,30,Mark Colin",   //VDAYS_29
            "2,3,3,30,31,Mark Colin",   //VDAYS_30
            "2,3,3,31,2,Mark Colin"   //VDAYS_31
    })
    void VDAYS_ValidBookAVacationOnACertainDayOfTheMonthTest(String option, String start_month, String end_month, String start_day, String end_day, String name) throws Exception {
        String notExpected = ConsoleOutput.getValidVacationsOutput();

        String actual = tapSystemOutNormalized(() -> catchSystemExit(() -> withTextFromSystemIn(
                option,
                start_month,
                start_day,
                end_month,
                end_day,
                name,
                "0").execute(() -> Planner.main(null))));

        assertEquals(notExpected, actual);
    }

    @ParameterizedTest(name = "#{index}- Invalid Test with Argument={arguments}")
    @CsvSource({
            "2,3,3,32,3,Mark Colin",   //VDAYS_32
            "2,3,3,-1,4,Mark Colin",   //VDAYS_33
            "2,3,3,1,32,Mark Colin",   //VDAYS_32
            "2,3,3,2,-1,Mark Colin"    //VDAYS_33
    })
    void VDAYS_InvalidVacationOnACertainDayOfTheMonthTest(String option, String start_month, String end_month, String start_day, String end_day, String name) throws Exception {
        String notExpected = ConsoleOutput.getValidVacationsOutput();

        String actual = tapSystemOutNormalized(() -> catchSystemExit(() -> withTextFromSystemIn(
                option,
                start_month,
                start_day,
                end_month,
                end_day,
                name,
                "0").execute(() -> Planner.main(null))));

        assertNotEquals(notExpected, actual);
    }
}
