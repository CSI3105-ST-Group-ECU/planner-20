
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

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOutNormalized;
import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Craig
 *
 */
class ScheduleMeetingTest {

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

	@Tag("BB-SM")
	@DisplayName("Valid Scheduled Meeting Tests \uD83D\uDC4D")
	@ParameterizedTest(name = "#{index}- Valid Test with Argument={arguments}")
	@CsvSource({
			"1,1,0,1,JO18.330,Mark Colin,done,Happy Days",     //SM_01 - B
			"2,2,1,2,JO18.330,Mark Colin,done,Happy Days",     //SM_02 - B
			"2,29,9,10,JO18.330,Mark Colin,done,Happy Days",   //SM_03 - E
			"11,30,21,22,JO18.330,Mark Colin,done,Happy Days", //SM_04 - B
			"12,31,22,23,JO18.330,Mark Colin,done,Happy Days", //SM_05 - B
	})
	void ValidSchedulingAMeetingTest(String start_month, String start_day, String start_hour,
													   String end_hour, String room_id, String name, String done,
													   String desc) throws Exception {

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

	@Tag("BB-SM")
	@DisplayName("Invalid Scheduled Meeting Tests \uD83D\uDC4E")
	@ParameterizedTest(name = "#{index}- Valid Test with Argument={arguments}")
	@CsvSource({
			"0,2,1,2,JO18.330,Mark Collin,done,Happy Days",    //SM_06 - B
			"13,2,1,2,JO18.330,Mark Collin,done,Happy Days",   //SM_07 - B
			"1,0,1,2,JO18.330,Mark Collin,done,Happy Days",    //SM_08 - B
			"2,30,1,2,JO18.330,Mark Collin,done,Happy Days",   //SM_09 - E
			"1,32,1,2,JO18.330,Mark Collin,done,Happy Days",   //SM_10 - B
			"1,2,-1,2,JO18.330,Mark Collin,done,Happy Days",   //SM_11 - B
			"1,2,24,2,JO18.330,Mark Collin,done,Happy Days",   //SM_12 - B
			"1,2,1,-1,JO18.330,Mark Collin,done,Happy Days",   //SM_13 - B
			"1,2,1,24,JO18.330,Mark Collin,done,Happy Days",   //SM_14 - B
	})
	void InvalidSchedulingAMeetingTest(String start_month, String start_day, String start_hour,
													   String end_hour, String room_id, String name, String done,
													   String desc) throws Exception {

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

		assertNotEquals(expected, actual);
	}
}
