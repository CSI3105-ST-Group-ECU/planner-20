package unitTesting;

import au.edu.sccs.csp3105.NBookingPlanner.Meeting;
import au.edu.sccs.csp3105.NBookingPlanner.Person;
import au.edu.sccs.csp3105.NBookingPlanner.Room;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jack + Chris
 *
 */

class MeetingTest {
	int month = 1;
	int day = 1;
	int start = 1;
	int end = 2;
	String description = "Test String";
	Room room = new Room("Test-01");
	ArrayList<Person> attendees = new ArrayList(){
		{
			add(new Person("Person1"));
			add(new Person("Person2"));
		}};

	@DisplayName("MEE-01:05 - Constructor Testing")
	@Test
	void MEE_Constructor_Tests() {
		//MEE-1
		Meeting mee1 = new Meeting();
		assertTrue(mee1 != null, "MEE-01 failed.");
		//MEE-2
		Meeting mee2 = new Meeting(month, day);
		assertTrue(mee2 != null, "MEE-02 failed.");
		assertTrue(mee2.getMonth() == month, "MEE-02 failed.");
		assertTrue(mee2.getDay() == day, "MEE-02 failed.");
		//MEE-3
		Meeting mee3 = new Meeting(month, day, description);
		assertTrue(mee3 != null, "MEE-03 failed.");
		assertTrue(mee3.getMonth() == month, "MEE-03 failed.");
		assertTrue(mee3.getDay() == day, "MEE-03 failed.");
		assertTrue(mee3.getDescription() == description, "MEE-03 failed.");
		//MEE-4
		Meeting mee4 = new Meeting(month, day, start, end);
		assertTrue(mee4 != null, "MEE-04 failed.");
		assertTrue(mee4.getMonth() == month, "MEE-04 failed.");
		assertTrue(mee4.getDay() == day, "MEE-04 failed.");
		assertTrue(mee4.getStartTime() == start, "MEE-04 failed.");
		assertTrue(mee4.getEndTime() == end, "MEE-04 failed.");
		//MEE-5
		Meeting mee5 = new Meeting(month, day, start, end, attendees, room, description);
		assertTrue(mee5 != null, "MEE-05 failed.");
		assertTrue(mee5.getMonth() == month, "MEE-05 failed.");
		assertTrue(mee5.getDay() == day, "MEE-05 failed.");
		assertTrue(mee5.getStartTime() == start, "MEE-05 failed.");
		assertTrue(mee5.getEndTime() == end, "MEE-05 failed.");
		assertTrue(mee5.getAttendees() == attendees, "MEE-05 failed.");
		assertTrue(mee5.getRoom() == room, "MEE-05 failed.");
		assertTrue(mee5.getDescription() == description, "MEE-05 failed.");

	}

	@DisplayName("MEE-06:07 - Attendee Function Tests")
	@Test
	void MEE_Attendee_Function_Tests(){
		//MEE-6
		ArrayList<Person> testList = new ArrayList<>();
		Meeting test = new Meeting(month, day, start, end, testList, room, description);
		Person person = new Person("TestPerson");
		test.addAttendee(person);
		assertTrue(test.getAttendees() != null, "MEE-06 failed.");

		//MEE-7
		test.removeAttendee(person);
		assertTrue(test.getAttendees().size() == 0, "MEE-07 failed.");
	}

	@DisplayName("MEE-08 - Print Function Test")
	@Test
	void MEE_Print_Function_Tests(){
		//MEE-8
		String expected = "Month is 1, Day is 1, Time slot:1 - 2, Room No:Test-01: Test String\nAttending: Person1,Person2";
		Meeting mee8 = new Meeting(month, day, start, end, attendees, room, description);
		assertEquals(mee8.toString(), expected, "MEE-08 failed.");
	}

}
