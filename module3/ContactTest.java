import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("Ada Lovelace", "+1 617 555 0101");
    }

    @Test
    void constructor_setsNameCorrectly() {
        assertEquals("Ada Lovelace", contact.getName());
    }

    @Test
    void constructor_setsPhoneCorrectly() {
        assertEquals("+1 617 555 0101", contact.getPhone());
    }

    @Test
    void getName_returnsExactString_notTransformed() {
        Contact c = new Contact("Grace Hopper", "555-0000");
        assertEquals("Grace Hopper", c.getName());
    }

    @Test
    void toString_containsName() {
        assertTrue(contact.toString().contains("Ada Lovelace"));
    }

    @Test
    void toString_containsPhone() {
        assertTrue(contact.toString().contains("+1 617 555 0101"));
    }

    // --- Step 7: additional edge-case tests ---

    @Test
    void constructor_createsIndependentInstances_whenNamesAreIdentical() {
        Contact first  = new Contact("Ada Lovelace", "555-0001");
        Contact second = new Contact("Ada Lovelace", "555-0002");

        assertNotSame(first, second, "same name must not mean same object");
        assertEquals(first.getName(), second.getName());
        assertEquals("555-0001", first.getPhone());
        assertEquals("555-0002", second.getPhone());
        assertTrue(first.toString().contains("555-0001"));
        assertTrue(second.toString().contains("555-0002"));
    }

    @Test
    void getPhone_preservesFormattingExactly_forDifferentFormats() {
        assertEquals("(617) 555-0101", new Contact("A", "(617) 555-0101").getPhone());
        assertEquals("617.555.0101", new Contact("B", "617.555.0101").getPhone());
        assertEquals("+44 20 7946 0958", new Contact("C", "+44 20 7946 0958").getPhone());
    }
}