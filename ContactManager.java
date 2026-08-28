import java.util.*;

public class ContactManager {

    public static void main(String[] args) {

        HashMap<String, Contact> contacts = new HashMap<>();

        // Step 4: add contacts
        contacts.put("Ada Lovelace",    new Contact("Ada Lovelace",    "+1 617 555 0101"));
        contacts.put("Grace Hopper",    new Contact("Grace Hopper",    "+1 202 555 0182"));
        contacts.put("Alan Turing",     new Contact("Alan Turing",     "+44 20 5550 0199"));
        contacts.put("Marie Curie",     new Contact("Marie Curie",     "+33 1 5550 0147"));
        contacts.put("Nikola Tesla",    new Contact("Nikola Tesla",    "+1 212 555 0163"));

        // Step 5: look up a contact
        System.out.println("=== Contact Lookup ===");
        String searchName = "Grace Hopper";
        Contact found = contacts.get(searchName);
        if (found == null) {
            System.out.println("Contact not found: " + searchName);
        } else {
            System.out.println("Found: " + found);
        }

        // Test with a name that doesn't exist
        String missing = "Unknown Person";
        Contact notFound = contacts.get(missing);
        if (notFound == null) {
            System.out.println("Contact not found: " + missing);
        } else {
            System.out.println("Found: " + notFound);
        }

        // Step 6: print sorted list
        System.out.println("\n=== All Contacts ===");
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));
        for (Contact c : sorted) {
            System.out.println(c);
        }
    }
}
