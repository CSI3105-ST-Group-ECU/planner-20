/**
 * 
 */
package blackBoxTesting;

import au.edu.sccs.csp3105.NBookingPlanner.Planner;
import blackBoxTesting.common.ConsoleOutput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.fail;
=======
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
>>>>>>> jake-branch

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

    @Tag("EQ_Tests")
    @DisplayName("EQ_Valid_Test")
    @ParameterizedTest(name = "#{index}- Valid Test with Argument={arguments}")
    @CsvSource({
    	"5,15,10,12",   //Valid EQs
    })
    
    void eq_valid(String month, String day, String start_hour, String end_hour) throws Exception{
    	String expected = ConsoleOutput.getValidCheckRoomOutput();
    	
    	String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
    			month,
    			day,
    			start_hour,
    			end_hour
    	).execute(() -> planner.checkRoomAvailability()));
    	
    	assertEquals(expected, actual);
    }
    
    
    @Tag("EQ_Tests")
    @DisplayName("EQ_Invalid_Tests")
    @ParameterizedTest(name = "#{index}- Invalid Test with Argument={arguments}")
    @CsvSource({
    	"-3,15,10,12",
    	"18,15,10,12",
    	"jake,15,10,12",
    	"5,0,10,12",
    	"5,39,10,12",
    	"5,jake,10,12",
    	"5,15,-10,12",
    	"5,15,36,12",
    	"5,15,jake,12",
    	"5,15,10,-2",
    	"5,15,10,50",
    	"5,15,10,jake"
    })
    
    void eq_invalid(String month, String day, String start_hour, String end_hour) throws Exception{
    	String expected = ConsoleOutput.getValidCheckRoomOutput();
    	
    	String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
    			month,
    			day,
    			start_hour,
    			end_hour
    	).execute(() -> planner.checkRoomAvailability()));
    	
    	assertNotEquals(expected, actual);
    }
    
    
    
    @Tag("BVA_Tests")
    @DisplayName("BVA_Valid_Tests")
    @ParameterizedTest(name = "#{index}- Valid Test with Argument={arguments}")
    @CsvSource({
    	"1,15,10,12",
    	"2,15,10,12",
    	"11,15,10,12",
    	"12,15,10,12",
    	"5,1,10,12",
    	"5,2,10,12",
    	"5,30,10,12",
    	"5,31,10,12",
    	"2,27,10,12",
    	"2,28,10,12",
    	"4,29,10,12",
    	"4,30,10,12",
    	"5,15,0,12",
    	"5,15,1,12",
    	"5,15,22,22",
    	"5,15,23,23",
    	"5,15,0,0",
    	"5,15,0,1",
    	"5,15,10,22",
    	"5,15,10,23"
    })
    
    void bva_valid(String month, String day, String start_hour, String end_hour) throws Exception{
    	String expected = ConsoleOutput.getValidCheckRoomOutput();
    	
    	String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
    			month,
    			day,
    			start_hour,
    			end_hour
    	).execute(() -> planner.checkRoomAvailability()));
    	
    	assertEquals(expected, actual);
    }
    
    @Tag("BVA_Tests")
    @DisplayName("BVA_Invalid_Tests")
    @ParameterizedTest(name = "#{index}- Invalid Test with Argument={arguments}")
    @CsvSource({
    	"0,15,10,12",
    	"13,1,10,12",
    	"5,0,10,12",
    	"5,32,10,12",
    	"2,29,10,12",
    	"4,31,10,12",
    	"5,15,-1,12",
    	"5,15,24,12",
    	"5,15,10,-1",
    	"5,15,10,24"
    })
    
    void bva_invalid(String month, String day, String start_hour, String end_hour) throws Exception{
    	String expected = ConsoleOutput.getValidCheckRoomOutput();
    	
    	String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
    			month,
    			day,
    			start_hour,
    			end_hour
    	).execute(() -> planner.checkRoomAvailability()));
    	
    	assertNotEquals(expected, actual);
    }

}
