package addressbook.service;

import addressbook.dao.AddressBookDAO;
import addressbook.model.ContactC;

import java.util.List;
import java.util.Set;

public class AddressBookService {
    private AddressBookDAO dao=new AddressBookDAO();

    // Use Case 6
    public void createAddressBook(String name){
        dao.addAddressBook(name);
    }

    // Use Case 2,5,7
    public boolean addContact(String bookName, ContactC contact){
        return dao.addContact(bookName,contact);
    }

    // Use Case 3
    public boolean editContact(String bookName,String firstName,ContactC updatedContact){
        return dao.editContact(bookName,firstName,updatedContact);
    }

    // Use Case 4
    public boolean deleteContact(String bookName,String firstName){
        return dao.deleteContact(bookName,firstName);
    }

    // Use Case 8
    public List<ContactC> searchByCity(String city){
        return dao.searchByCity(city);
    }

    public List<ContactC> searchByState(String state){
        return dao.searchByState(state);
    }

    // Use Case 10
    public int countByCity(String city){
        return dao.countByCity(city);
    }

    public int countByState(String state){
        return dao.countByState(state);
    }

    public Set<String> getAllBooks(){
        return dao.getAllBooks();
    }


}