/**
 * 
 */
package unitTesting;

import au.edu.sccs.csp3105.NBookingPlanner.ConflictsException;
import au.edu.sccs.csp3105.NBookingPlanner.Meeting;
import au.edu.sccs.csp3105.NBookingPlanner.Organization;
import au.edu.sccs.csp3105.NBookingPlanner.Person;
import au.edu.sccs.csp3105.NBookingPlanner.Room;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jake
 *
 */
class PersonTest {
	
	Person person;
	Person testPerson;
	Meeting meeting = new Meeting(1, 1, 1, 2);

	@BeforeEach
	void setUp() throws Exception {
		person = new Person();
		testPerson = new Person("Test Person");
	}

	@AfterEach
	void tearDown() throws Exception {
		person = null;
		testPerson = null;
	}

	@DisplayName("UP1")
	@Test
	void Test_Person_Constructors() {
		assertTrue(person != null, "UP-01 failed.");
		assertTrue(testPerson != null, "UP-01 failed.");
	}
	
	@DisplayName("UP2-3")
	@Test
	void Test_Person_getters() {
		//UP2
		assertEquals("", person.getName(), "UP2 failed.");
		assertEquals("Test Person", testPerson.getName(), "UP2 failed.");
		
		//UP3
		try{
			person.addMeeting(meeting);
			Meeting meeting = person.getMeeting(1,  1,  0);
			assertNotNull(meeting, "UP3 failed");
		}catch (ConflictsException e) {
			fail("UP3 failed - Conflicts Exception.");
		}
	}
	
	@DisplayName("UP4")
	@Test
	void Test_Person_AddMeeting() {
		try {
			Field calendar = Person.class.getDeclaredField("calendar");
			calendar.setAccessible(true);

			try {
				person.addMeeting(meeting);
				assertTrue(calendar.get(person) != null, "UP4 failed.");
			} catch (ConflictsException e) {
				fail("UP4 failed.");
			} catch (IllegalAccessException e) {
				fail("UP4 - Reflection failure.");
			}
		} catch (NoSuchFieldException e) {
			fail("UP4 - Unable to retrieve private field.");
		}
	}
	
	@DisplayName("UP5-6")
	@Test
	void Test_Person_PrintAgenda() {
		//UP5
		String personExpectedAgenda1 = "Agenda for 1:\n";
		assertEquals(personExpectedAgenda1, person.printAgenda(1), "UP5 failed.");
		
		//UP6
		String personExpectedAgenda2 = "No Meetings booked on this date.\n\n";
		assertEquals(personExpectedAgenda2, person.printAgenda(1, 2), "UP6 failed.");
	}
	
	@DisplayName("UP7")
	@Test
	void Test_Person_isBusy() {
		try {
			assertEquals(false, person.isBusy(1,  1,  1,  2), "UP7 failed.");
		} catch (ConflictsException e) {
			fail("UP7 - Conflicts Exception");
		}
	}
	
	@DisplayName("UP8")
	@Test
	void Test_Person_removeMeeting() {
		try{
			person.addMeeting(meeting);
			person.removeMeeting(1, 1, 0);
		    assertThrows(IndexOutOfBoundsException.class, () -> person.getMeeting(1, 1, 0), "UP8 failed.");
		}catch(ConflictsException e) {
			fail("UP7 - Conflicts Exception");
		}
	}
}
