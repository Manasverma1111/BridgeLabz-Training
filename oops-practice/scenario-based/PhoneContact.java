import java.util.ArrayList;
import java.util.List;

class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) throws InvalidPhoneNumberException {

        if (!isValidPhoneNumber(phoneNumber)) {
            throw new InvalidPhoneNumberException(
                    "Phone number must be exactly 10 digits"
            );
        }

        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {

        return phoneNumber != null && phoneNumber.matches("\\d{10}");
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return name + " - " + phoneNumber;
    }
}

public class PhoneContact {

    private List<Contact> contacts = new ArrayList<>();

    public void addContact(String name, String phoneNumber)

            throws InvalidPhoneNumberException {
//        prevent duplicate phone numbers
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Duplicate contact not allowed.");
                return;
            }
        }

        Contact contact = new Contact(name, phoneNumber);
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }
//    delete contact by phone number
    public void deleteContact(String phoneNumber) {

        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                contacts.remove(c);
                System.out.println("Contact deleted.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
//    search contact by phone number
    public void searchContact(String phoneNumber) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Contact found: " + c);
                return;
            }
        }
        System.out.println("Contact not found.");
    }
//    display contacts
    public void displayContacts() {

        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("Contact List");
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {

        PhoneContact organizer = new PhoneContact();

        try {
            organizer.addContact("Rahul", "9876543201");
            organizer.addContact("Anita", "6423456789");
            organizer.addContact("Duplicate", "9876543201");
            organizer.addContact("Invalid", "54321");
        } catch (InvalidPhoneNumberException e) {
            System.out.println("Error: " + e.getMessage());
        }

        organizer.displayContacts();
        organizer.searchContact("9123456789");
        organizer.deleteContact("9876543201");
        organizer.displayContacts();
    }
}
