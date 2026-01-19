package addressBook;
import java.util.*;

/*
Use Case 5
Ability to add multiple
person to Address Book

Use Case 6
Refactor to add multiple Address Book to the System.
Each Address Book has a unique Name
 */
public class AddressBookDAO {

    private Map<String, AddressBook> addressBookMap = new HashMap<>();

    public void addAddressBook(String name) {
        addressBookMap.putIfAbsent(name, new AddressBook(name));
    }

    public AddressBook getAddressBook(String name) {
        return addressBookMap.get(name);
    }

    public void addContact(String bookName, Contact contact) {
        addressBookMap.get(bookName).getContacts().add(contact);
    }

/*
Use Case 4
Ability to delete a person using person's name
 */
    public void deleteContact(String bookName, Contact contact) {
        addressBookMap.get(bookName).getContacts().remove(contact);
    }

    public Collection<AddressBook> getAllAddressBooks() {
        return addressBookMap.values();
    }
}

