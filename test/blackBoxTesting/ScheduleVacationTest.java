
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

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOutNormalized;
import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Jake
 *
 */
class ScheduleVacationTest {
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
    	"5,15,5,25,Edith Cowan" //Valid EQ
    })
    
    void eq_valid(String start_month, String start_day, String end_month, String end_day, String name) throws Exception{
    	String expected = ConsoleOutput.getValidVacationsOutput();
    	
    	String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
    			start_month,
    			start_day,
    			end_month,
    			end_day,
    			name
    	).execute(() -> planner.scheduleVacation()));
    	
    	assertEquals(expected, actual);
    }
    
    @Tag("EQ_Tests")
    @DisplayName("EQ_Invalid_Tests")
    @ParameterizedTest(name = "#{index}- Invalid Test with Argument={arguments}")
    @CsvSource({
    	"56,15,5,25,Edith Cowan", //Invalid values for start_month
    	"-3,15,5,25,Edith Cowan",
    	"5,250,5,25,Edith Cowan", //Invalid values for start_day
    	"5,37,5,25,Edith Cowan", //Invalid values for start_day
    	"5,0,5,25,Edith Cowan",
    	"5,15,2235,25,Edith Cowan", //Invalid values for end_month
    	"5,15,-2235,25,Edith Cowan",
		"5,15,5,10448,Edith Cowan", //Invalid values for end_day
    	"5,15,5,55,Edith Cowan", //Invalid values for end_day
    	"5,15,5,-1,Edith Cowan",
    	"5,15,5,25,Obama" //Invalid value for name
    })
    
    void eq_invalid(String start_month, String start_day, String end_month, String end_day, String name) throws Exception{
    	String expected = ConsoleOutput.getValidVacationsOutput();
    	
    	String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
    			start_month,
    			start_day,
    			end_month,
    			end_day,
    			name
    	).execute(() -> planner.scheduleVacation()));
    	
    	assertNotEquals(expected, actual);
    }
    
    
    //////////////////////////////////////////////////////
    
    
	
    @Tag("BVA_Tests")
    @DisplayName("BVA_Valid_Tests")
    @ParameterizedTest(name = "#{index}- Valid Test with Argument={arguments}")
    @CsvSource({
    	"1,15,5,25,Edith Cowan", //Valid BVA for start_month
    	"2,15,5,25,Edith Cowan",
    	"11,15,11,25,Edith Cowan", //For the last two of these, end_month is changed too so that the start date is not after the end date
    	"12,15,12,25,Edith Cowan",
    	"5,1,5,25,Edith Cowan", //Valid BVA for start_day
    	"5,2,5,25,Edith Cowan",
    	"5,29,6,25,Edith Cowan", //For the last two of these, end_month is changed so that the start date is not after the end date
    	"5,30,6,25,Edith Cowan",
    	"4,15,1,25,Edith Cowan", //Valid BVA for end_month
    	"4,15,2,25,Edith Cowan", //For the first two of these, start_month is changed so that the start date is not after the end date
    	"5,30,6,25,Edith Cowan", //For the last two of these, end_month is changed so that the start date is not after the end date
    	"5,31,6,25,Edith Cowan",
    	"1,15,1,25,Edith Cowan", //Valid BVA for end_month
    	"1,15,2,25,Edith Cowan", //For the first two of these, start_month is changed so that the start date is not after the end date
    	"5,15,11,25,Edith Cowan",
    	"5,15,12,25,Edith Cowan",
    	"4,15,5,1,Edith Cowan", //Valid BVA for end_day
    	"4,15,5,2,Edith Cowan", //For the first two of these, start_month is changed so that the start date is not after the end date
    	"5,15,5,29,Edith Cowan",
    	"5,15,5,30,Edith Cowan",
    	"5,15,5,30,Edith Cowan",
    	"5,15,5,31,Edith Cowan",
    })
    
    void bva_valid(String start_month, String start_day, String end_month, String end_day, String name) throws Exception{
    	String expected = ConsoleOutput.getValidVacationsOutput();
    	
    	String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
    			start_month,
    			start_day,
    			end_month,
    			end_day,
    			name
    	).execute(() -> planner.scheduleVacation()));
    	
    	assertEquals(expected, actual);
    }
    
    @Tag("BVA_Tests")
    @DisplayName("BVA_Invalid_Tests")
    @ParameterizedTest(name = "#{index}- Invalid Test with Argument={arguments}")
    @CsvSource({
    	"0,15,5,25,Edith Cowan", //Invalid BVA for start_month
    	"13,15,5,25,Edith Cowan",
    	"5,0,5,25,Edith Cowan", //Invalid BVA for start_day
    	"5,31,5,25,Edith Cowan",
    	"5,32,5,25,Edith Cowan",
    	"5,15,0,25,Edith Cowan", //Invalid BVA for end_month
    	"5,15,13,25,Edith Cowan",
    	"5,15,5,0,Edith Cowan", //Invalid BVA for end_day
    	"5,15,5,31,Edith Cowan",
    	"5,15,5,32,Edith Cowan",
    })
    
    void bva_invalid(String start_month, String start_day, String end_month, String end_day, String name) throws Exception{
    	String expected = ConsoleOutput.getValidVacationsOutput();
    	
    	String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
    			start_month,
    			start_day,
    			end_month,
    			end_day,
    			name
    	).execute(() -> planner.scheduleVacation()));
    	
    	assertNotEquals(expected, actual);
    }
    
}
