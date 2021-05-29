package unitTesting;

import au.edu.sccs.csp3105.NBookingPlanner.ConflictsException;
import au.edu.sccs.csp3105.NBookingPlanner.Meeting;
import au.edu.sccs.csp3105.NBookingPlanner.Room;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;



/**
 * @author Jack + Chris
 *
 */
class RoomTest {
	String ID = "TestID";
	Meeting meeting = new Meeting(1, 1, 1, 2);
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
		assertTrue(roo2.getID() == ID, "ROO-01 failed.");
	}

	@DisplayName("ROO-03:04 - addMeeting Fault Loop Testing")
	@Test
	void ROO_AddMeeting_Tests() {
		try {
			Field calendar = Room.class.getDeclaredField("calendar");
			calendar.setAccessible(true);

			//ROO-03
			try {
				room.addMeeting(meeting);
				assertTrue(calendar.get(room) != null, "ROO-03 failed.");
			} catch (ConflictsException e) {
				fail("ROO-03 failed.");
			} catch (IllegalAccessException e) {
				fail("ROO-03:05 - Reflection failure.");
			}
		} catch (NoSuchFieldException e) {
			fail("ROO-03:05 - Unable to retrieve private field.");
		}

		//ROO-04
		assertThrows(ConflictsException.class, () -> {room.addMeeting(new Meeting());},
				"ROO-04 failed.");

	}

	@DisplayName("ROO-05:06 - printAgenda Testing")
	@Test
	void ROO_PrintAgenda_Tests(){
		//ROO-05
		String roo5expected = "Agenda for 1:\n";
		assertEquals(room.printAgenda(1), roo5expected, "ROO-05 failed.");
		//ROO-06
		String roo6expected = "No Meetings booked on this date.\n\n";
		assertEquals(room.printAgenda(1, 2), roo6expected, "ROO-06 failed.");
	}

	@DisplayName("ROO-07:08 - isBusy Testing")
	@Test
	void ROO_IsBusy_Tests(){
		//ROO-07
		try {
			assertFalse(room.isBusy(1, 1, 1, 2), "ROO-07 failed.");
		} catch (ConflictsException e) {
			fail("ROO-07 failed");
		}
		//ROO-08
		assertThrows(ConflictsException.class, () -> {room.isBusy(1, 1, 2, 1);},
				"ROO-08 failed.");
	}

	@DisplayName("Roo-09:10 - getMeeting Testing")
	@Test
	void ROO_GetMeeting_Tests(){
		//ROO-09
		try{
			room.addMeeting(new Meeting(1, 1));
			Meeting meeting = room.getMeeting(1, 1, 0);
			assertNotNull(meeting, "ROO-09 failed.");
		} catch(Exception e){
			fail("ROO-09 failed.");
		}
		//ROO-10
			room.removeMeeting(1, 1, 0);
			assertThrows(IndexOutOfBoundsException.class, () -> {room.getMeeting(1, 1, 0);},
					"ROO-10 failed.");
	}

}
