package unitTesting;

import au.edu.sccs.csp3105.NBookingPlanner.Organization;
import au.edu.sccs.csp3105.NBookingPlanner.Person;
import au.edu.sccs.csp3105.NBookingPlanner.Room;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Craig + Jake
 *
 */
class OrganizationTest {


	Organization organization;

	@BeforeEach
	void setUp() throws Exception {
		organization = new Organization();
	}

	@AfterEach
	void tearDown() throws Exception {
		organization = null;
	}

	@DisplayName("UOG-1")
	@Test
	void Test_initialisation_of_employee_and_person_list_with_correct_data() {
		assertEquals(organization.getEmployees().size(), 13);
		assertEquals(organization.getRooms().size(), 12);
	}

	@DisplayName("UOG-2")
	@Test
	void Test_getters_for_employee_List_with_correct_data() {
		ArrayList<Person> expectedEmployeeList = new ArrayList<>();
		expectedEmployeeList.add(new Person("Justin Gardener"));
		expectedEmployeeList.add(new Person("Ashley Matthews"));
		expectedEmployeeList.add(new Person("Mary Jane Cook"));
		expectedEmployeeList.add(new Person("Rose Austin"));
		expectedEmployeeList.add(new Person("Mike Smith"));
		expectedEmployeeList.add(new Person("Helen West"));
		expectedEmployeeList.add(new Person("Steven Lewis"));
		expectedEmployeeList.add(new Person("Edith Cowan"));
		expectedEmployeeList.add(new Person("Mark Colin"));
		expectedEmployeeList.add(new Person("Jacquie Martin"));
		expectedEmployeeList.add(new Person("Jaci Johnston"));
		expectedEmployeeList.add(new Person("Travis Colin"));
		expectedEmployeeList.add(new Person("Ashley Martin"));

		Iterator<Person> expected = expectedEmployeeList.iterator();
		Iterator<Person> actual = organization.getEmployees().iterator();
		while(expected.hasNext() && actual.hasNext())
		{
			assertEquals(expected.next().getName(), actual.next().getName());
		}
	}

	@DisplayName("UOG-3")
	@Test
	void Test_getters_for_room_List_with_correct_data() {
		ArrayList<Room> expectedRoomList = new ArrayList<>();
		expectedRoomList.add(new Room("JO18.330"));
		expectedRoomList.add(new Room("JO7.221"));
		expectedRoomList.add(new Room("JO15.236"));
		expectedRoomList.add(new Room("JO1.230"));
		expectedRoomList.add(new Room("JO34.536"));
		expectedRoomList.add(new Room("JO19.230"));
		expectedRoomList.add(new Room("ML5.123"));
		expectedRoomList.add(new Room("ML18.330"));
		expectedRoomList.add(new Room("ML21.520"));
		expectedRoomList.add(new Room("ML13.213"));
		expectedRoomList.add(new Room("ML21.310"));
		expectedRoomList.add(new Room("ML13.218"));

		Iterator<Room> expected = expectedRoomList.iterator();
		Iterator<Room> actual = organization.getRooms().iterator();
		while(expected.hasNext() && actual.hasNext())
		{
			assertEquals(expected.next().getID(), actual.next().getID());
		}
	}

	@DisplayName("UOG-4")
	@Test
	void Test_returns_room_with_correct_id() {
		assertDoesNotThrow(() -> {
			Room expected = new Room("JO18.330");
			Room actual = organization.getRoom("JO18.330");
			assertEquals(expected.getID(), actual.getID());
		});
	}

	@DisplayName("UOG-5")
	@Test
	void Test__throws_exception_room_does_not_exist() {

		Exception exception = assertThrows(Exception.class, ()-> organization.getRoom("Room.123"));

		String expectedMessage = "Requested room does not exist";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@DisplayName("UOG-6")
	@Test
	void Test_returns_room_on_second_iteration_with_correct_id() {
		assertDoesNotThrow(() -> {
			Room expected = new Room("JO7.221");
			Room actual = organization.getRoom("JO7.221");
			assertEquals(expected.getID(), actual.getID());
		});
	}

	@DisplayName("UOG-7")
	@Test
	void Test_returns_employee_with_correct_name() {
		assertDoesNotThrow(() -> {
			Person expected = new Person("Justin Gardener");
			Person actual = organization.getEmployee("Justin Gardener");
			assertEquals(expected.getName(), actual.getName());
		});
	}

	@DisplayName("UOG-8")
	@Test
	void Test__throws_exception_employee_does_not_exist() {
		Exception exception = assertThrows(Exception.class, ()-> organization.getEmployee("Dwayne Johnson"));

		String expectedMessage = "Requested employee does not exist";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@DisplayName("UOG-9")
	@Test
	void Test_returns_employee_on_second_iteration_with_correct_id() {
		assertDoesNotThrow(() -> {
			Person expected = new Person("Ashley Matthews");
			Person actual = organization.getEmployee("Ashley Matthews");
			assertEquals(expected.getName(), actual.getName());
		});
	}
}
