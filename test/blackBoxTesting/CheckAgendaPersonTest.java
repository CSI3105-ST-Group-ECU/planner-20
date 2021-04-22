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
	
	@Tag("Days")
    @DisplayName("Agenda_ValidDays")
    @ParameterizedTest(name = "#{index}- Valid Test with Argument = {arguments}")
    @CsvSource({
            "1,1,Justin Gardener", //Jan 1st Justin Gardener
            "1,2,Justin Gardener", //Jan 1st Justin Gardener
            "1,29,Justin Gardener", //Jan 1st Justin Gardener
            "1,30,Justin Gardener", //Jan 1st Justin Gardener

    })
	
	@Order(1)
	void AGENDA_ValidDays(String start_month, String start_day, String name) throws Exception {
        String notExpected = ConsoleOutput.getValidCheckAgendaForPersonOutput();

        String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
                start_month,
                start_day,
                name
        ).execute(() -> planner.checkAgendaPerson()));

        assertNotEquals(notExpected, actual);
    }
	
	@Tag("Days")
    @DisplayName("Agenda_InvalidDays")
    @ParameterizedTest(name = "#{index}- Invalid Test with Argument = {arguments}")
    @CsvSource({
            "1,0,Justin Gardener", //Jan 1st Justin Gardener
            "1,31,Justin Gardener", //Jan 1st Justin Gardener

    })
	
	@Order(2)
	void AGENDA_InvalidDays(String start_month, String start_day, String name) throws Exception {
        String expected = ConsoleOutput.getValidCheckAgendaForPersonOutput();

        String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
                start_month,
                start_day,
                name
        ).execute(() -> planner.checkAgendaPerson()));

        assertEquals(expected, actual);
    }
	
	@Tag("Months")
    @DisplayName("Agenda_ValidMonth")
    @ParameterizedTest(name = "#{index}- Valid Test with Argument = {arguments}")
    @CsvSource({
            "1,1,Justin Gardener", //Jan 1st Justin Gardener
            "2,1,Justin Gardener", //December 1st Justin Gardener
            "11,1,Justin Gardener", //Jan 1st Justin Gardener
            "12,1,Justin Gardener", //December 1st Justin Gardener
    })
	
	@Order(3)
	void AGENDA_ValidMonth(String start_month, String start_day, String name) throws Exception {
        String notExpected = ConsoleOutput.getValidCheckAgendaForPersonOutput();

        String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
                start_month,
                start_day,
                name
        ).execute(() -> planner.checkAgendaPerson()));

        assertNotEquals(notExpected, actual);
    }
	
	@Tag("Months")
    @DisplayName("Agenda_InvalidMonth")
    @ParameterizedTest(name = "#{index}- Invalid Test with Argument = {arguments}")
    @CsvSource({
            "0,1,Justin Gardener", //Jan 1st Justin Gardener
            "13,1,Justin Gardener", //December 1st Justin Gardener
    })
	
	@Order(4)
	void AGENDA_InvalidMonth(String start_month, String start_day, String name) throws Exception {
        String expected = ConsoleOutput.getValidCheckAgendaForPersonOutput();

        String actual = tapSystemOutNormalized(() -> withTextFromSystemIn(
                start_month,
                start_day,
                name
        ).execute(() -> planner.checkAgendaPerson()));

        assertEquals(expected, actual);
	}
}