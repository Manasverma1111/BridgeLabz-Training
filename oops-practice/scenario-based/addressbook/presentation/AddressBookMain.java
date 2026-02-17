package addressbook.presentation;

import addressbook.model.ContactC;
import addressbook.service.AddressBookService;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        AddressBookService service=new AddressBookService();

        System.out.println("Welcome to Address Book Program");

        while(true){
            System.out.println("\n1.Create Address Book");
            System.out.println("2.Add Contact");
            System.out.println("3.Edit Contact");
            System.out.println("4.Delete Contact");
            System.out.println("5.Search By City");
            System.out.println("6.Search By State");
            System.out.println("7.Count By City");
            System.out.println("8.Count By State");
            System.out.println("9.View Address Books");
            System.out.println("10.Sort By Name");
            System.out.println("11.Sort By City");
            System.out.println("12.Sort By State");
            System.out.println("13.Sort By Zip");
            System.out.println("14.Exit");

            int choice=scanner.nextInt();
            scanner.nextLine();

            switch(choice){

                case 1:
                    System.out.print("Enter Address Book Name:");
                    String bookName=scanner.nextLine();
                    service.createAddressBook(bookName);
                    System.out.println("Address Book Created");
                    break;

                case 2:
                    System.out.print("Enter Address Book Name:");
                    String addBook=scanner.nextLine();

                    System.out.print("First Name:");
                    String first=scanner.nextLine();
                    System.out.print("Last Name:");
                    String last=scanner.nextLine();
                    System.out.print("Address:");
                    String address=scanner.nextLine();
                    System.out.print("City:");
                    String city=scanner.nextLine();
                    System.out.print("State:");
                    String state=scanner.nextLine();
                    System.out.print("Zip:");
                    String zip=scanner.nextLine();
                    System.out.print("Phone:");
                    String phone=scanner.nextLine();
                    System.out.print("Email:");
                    String email=scanner.nextLine();

                    ContactC contact=new ContactC(first,last,address,city,state,zip,phone,email);

                    if(service.addContact(addBook,contact)){
                        System.out.println("Contact Added Successfully");
                    }else{
                        System.out.println("Duplicate Contact Or Address Book Not Found");
                    }
                    break;

                case 3:
                    System.out.print("Enter Address Book Name:");
                    String editBook=scanner.nextLine();
                    System.out.print("Enter First Name To Edit:");
                    String editName=scanner.nextLine();

                    System.out.print("New Last Name:");
                    String newLast=scanner.nextLine();
                    System.out.print("New Address:");
                    String newAddress=scanner.nextLine();
                    System.out.print("New City:");
                    String newCity=scanner.nextLine();
                    System.out.print("New State:");
                    String newState=scanner.nextLine();
                    System.out.print("New Zip:");
                    String newZip=scanner.nextLine();
                    System.out.print("New Phone:");
                    String newPhone=scanner.nextLine();
                    System.out.print("New Email:");
                    String newEmail=scanner.nextLine();

                    ContactC updated=new ContactC(editName,newLast,newAddress,newCity,newState,newZip,newPhone,newEmail);

                    if(service.editContact(editBook,editName,updated)){
                        System.out.println("Contact Updated");
                    }else{
                        System.out.println("Contact Not Found");
                    }
                    break;

                case 4:
                    System.out.print("Enter Address Book Name:");
                    String deleteBook=scanner.nextLine();
                    System.out.print("Enter First Name To Delete:");
                    String deleteName=scanner.nextLine();

                    if(service.deleteContact(deleteBook,deleteName)){
                        System.out.println("Contact Deleted");
                    }else{
                        System.out.println("Contact Not Found");
                    }
                    break;

                case 5:
                    System.out.print("Enter City:");
                    String searchCity=scanner.nextLine();
                    for(ContactC c:service.searchByCity(searchCity)){
                        System.out.println(c);
                    }
                    break;

                case 6:
                    System.out.print("Enter State:");
                    String searchState=scanner.nextLine();
                    for(ContactC c:service.searchByState(searchState)){
                        System.out.println(c);
                    }
                    break;

                case 7:
                    System.out.print("Enter City:");
                    String countCity=scanner.nextLine();
                    System.out.println("Total Contacts:"+service.countByCity(countCity));
                    break;

                case 8:
                    System.out.print("Enter State:");
                    String countState=scanner.nextLine();
                    System.out.println("Total Contacts:"+service.countByState(countState));
                    break;

                case 9:
                    System.out.println("Available Address Books:");
                    for(String name:service.getAllBooks()){
                        System.out.println(name);
                    }
                    break;

                case 10:
                    System.out.print("Enter Address Book Name:");
                    String sortNameBook=scanner.nextLine();
                    for(ContactC c:service.sortByName(sortNameBook)){
                        System.out.println(c);
                    }
                    break;

                case 11:
                    System.out.print("Enter Address Book Name:");
                    String sortCityBook=scanner.nextLine();
                    for(ContactC c:service.sortByCity(sortCityBook)){
                        System.out.println(c);
                    }
                    break;

                case 12:
                    System.out.print("Enter Address Book Name:");
                    String sortStateBook=scanner.nextLine();
                    for(ContactC c:service.sortByState(sortStateBook)){
                        System.out.println(c);
                    }
                    break;

                case 13:
                    System.out.print("Enter Address Book Name:");
                    String sortZipBook=scanner.nextLine();
                    for(ContactC c:service.sortByZip(sortZipBook)){
                        System.out.println(c);
                    }
                    break;

                case 14:
                    System.out.println("Exiting Program");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}