/**
 * 
 */
package blackBoxTesting;

import au.edu.sccs.csp3105.NBookingPlanner.Planner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author Jake and Craig
 *
 */
class CheckRoomAvailabilityTest {
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

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
