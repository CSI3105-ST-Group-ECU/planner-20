/**
 * 
 */
package unitTesting;

import au.edu.sccs.csp3105.NBookingPlanner.ConflictsException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Craig + Jake
 *
 */
class ConflictExceptionTest {

	ConflictsException conflictsException;
	Exception cause;
	String causeMessage;
	String message;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		causeMessage = "Inception!";
		message = "Conflict Exception Thrown";
		cause = new Exception(causeMessage);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@DisplayName("UCE-1")
	@Test
	void Test_initialisation_of_no_arg_ctor() {
		conflictsException = new ConflictsException();
		assertTrue(conflictsException != null);
	}

	@DisplayName("UCE-2")
	@Test
	void Test_initialisation_of_ctor_with_message() {
		conflictsException = new ConflictsException(message);
		assertEquals(conflictsException.getMessage(), message);
	}

	@DisplayName("UCE-3")
	@Test
	void Test_initialisation_of_ctor_with_an_empty_cause() {
		cause = null;
		conflictsException = new ConflictsException(cause);
		assertTrue(conflictsException.getCause() == null);
	}

	@DisplayName("UCE-4")
	@Test
	void Test_initialisation_of_ctor_with_cause() {

		conflictsException = new ConflictsException(cause);
		assertEquals(conflictsException.getCause().getMessage(), causeMessage);
	}

	@DisplayName("UCE-5")
	@Test
	void Test_initialisation_of_ctor_with_message_and_cause() {
		conflictsException = new ConflictsException(message, cause);
		assertEquals(conflictsException.getMessage(), message);
		assertEquals(conflictsException.getCause().getMessage(), causeMessage);
	}

	@DisplayName("UCE-6")
	@Test
	void Test_initialisation_of_cor_with_stack_trace_and_empty_suppressed_exceptions() {
		conflictsException = new ConflictsException(message, cause, false, true);
		assertTrue(conflictsException.getStackTrace().length !=0);
		assertTrue(conflictsException.getSuppressed().length == 0);
	}

	@DisplayName("UCE-7")
	@Test
	void Test_initialisation_of_ctor_with_empty_stack_trace() {
		conflictsException = assertThrows(ConflictsException.class,()->{
			throw new ConflictsException(message, cause, false, false);
		});

		assertTrue(conflictsException.getStackTrace().length == 0);
	}

	@DisplayName("UCE-8")
	@Test
	void Test_initialisation_of_ctor_with_suppressed_exceptions() {
		conflictsException = new ConflictsException(message, cause, true, true);

		assertTrue(conflictsException.getSuppressed() != null);
	}

}
