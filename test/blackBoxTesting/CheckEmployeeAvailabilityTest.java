
package blackBoxTesting;

import au.edu.sccs.csp3105.NBookingPlanner.Planner;
import blackBoxTesting.common.ConsoleOutput;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOutNormalized;
import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Chris and Jack
 *
 */
class CheckEmployeeAvailabilityTest {
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

	@DisplayName("EmployeeAvailability BA: Month valid")
	@ParameterizedTest(name = "#{index}- Test with Argument = {arguments}")
	@CsvSource({
			"1, 1, 1, 2",
			"2, 1, 1, 2",
			"11, 1, 1, 2",
			"12, 1, 1, 2"
	})
	@Order(1)
	void EMPLOYEE_ValidMonths(String month, String day, String startTime, String endTime) throws Exception {
		String expected = ConsoleOutput.getValidCheckPersonOutput();

		String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(month, day, startTime, endTime
		).execute(() -> planner.checkEmployeeAvailability()));

		assertEquals(expected, actual,  "\n[ERROR][MONTH = "+month+"] Unexpected result for valid Input.\n");
	}

	@DisplayName("EmployeeAvailability BA: Month invalid")
	@ParameterizedTest(name = "#{index}- Test with Argument = {arguments}")
	@CsvSource({
			"0, 1, 1, 2",
			"13, 1, 1, 2",
	})
	@Order(2)
	void EMPLOYEE_InvalidMonths(String month, String day, String startTime, String endTime) throws Exception {
		String expected = ConsoleOutput.getValidCheckPersonOutputInvalidMonth();

		String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(month, day, startTime, endTime
		).execute(() -> planner.checkEmployeeAvailability()));

		assertEquals(expected, actual,  "\n[ERROR][MONTH = "+month+"] No error message thrown for Invalid Input.\n");
	}

	@DisplayName("EmployeeAvailability BA: Days valid")
	@ParameterizedTest(name = "#{index}- Test with Argument = {arguments}")
	@CsvSource({
			//january
			"1, 1, 1, 2",
			"1, 2, 1, 2",
			"1, 30, 1, 2",
			"1, 31, 1, 2",
			//february
			"2, 1, 1, 2",
			"2, 2, 1, 2",
			"2, 27, 1, 2",
			"2, 28, 1, 2",
			"2, 29, 1, 2",
			//march
			"3, 1, 1, 2",
			"3, 2, 1, 2",
			"3, 30, 1, 2",
			"3, 31, 1, 2",
			//april
			"4, 1, 1, 2",
			"4, 2, 1, 2",
			"4, 29, 1, 2",
			"4, 30, 1, 2",
			//may
			"5, 1, 1, 2",
			"5, 2, 1, 2",
			"5, 30, 1, 2",
			"5, 31, 1, 2",
			//june
			"6, 1, 1, 2",
			"6, 2, 1, 2",
			"6, 29, 1, 2",
			"6, 30, 1, 2",
			//july
			"7, 1, 1, 2",
			"7, 2, 1, 2",
			"7, 30, 1, 2",
			"7, 31, 1, 2",
			//august
			"8, 1, 1, 2",
			"8, 2, 1, 2",
			"8, 30, 1, 2",
			"8, 31, 1, 2",
			//september
			"9, 1, 1, 2",
			"9, 2, 1, 2",
			"9, 29, 1, 2",
			"9, 30, 1, 2",
			//october
			"10, 1, 1, 2",
			"10, 2, 1, 2",
			"10, 30, 1, 2",
			"10, 31, 1, 2",
			//november
			"11, 1, 1, 2",
			"11, 2, 1, 2",
			"11, 29, 1, 2",
			"11, 30, 1, 2",
			//december
			"12, 1, 1, 2",
			"12, 2, 1, 2",
			"12, 30, 1, 2",
			"12, 31, 1, 2",
	})
	@Order(3)
	void EMPLOYEE_ValidDays(String month, String day, String startTime, String endTime) throws Exception {
		String expected = ConsoleOutput.getValidCheckPersonOutput();

		String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(month, day, startTime, endTime
		).execute(() -> planner.checkEmployeeAvailability()));

		assertEquals(expected, actual,  "\n[ERROR][MONTH = "+month+", DAY = "+day+"] Unexpected result for valid Input.\n");
	}

	@DisplayName("EmployeeAvailability BA: Days invalid")
	@ParameterizedTest(name = "#{index}- Test with Argument = {arguments}")
	@CsvSource({
			//january
			"1, 0, 1, 2",
			"1, 32, 1, 2",
			//february
			"2, 0, 1, 2",
			"2, 30, 1, 2",
			//march
			"3, 0, 1, 2",
			"3, 32, 1, 2",
			//april
			"4, 0, 1, 2",
			"4, 31, 1, 2",
			//may
			"5, 0, 1, 2",
			"5, 32, 1, 2",
			//june
			"6, 0, 1, 2",
			"6, 31, 1, 2",
			//july
			"7, 0, 1, 2",
			"7, 32, 1, 2",
			//august
			"8, 0, 1, 2",
			"8, 32, 1, 2",
			//september
			"9, 0, 1, 2",
			"9, 31, 1, 2",
			//october
			"10, 0, 1, 2",
			"10, 32, 1, 2",
			//november
			"11, 0, 1, 2",
			"11, 31, 1, 2",
			//december
			"12, 0, 1, 2",
			"12, 32, 1, 2",
	})
	@Order(4)
	void EMPLOYEE_InvalidDays(String month, String day, String startTime, String endTime) throws Exception {
		String expected = ConsoleOutput.getValidCheckPersonOutputInvalidDay();

		String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(month, day, startTime, endTime
		).execute(() -> planner.checkEmployeeAvailability()));

		assertEquals(expected, actual,  "\n[ERROR][MONTH = "+month+", DAY = "+day+"] No error message thrown for Invalid Input.\n");
	}

	@DisplayName("EmployeeAvailability BA: StartTime valid")
	@ParameterizedTest(name = "#{index}- Test with Argument = {arguments}")
	@CsvSource({
			"1, 1, 0, 1",
			"1, 1, 1, 2",
			"1, 1, 22, 23",
			"1, 1, 23, 24",
	})
	@Order(5)
	void EMPLOYEE_ValidStartTime(String month, String day, String startTime, String endTime) throws Exception {
		String expected = ConsoleOutput.getValidCheckPersonOutput();

		String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(month, day, startTime, endTime
		).execute(() -> planner.checkEmployeeAvailability()));

		assertEquals(expected, actual,  "\n[ERROR][MONTH = "+month+", DAY = "+day+", START TIME = "+startTime+"] Unexpected result for valid Input.\n");
	}

	@DisplayName("EmployeeAvailability BA: StartTime invalid")
	@ParameterizedTest(name = "#{index}- Test with Argument = {arguments}")
	@CsvSource({
			"1, 1, -1, 1",
			"1, 1, 24, 24",
	})
	@Order(6)
	void EMPLOYEE_InvalidStartTime(String month, String day, String startTime, String endTime) throws Exception {
		String expected = ConsoleOutput.getValidCheckPersonOutputInvalidHour();

		String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(month, day, startTime, endTime
		).execute(() -> planner.checkEmployeeAvailability()));

		assertEquals(expected, actual,  "\n[ERROR][MONTH = "+month+", DAY = "+day+", START TIME = "+startTime+"] No error message thrown for Invalid Input.\n");
	}

	@DisplayName("EmployeeAvailability BA: EndTime valid")
	@ParameterizedTest(name = "#{index}- Test with Argument = {arguments}")
	@CsvSource({
			"1, 1, 0, 1",
			"1, 1, 1, 2",
			"1, 1, 1, 23",
			"1, 1, 1, 24",
	})
	@Order(7)
	void EMPLOYEE_ValidEndTime(String month, String day, String startTime, String endTime) throws Exception {
		String expected = ConsoleOutput.getValidCheckPersonOutput();

		String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(month, day, startTime, endTime
		).execute(() -> planner.checkEmployeeAvailability()));

		assertEquals(expected, actual,  "\n[ERROR][MONTH = "+month+", DAY = "+day+", START TIME = "+startTime+", END TIME = "+endTime+"] Unexpected result for valid Input.\n");
	}

	@DisplayName("EmployeeAvailability BA: EndTime invalid")
	@ParameterizedTest(name = "#{index}- Test with Argument = {arguments}")
	@CsvSource({
			"1, 1, 0, 0",
			"1, 1, 1, 25",
	})
	@Order(8)
	void EMPLOYEE_InvalidEndTime(String month, String day, String startTime, String endTime) throws Exception {
		String expected = ConsoleOutput.getValidCheckPersonOutputInvalidHour();

		String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(month, day, startTime, endTime
		).execute(() -> planner.checkEmployeeAvailability()));

		assertEquals(expected, actual,  "\n[ERROR][MONTH = "+month+", DAY = "+day+", START TIME = "+startTime+", END TIME = "+endTime+"] No error message thrown for Invalid Input.\n");
	}

	@DisplayName("EmployeeAvailability E: Time Validity")
	@ParameterizedTest(name = "#{index}- Test with Argument = {arguments}")
	@CsvSource({
			"1, 1, 10, 11",
	})
	@Order(9)
	void EMPLOYEE_VALID_TIME_VALIDITY(String month, String day, String startTime, String endTime) throws Exception {
		String expected = ConsoleOutput.getValidCheckPersonOutput();

		String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(month, day, startTime, endTime
		).execute(() -> planner.checkEmployeeAvailability()));

		assertEquals(expected, actual,  "\n[ERROR][MONTH = "+month+", DAY = "+day+", START TIME = "+startTime+", END TIME = "+endTime+"] Unexpected result for valid Input.\n");
	}

	@DisplayName("EmployeeAvailability E: Time Validity")
	@ParameterizedTest(name = "#{index}- Test with Argument = {arguments}")
	@CsvSource({
			"1, 1, 11, 11",
			"1, 1, 11, 10"
	})
	@Order(10)
	void EMPLOYEE_INVALID_TIME_VALIDITY(String month, String day, String startTime, String endTime) throws Exception {
		String expected = ConsoleOutput.getValidCheckPersonOutputIllogicalHour();

		String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(month, day, startTime, endTime
		).execute(() -> planner.checkEmployeeAvailability()));

		assertEquals(expected, actual,  "\n[ERROR][MONTH = "+month+", DAY = "+day+", START TIME = "+startTime+", END TIME = "+endTime+"] Unexpected result for valid Input.\n");
	}
}