/**
 * 
 */
package blackBoxTesting;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOutNormalized;
import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;
import static org.junit.jupiter.api.Assertions.*;

import au.edu.sccs.csp3105.NBookingPlanner.Planner;
import blackBoxTesting.common.ConsoleOutput;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

/**
 * @author Chris
 *
 */

@TestMethodOrder(OrderAnnotation.class)
class CheckAgendaPersonTest {
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
	
//	We will complete sets of testing here:
//	1. All Valid Days with Months of 28 Days
//	2. All Valid Days with Months of 29 Days (February Leap Year);
//	3. All Valid Days with Months of 30 Days;
//	4. All Valid Days with Months of 31 Days;
	
//	This testing assumes though, that the application has some method of determining if the year is a Leap Year, as if it is not
//	months with 29 days (Feb, Leap Year) should fail.
	
//	TODO - Create Tests for IsNull etc
	
	@Tag("28Days")
    @DisplayName("PersonAgenda_ValidDays_MonthsOf28Days")
    @ParameterizedTest(name = "#{index}- Valid Test with Argument = {arguments}")
    @CsvSource({    	
            "2,1,Justin Gardener",
            "2,2,Justin Gardener",
            "2,27,Justin Gardener", 
            "2,28,Justin Gardener",
    })
	
	@Order(1)
	void PersonAgenda_ValidDaysMonthsOf28Days(String start_month, String start_day, String name) throws Exception {
        String notExpected = ConsoleOutput.getValidCheckAgendaForPersonOutput();

        String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
                start_month,
                start_day,
                name
        ).execute(() -> planner.checkAgendaPerson()));

        assertNotEquals(notExpected, actual);
    }

	@Tag("28Days")
    @DisplayName("PersonAgenda_invalidDays_MonthsOf28Days")
    @ParameterizedTest(name = "#{index}- Invalid Test with Argument = {arguments}")
    @CsvSource({
            "2,0,Justin Gardener",// Boundary Testing for Invalid Inputs (0 and 29) for months of 28 Days
            "2,29,Justin Gardener",
            
    })
	
	@Order(2)
	void PersonAgenda_iInValidDaysMonthsOf28Days(String start_month, String start_day, String name) throws Exception {
        String notExpected = ConsoleOutput.getValidCheckAgendaForPersonOutput();

        String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
                start_month,
                start_day,
                name
        ).execute(() -> planner.checkAgendaPerson()));

        assertEquals(notExpected, actual);
    }
	
	@Tag("29Days")
    @DisplayName("PersonAgenda_ValidDays_MonthsOf29Days")
    @ParameterizedTest(name = "#{index}- Valid Test with Argument = {arguments}")
    @CsvSource({
            "2,1,Justin Gardener",
            "2,2,Justin Gardener",
            "2,28,Justin Gardener",
            "2,29,Justin Gardener",
    })
	
	@Order(3)
	void PersonAgenda_ValidDaysMonthsOf29Days(String start_month, String start_day, String name) throws Exception {
        String notExpected = ConsoleOutput.getValidCheckAgendaForPersonOutput();

        String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
                start_month,
                start_day,
                name
        ).execute(() -> planner.checkAgendaPerson()));

        assertNotEquals(notExpected, actual);
    }
	
	@Tag("29Days")
    @DisplayName("PersonAgenda_InvalidDays_MonthsOf29Days")
    @ParameterizedTest(name = "#{index}- Invalid Test with Argument = {arguments}")
    @CsvSource({
            "2,0,Justin Gardener",
            "2,30,Justin Gardener",
    })
	
	@Order(4)
	void PersonAgenda_InvalidDaysMonthsOf29Days(String start_month, String start_day, String name) throws Exception {
        String notExpected = ConsoleOutput.getValidCheckAgendaForPersonOutput();

        String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
                start_month,
                start_day,
                name
        ).execute(() -> planner.checkAgendaPerson()));

        assertEquals(notExpected, actual);
    }
	
	@Tag("30Days")
    @DisplayName("PersonAgenda_ValidDays_MonthsOf30Days")
    @ParameterizedTest(name = "#{index}- Valid Test with Argument = {arguments}")
    @CsvSource({
	//Create test cases for April and September, which have 30 days
            "4,1,Justin Gardener",
            "4,2,Justin Gardener",
            "4,29,Justin Gardener",
            "4,30,Justin Gardener",
            "9,1,Justin Gardener",
            "9,2,Justin Gardener",
            "9,29,Justin Gardener",
            "9,30,Justin Gardener",
    })
	
	@Order(5)
	void PersonAgenda_ValidDaysMonthsOf30Days(String start_month, String start_day, String name) throws Exception {
        String notExpected = ConsoleOutput.getValidCheckAgendaForPersonOutput();

        String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
                start_month,
                start_day,
                name
        ).execute(() -> planner.checkAgendaPerson()));

        assertNotEquals(notExpected, actual);
    }
	
	@Tag("30Days")
    @DisplayName("PersonAgenda_InvalidDays_MonthsOf30Days")
    @ParameterizedTest(name = "#{index}- Invalid Test with Argument = {arguments}")
    @CsvSource({
    //BVA Test cases for April and September   
            "4,0,Justin Gardener",
            "4,31,Justin Gardener",
            "9,0,Justin Gardener",
            "9,31,Justin Gardener",
    })
	
	@Order(6)
	void PersonAgenda_InvalidDaysMonthsOf30Days(String start_month, String start_day, String name) throws Exception {
        String notExpected = ConsoleOutput.getValidCheckAgendaForPersonOutput();

        String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
                start_month,
                start_day,
                name
        ).execute(() -> planner.checkAgendaPerson()));

        assertEquals(notExpected, actual);
    }
	
	@Tag("31Days")
    @DisplayName("PersonAgenda_ValidDays_MonthsOf31Days")
    @ParameterizedTest(name = "#{index}- Valid Test with Argument = {arguments}")
    @CsvSource({
	//Create test cases for March and October, which have 31 days
            "3,1,Justin Gardener",
            "3,2,Justin Gardener",
            "3,30,Justin Gardener",
            "3,31,Justin Gardener",
            "10,1,Justin Gardener",
            "10,2,Justin Gardener",
            "10,30,Justin Gardener",
            "10,31,Justin Gardener",
    })
	
	@Order(7)
	void PersonAgenda_ValidDaysMonthsOf31Days(String start_month, String start_day, String name) throws Exception {
        String notExpected = ConsoleOutput.getValidCheckAgendaForPersonOutput();

        String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
                start_month,
                start_day,
                name
        ).execute(() -> planner.checkAgendaPerson()));

        assertNotEquals(notExpected, actual);
    }
	
	@Tag("31Days")
    @DisplayName("PersonAgenda_InvalidDays_MonthsOf31Days")
    @ParameterizedTest(name = "#{index}- Invalid Test with Argument = {arguments}")
    @CsvSource({
    //BVA Test cases for April and September   
            "3,0,Justin Gardener",
            "3,32,Justin Gardener",
            "10,0,Justin Gardener",
            "10,32,Justin Gardener",
    })
	
	@Order(9)
	void PersonAgenda_InvalidInput(String start_month, String start_day, String name) throws Exception {
        String notExpected = ConsoleOutput.getValidCheckAgendaForPersonOutput();

        String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
                start_month,
                start_day,
                name
        ).execute(() -> planner.checkAgendaPerson()));

        assertEquals(notExpected, actual);
    }
}