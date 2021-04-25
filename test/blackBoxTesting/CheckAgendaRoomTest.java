/**
 * 
 */
package blackBoxTesting;

import au.edu.sccs.csp3105.NBookingPlanner.Planner;
import blackBoxTesting.common.ConsoleOutput;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOutNormalized;
import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Jack
 *
 */
@TestMethodOrder(OrderAnnotation.class)
class CheckAgendaRoomTest {
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

	@DisplayName("Room_Valid_Months")
	@ParameterizedTest(name = "#{index}- Test with Argument = {arguments}")
	@CsvSource({
			"1, 1, JO18.330",
			"2, 1, JO18.330",
			"11, 1, JO18.330",
			"12, 1, JO18.330",
	})
	@Order(1)
	void ROOM_ValidMonths(String month, String day, String room) throws Exception {
		String expected = ConsoleOutput.getValidCheckAgendaForRoomOutput();

		String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
				month, day, room).execute(() -> planner.checkAgendaRoom()));

		assertEquals(expected, actual,  "\n[ERROR][MONTH = "+month+"] Unexpected result for valid Input.\n");
	}

	@DisplayName("Room_Invalid_Months")
	@ParameterizedTest(name = "#{index}- Test with Argument = {arguments}")
	@CsvSource({
			"0, 1, JO18.330",
			"13, 1, JO18.330"
	})
	@Order(2)
	void ROOM_InvalidMonths(String month, String day, String room) throws Exception {
		String expected = ConsoleOutput.getValidCheckAgendaForRoomOutput();

		String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
				month, day, room).execute(() -> planner.checkAgendaRoom()));

		assertNotEquals(expected, actual, "\n[ERROR][MONTH = "+month+"] No error message thrown for Invalid Input.\n");
	}

	@DisplayName("Room_Valid_Days_Jan")
	@ParameterizedTest(name = "#{index}- Test with Argument = {arguments}")
	@CsvSource({
			//january
			"1, 1, JO18.330",
			"1, 2, JO18.330",
			"1, 30, JO18.330",
			"1, 31, JO18.330",
			//february
			"2, 1, JO18.330",
			"2, 2, JO18.330",
			"2, 27, JO18.330",
			"2, 28, JO18.330",
			"2, 29, JO18.330",
			//march
			"3, 1, JO18.330",
			"3, 2, JO18.330",
			"3, 30, JO18.330",
			"3, 31, JO18.330",
			//april
			"4, 1, JO18.330",
			"4, 2, JO18.330",
			"4, 29, JO18.330",
			"4, 30, JO18.330",
			//may
			"5, 1, JO18.330",
			"5, 2, JO18.330",
			"5, 30, JO18.330",
			"5, 31, JO18.330",
			//june
			"6, 1, JO18.330",
			"6, 2, JO18.330",
			"6, 29, JO18.330",
			"6, 30, JO18.330",
			//july
			"7, 1, JO18.330",
			"7, 2, JO18.330",
			"7, 30, JO18.330",
			"7, 31, JO18.330",
			//august
			"8, 1, JO18.330",
			"8, 2, JO18.330",
			"8, 30, JO18.330",
			"8, 31, JO18.330",
			//september
			"9, 1, JO18.330",
			"9, 2, JO18.330",
			"9, 29, JO18.330",
			"9, 30, JO18.330",
			//october
			"10, 1, JO18.330",
			"10, 2, JO18.330",
			"10, 30, JO18.330",
			"10, 31, JO18.330",
			//november
			"11, 1, JO18.330",
			"11, 2, JO18.330",
			"11, 29, JO18.330",
			"11, 30, JO18.330",
			//december
			"12, 1, JO18.330",
			"12, 2, JO18.330",
			"12, 30, JO18.330",
			"12, 31, JO18.330"
	})
	@Order(3)
	void ROOM_ValidDaysByMonth(String month, String day, String room) throws Exception {
		String expected = ConsoleOutput.getValidCheckAgendaForRoomOutput();

		String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
				month, day, room).execute(() -> planner.checkAgendaRoom()));

		assertEquals(expected, actual, "\n[ERROR][MONTH = "+month+", DAY = "+month+"] Unexpected result for valid Input.\n");
	}

	@DisplayName("Room_Invalid_Days_Jan")
	@ParameterizedTest(name = "#{index}- Test with Argument = {arguments}")
	@CsvSource({
			//january
			"1, 0, JO18.330",
			"1, 32, JO18.330",
			//february
			"2, 0, JO18.330",
			"2, 30, JO18.330",
			//march
			"3, 0, JO18.330",
			"3, 32, JO18.330",
			//april
			"4, 0, JO18.330",
			"4, 31, JO18.330",
			//may
			"5, 0, JO18.330",
			"5, 32, JO18.330",
			//june
			"6, 0, JO18.330",
			"6, 31, JO18.330",
			//july
			"7, 0, JO18.330",
			"7, 32, JO18.330",
			//august
			"8, 0, JO18.330",
			"8, 32, JO18.330",
			//september
			"9, 0, JO18.330",
			"9, 31, JO18.330",
			//october
			"10, 0, JO18.330",
			"10, 32, JO18.330",
			//november
			"11, 0, JO18.330",
			"11, 31, JO18.330",
			//december
			"12, 0, JO18.330",
			"12, 32, JO18.330",
	})
	@Order(4)
	void ROOM_InvalidDaysByMonth(String month, String day, String room) throws Exception {
		String expected = ConsoleOutput.getValidCheckAgendaForRoomOutput();

		String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
				month, day, room).execute(() -> planner.checkAgendaRoom()));

		assertNotEquals(expected, actual, "\n[ERROR][MONTH = "+month+", DAY = "+month+"] No error message thrown for Invalid Input.\n");
	}



}
