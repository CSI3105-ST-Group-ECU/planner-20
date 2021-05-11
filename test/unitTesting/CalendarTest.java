/**
 *
 */
package unitTesting;

import au.edu.sccs.csp3105.NBookingPlanner.*;
import org.junit.jupiter.api.*;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jack + Chris
 *
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalendarTest {

	Calendar calendar = new Calendar();
	int month = 1;
	int day = 1;
	int start = 1;
	int end = 2;
	String description = "Test String";
	Room room = new Room("Test-01");
	Person person = new Person("TestPerson");
	ArrayList<Person> attendees = new ArrayList<>(){
		{
			add(new Person("Person1"));
			add(new Person("Person2"));
		}};

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}
	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown () throws Exception {

	}

	@DisplayName("CAL-1 - Constructor Testing")
	@Test
	@Order(1)
	// Test creation of the Calendar Object
	void test_initialisation_of_no_arg_calendar () {
		Calendar calendar = new Calendar();
		assertTrue(calendar != null);
	}

	@DisplayName("CAL -2:3 - isBusy() Testing")
	@Test
	@Order(2)
	//Test if start >= toCheck.getStartTime() && start <= toCheck.getEndTime()
	void test_isBusy_return_true_1 () throws ConflictsException {
		try {
			assertFalse(calendar.isBusy(1, 1, 1, 2), "CAL-2 Failed.");
			assertFalse(calendar.isBusy(1, 1, 1, 3), "CAL-2 Failed.");
			assertFalse(calendar.isBusy(1, 1, 1, 4), "CAL-2 Failed.");
		} catch (ConflictsException e) {
			fail("CAL-4 Failed");
		}
	//Test if end >= toCheck.getStartTime() && end <= toCheck.getEndTime()
		try {
			assertFalse(calendar.isBusy(1,1,2,2), "CAL-3 Failed.");
			assertFalse(calendar.isBusy(1,1,3,3), "CAL-3 Failed.");
			assertFalse(calendar.isBusy(1,1,4,4), "CAL-3 Failed.");
			assertFalse(calendar.isBusy(1,1,5,5), "CAL-3 Failed.");
		} catch (ConflictsException e) {
			fail("CAL-4 Failed");
		}
	}

	@DisplayName("CAL-4 - isBusy() Exception Test")
	@Test
	@Order(3)
	// Test throwing an acception if the Start Time is laster than the End time
	void test_isBusy_ThrowsException () throws ConflictsException {
		assertThrows(ConflictsException.class, () -> {calendar.isBusy(1, 1, 5, 1);}, "FAILED");
	}

	@DisplayName("CAL-5:9 - checkTimes() Exception Test")
	@Test
	@Order(4)
	//Confirm that an exception is thrown for tests 5 through 9
	void test_CheckTimes_InvalidEntries() throws ConflictsException {
		assertThrows(ConflictsException.class, () -> {Calendar.checkTimes(1,0,1,1);},"FAILED");
		assertThrows(ConflictsException.class, () -> {Calendar.checkTimes(0,1,1,1);},"FAILED");
		assertThrows(ConflictsException.class, () -> {Calendar.checkTimes(1,1,-1,1);},"FAILED");
		assertThrows(ConflictsException.class, () -> {Calendar.checkTimes(1,0,1,3);},"FAILED");
	}

	@DisplayName("CAL-10 - addMeeting() Valid Test")
	@Test
	@Order(5)
	void addMeeting_Test() throws ConflictsException {
	//CAL-10
	Meeting CAL10 = new Meeting(month, day, start, end, attendees, room, description);
	calendar.addMeeting(CAL10);
	assertTrue(CAL10 != null,"CAL-10 FAILED");
	}

	@DisplayName("CAL-11:13 - addMeeting() invalid Tests")
	@Test
	@Order(6)
	void addMeeting_ExceptionTest() throws ConflictsException{
		//CAL11
		Meeting CAL11 = new Meeting(month, -1, start, end, attendees, room, description);
		assertThrows(ConflictsException.class, () -> {calendar.addMeeting(CAL11);},"FAILED");

		//CAL12
		Meeting CAL12 = new Meeting(month, day, 5, end, attendees, room, description);
		assertThrows(ConflictsException.class, () -> {calendar.addMeeting(CAL12);},"FAILED");

		//CAL13
		Meeting CAL13 = new Meeting(month, day, start, end, attendees, room, description);
		assertThrows(ConflictsException.class, () -> {calendar.addMeeting(CAL11);},"FAILED");

	}

	@DisplayName("CAL-14 - printAgenda() valid Tests")
	@Test
	@Order(7)
	void printAgenda_ValidTests() throws ConflictsException {
		//CAL14
		assertTrue(calendar.printAgenda(1) != null);
	}

	@DisplayName("CAL-15 - printAgenda() throws exception")
	@Test
	@Order(8)
	void printAgenda_invalidTests() throws ConflictsException {
		//CAL15
		assertThrows(IndexOutOfBoundsException.class, () -> {calendar.printAgenda(-1);},"FAILED");
		assertThrows(NullPointerException.class, () -> {calendar.printAgenda(2);},"FAILED");
	}

	@DisplayName("CAL-16:17 - printAgenda(Month,Day) valid tests")
	@Test
	@Order(9)
	void printAgenda_Month_Day_valid_tests() throws ConflictsException {
		//CAL16 We assert that printing the agenda works without issues
		assertTrue(calendar.printAgenda(1,1) != null);

		//CAL17 We get the expected scrting back if there are no bookings on the day
		String expected = "No Meetings booked on this date.\n" +
				"\n";

		assertTrue(calendar.printAgenda(1,1) == expected);
	}

	@DisplayName("CAL-18 - getMeeting(Month,Day) Valid Inputs")
	@Test
	@Order(10)
	void getMeeting_month_day_index_test() throws ConflictsException {
	//CAL18 We expect this to work, checking that the meeting has been added
	Meeting CAL18 = new Meeting(1, 1, start, end, attendees, room, description);
	calendar.addMeeting(CAL18);
	assertTrue(calendar.getMeeting(1,1,0) != null);

	}

	@DisplayName("CAL-19 - getMeeting(Month,Day) throws exception")
	@Test
	@Order(11)
	void getMeeting_month_day_index_throwsexception() throws ConflictsException {
		//CAL19. There are no meetings booked for January 1st, so we expect this to throw an exception
		assertThrows(IndexOutOfBoundsException.class, () -> {calendar.getMeeting(1,1,0);},"Failed");
		assertThrows(IndexOutOfBoundsException.class, () -> {calendar.getMeeting(1,1,1);},"Failed");
		assertThrows(IndexOutOfBoundsException.class, () -> {calendar.getMeeting(1,1,2);},"Failed");
		assertThrows(IndexOutOfBoundsException.class, () -> {calendar.getMeeting(1,1,4);},"Failed");
	}
}


