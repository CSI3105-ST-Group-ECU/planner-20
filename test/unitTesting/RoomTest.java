package unitTesting;

import au.edu.sccs.csp3105.NBookingPlanner.ConflictsException;
import au.edu.sccs.csp3105.NBookingPlanner.Meeting;
import au.edu.sccs.csp3105.NBookingPlanner.Room;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author Jack + Chris
 *
 */
class RoomTest {
	String ID = "TestID";
	Meeting meeting = new Meeting();
	Room room = new Room();


	@DisplayName("ROO-01:02 - Constructor Testing")
	@Test
	void ROO_Constructor_Tests(){
		//ROO-01
		Room roo1 = new Room();
		assertTrue(roo1 != null, "ROO-01 failed.");
		//ROO-02
		Room roo2 = new Room(ID);
		assertTrue(roo2 != null, "ROO-01 failed.");
	}

	@DisplayName("ROO-03:05 - addMeeting Fault Loop Testing")
	@Test
	void ROO_AddMeeting_Tests() {
		//ROO-03
		try {
			room.addMeeting(meeting);
		} catch (ConflictsException e) {
			System.out.println("ROO-03: Exception Thrown.");
		}

		//ROO-04

		//ROO-05
	}

	@DisplayName("ROO-06:07 - printAgenda Testing")
	@Test
	void ROO_PrintAgenda_Tests(){
		//ROO-06

		//ROO-07

	}

	@DisplayName("ROO-08:09 - isBusy Testing")
	@Test
	void ROO_IsBusy_Tests(){
		//ROO-08

		//ROO-09

	}

	@DisplayName("Roo-10:11 - getMeeting Testing")
	@Test
	void ROO_GetMeeting_Tests(){
		//ROO-10

		//ROO-11

	}

}
