package addressBook;
import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");

        Scanner sc = new Scanner(System.in);
        AddressBookService service = new AddressBookService();

        service.createAddressBook("Personal");

        System.out.print("Enter First Name: ");
        String fn = sc.nextLine();

        System.out.print("Enter Last Name: ");
        String ln = sc.nextLine();

        Contact contact = new Contact(
                fn, ln,
                "Street 1",
                "Delhi",
                "Delhi",
                "110001",
                "9999999999",
                "test@email.com"
        );

        boolean added = service.addContact("Personal", contact);
        System.out.println(added ? "Contact Added" : "Duplicate Contact");
    }
}


