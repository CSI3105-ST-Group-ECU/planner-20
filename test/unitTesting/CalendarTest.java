/**
 *
 */
package unitTesting;

import au.edu.sccs.csp3105.NBookingPlanner.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Scanner;

import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jack + Chris
 *
 */
class CalendarTest {

	Calendar calendar;
	Exception cause;
	String causeMessage;
	String message;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		Calendar calendar = new Calendar();
		causeMessage = "Inception!";
		message = "Conflict Exception Thrown";
		cause = new Exception(causeMessage);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}


	@DisplayName("CAL-1")
	@Test
	// Test creation of the Calendar Object
	void Test_initialisation_of_no_arg_calendar() {
		Calendar calendar = new Calendar();
		assertTrue(calendar != null);
	}

	@DisplayName("CAL-2")
	@Test
	// Test if Busy returns False for a day not already booked
	void Test_isBusy_Returns_False() throws ConflictsException {
		Room room = new Room("Test");
		Person person = new Person("Chris Raven");
	}
}




