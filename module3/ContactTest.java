import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    private Contact contact;

    @BeforeEach
    public void setUp() {
        contact = new Contact("Alice Smith", "617-555-1234");
    }

    @Test
    public void getName_returnsCorrectName() {
        assertEquals("Alice Smith", contact.getName());
    }

    @Test
    public void getPhone_returnsCorrectPhone() {
        assertEquals("617-555-1234", contact.getPhone());
    }

    @Test
    public void toString_returnsNameAndPhoneSeparatedByPipe() {
        assertEquals("Alice Smith | 617-555-1234", contact.toString());
    }

    @Test
    public void constructor_setsNameCorrectly() {
        Contact c = new Contact("Bob Jones", "800-000-0000");
        assertEquals("Bob Jones", c.getName());
    }

    @Test
    public void constructor_setsPhoneCorrectly() {
        Contact c = new Contact("Bob Jones", "800-000-0000");
        assertEquals("800-000-0000", c.getPhone());
    }

    // Additional test 1: two contacts with the same name are independent objects
    @Test
    public void twoContactsWithSameName_areIndependent() {
        Contact a = new Contact("Same Name", "111-111-1111");
        Contact b = new Contact("Same Name", "222-222-2222");
        // Changing phone on b should not affect a
        assertNotEquals(a.getPhone(), b.getPhone());
        assertEquals("111-111-1111", a.getPhone());
    }

    // Additional test 2: contact with empty strings stores them without error
    @Test
    public void constructor_allowsEmptyStrings() {
        Contact empty = new Contact("", "");
        assertEquals("", empty.getName());
        assertEquals("", empty.getPhone());
    }
}
