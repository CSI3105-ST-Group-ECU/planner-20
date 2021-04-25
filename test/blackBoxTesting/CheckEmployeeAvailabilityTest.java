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

	@DisplayName("Employee_Availability_Month")
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

	@DisplayName("Employee_Availability_Month")
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
}