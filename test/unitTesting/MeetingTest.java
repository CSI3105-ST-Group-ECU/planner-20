package unitTesting;

import au.edu.sccs.csp3105.NBookingPlanner.Meeting;
import au.edu.sccs.csp3105.NBookingPlanner.Person;
import au.edu.sccs.csp3105.NBookingPlanner.Room;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author Jack
 *
 */

class MeetingTest {
	int month; int day; int start; int end; String description;
	Room room; ArrayList<Person> attendees;

	public MeetingTest(){
		this.month = 1;
		this.day = 1;
		this.start = 1;
		this.end = 2;
		this.description = "Test String";
		this.room = new Room();
		this.attendees = new ArrayList<>();
		this.attendees.add(new Person());
		this.attendees.add(new Person());
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {

		//MEE-1
		Meeting mee1 = new Meeting();
		//MEE-2
		Meeting mee2 = new Meeting(month, day);
		//MEE-3
		Meeting mee3 = new Meeting(month, day, description);
		//MEE-4
		Meeting mee4 = new Meeting(month, day, start, end);
		//MEE-5
		Meeting mee5 = new Meeting(month, day, start, end, attendees, room, description);

		//MEE-6

		//MEE-7

		//MEE-8
	}
}
