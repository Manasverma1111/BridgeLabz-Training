package addressbook.dao;
import addressbook.model.ContactC;

import java.util.*;

// Use Case 5,6,7,8,9,10: Data Storage Layer
public class AddressBookDAO {

    // Use Case 6: Multiple Address Books
    private Map<String,List<ContactC>> addressBooks=new HashMap<>();

    // Use Case 9: City and State Dictionary
    private Map<String,List<ContactC>> cityMap=new HashMap<>();
    private Map<String,List<ContactC>> stateMap=new HashMap<>();

    // Use Case 6: Create Address Book
    public void addAddressBook(String name){
        addressBooks.putIfAbsent(name,new ArrayList<>());
    }

    // Use Case 2,5,7: Add Contact with Duplicate Check
    public boolean addContact(String bookName,ContactC contact){
        List<ContactC> contacts=addressBooks.get(bookName);
        if(contacts==null){
            return false;
        }
        if(contacts.contains(contact)){
            return false;
        }
        contacts.add(contact);

        cityMap.computeIfAbsent(contact.getCity(),k->new ArrayList<>()).add(contact);
        stateMap.computeIfAbsent(contact.getState(),k->new ArrayList<>()).add(contact);
        return true;
    }

    // Use Case 3: Edit Contact
    public boolean editContact(String bookName,String firstName,ContactC updatedContact){
        List<ContactC> contacts=addressBooks.get(bookName);
        if(contacts==null)return false;

        for(int i=0;i<contacts.size();i++){
            if(contacts.get(i).getFirstName().equalsIgnoreCase(firstName)){
                contacts.set(i,updatedContact);
                return true;
            }
        }
        return false;
    }

    // Use Case 4: Delete Contact
    public boolean deleteContact(String bookName,String firstName){
        List<ContactC> contacts=addressBooks.get(bookName);
        if(contacts==null)return false;

        Iterator<ContactC> iterator=contacts.iterator();
        while(iterator.hasNext()){
            ContactC contact=iterator.next();
            if(contact.getFirstName().equalsIgnoreCase(firstName)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    // Use Case 8: Search by City
    public List<ContactC> searchByCity(String city){
        return cityMap.getOrDefault(city,new ArrayList<>());
    }

    // Use Case 8: Search by State
    public List<ContactC> searchByState(String state){
        return stateMap.getOrDefault(state,new ArrayList<>());
    }

    // Use Case 10: Count by City
    public int countByCity(String city){
        return cityMap.getOrDefault(city,new ArrayList<>()).size();
    }

    // Use Case 10: Count by State
    public int countByState(String state){
        return stateMap.getOrDefault(state,new ArrayList<>()).size();
    }

    // Extra Utility
    public Set<String> getAllBooks(){
        return addressBooks.keySet();
    }

    // UC11: Sort by Name
    public List<ContactC> sortByName(String bookName){
        List<ContactC> list=new ArrayList<>(addressBooks.get(bookName));
        Collections.sort(list,(a,b)->a.getFirstName().compareToIgnoreCase(b.getFirstName()));
        return list;
    }

    // UC12: Sort by City
    public List<ContactC> sortByCity(String bookName){
        List<ContactC> list=new ArrayList<>(addressBooks.get(bookName));
        Collections.sort(list,(a,b)->a.getCity().compareToIgnoreCase(b.getCity()));
        return list;
    }

    // UC12: Sort by State
    public List<ContactC> sortByState(String bookName){
        List<ContactC> list=new ArrayList<>(addressBooks.get(bookName));
        Collections.sort(list,(a,b)->a.getState().compareToIgnoreCase(b.getState()));
        return list;
    }

    // UC12: Sort by Zip
    public List<ContactC> sortByZip(String bookName){
        List<ContactC> list=new ArrayList<>(addressBooks.get(bookName));
        Collections.sort(list,(a,b)->a.getZip().compareToIgnoreCase(b.getZip()));
        return list;
    }
}