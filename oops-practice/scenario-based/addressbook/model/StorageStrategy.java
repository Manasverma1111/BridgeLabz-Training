package addressbook.model;

import addressBook.Contact;
import java.util.List;

// UC18
public interface StorageStrategy{
    void save(List<Contact> list)throws Exception;
}