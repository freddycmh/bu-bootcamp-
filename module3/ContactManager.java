import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Grace Hopper", new Contact("Grace Hopper", "+1 212 555 0142"));
        contacts.put("Alan Turing", new Contact("Alan Turing", "+1 415 555 0187"));
        contacts.put("Katherine Johnson", new Contact("Katherine Johnson", "+1 757 555 0163"));
        contacts.put("Dennis Ritchie", new Contact("Dennis Ritchie", "+1 908 555 0124"));
        contacts.put("James Gosling", new Contact("James Gosling", "+1 650 555 0179"));
 
// Step 5: look up a contact
Contact found = contacts.get("Dennis Ritchie");
if (found == null) {
    System.out.println("Contact not found.");
} else {
    System.out.println(found);
}

Contact missing = contacts.get("Ada Lovelace");
if (missing == null) {
    System.out.println("Contact not found.");
} else {
    System.out.println(missing);
}

 
// Step 6: print sorted list
System.out.println("=== All Contacts ===");
List<Contact> sortedContacts = new ArrayList<>(contacts.values());
sortedContacts.sort((a, b) -> a.getName().compareTo(b.getName()));
for (Contact c : sortedContacts) {
    System.out.println(c);
}
        }
    } 
