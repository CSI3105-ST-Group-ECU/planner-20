package blackBoxTesting;

import static com.github.stefanbirkner.systemlambda.SystemLambda.*;
import static org.junit.jupiter.api.Assertions.*;

import au.edu.sccs.csp3105.NBookingPlanner.Planner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class BookingsAssociatedWith30thNovTests {

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @ParameterizedTest(name = "#{index}- Test with Argument={arguments}")
    @CsvSource({
            "1,11,30,9,10,JO18.330,Mark Colin,done,Happy Days"    //BBT_01
    })
    void SchedulingAMeetingOnThe30thNovTest(String option, String start_month, String start_day, String start_hour, String end_hour, String room_id, String name, String done, String desc) throws Exception {
        String expected = "Welcome to the Meeting Scheduling Interface.\n" +
                "\n" +
                "\n" +
                "1. Schedule a meeting\n" +
                "2. Book vacation dates\n" +
                "3. Check room availability\n" +
                "4. Check person availability\n" +
                "5. Check agenda for a room\n" +
                "6. Check agenda for a person\n" +
                "0. Exit\n" +
                "\n" +
                "Please enter the number that corresponds to the option that you want to proceed with.\n" +
                "\n" +
                "Enter the month of the meeting (1-12): \n" +
                "\n" +
                "Enter the day of the meeting (1-31): \n" +
                "\n" +
                "Enter the starting hour of the meeting (0-23): \n" +
                "\n" +
                "Enter the ending hour of the meeting (0-23): \n" +
                "The rooms open at that time are:\n" +
                "JO18.330\n" +
                "JO7.221\n" +
                "JO15.236\n" +
                "JO1.230\n" +
                "JO34.536\n" +
                "JO19.230\n" +
                "ML5.123\n" +
                "ML18.330\n" +
                "ML21.520\n" +
                "ML13.213\n" +
                "ML21.310\n" +
                "ML13.218\n" +
                "\n" +
                "Enter the desired room ID, or cancel to cancel: \n" +
                "The people available to attend at that time are:\n" +
                "Justin Gardener\n" +
                "Ashley Matthews\n" +
                "Mary Jane Cook\n" +
                "Rose Austin\n" +
                "Mike Smith\n" +
                "Helen West\n" +
                "Steven Lewis\n" +
                "Edith Cowan\n" +
                "Mark Colin\n" +
                "Jacquie Martin\n" +
                "Jaci Johnston\n" +
                "Travis Colin\n" +
                "Ashley Martin\n" +
                "\n" +
                "Enter a person's name, or done if finished: \n" +
                "\n" +
                "Enter a person's name, or done if finished: \n" +
                "\n" +
                "Enter a description for the meeting: \n" +
                "\n" +
                "\n" +
                "1. Schedule a meeting\n" +
                "2. Book vacation dates\n" +
                "3. Check room availability\n" +
                "4. Check person availability\n" +
                "5. Check agenda for a room\n" +
                "6. Check agenda for a person\n" +
                "0. Exit\n" +
                "\n" +
                "Please enter the number that corresponds to the option that you want to proceed with.\n";

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
}
