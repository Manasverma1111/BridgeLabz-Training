package addressbook.model;

import addressBook.Contact;

import java.sql.*;
import java.util.List;

// UC18
public class DatabaseStorage implements StorageStrategy{

    public void save(List<Contact> list)throws Exception{
        Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/address",
                "root",
                "root"
        );

        for(ContactC c:list){
            PreparedStatement ps=con.prepareStatement(
                    "insert into contacts(name,city,state) values(?,?,?)"
            );
            ps.setString(1,c.getFirstName());
            ps.setString(2,c.getCity());
            ps.setString(3,c.getState());
            ps.executeUpdate();
        }
        con.close();
    }
}