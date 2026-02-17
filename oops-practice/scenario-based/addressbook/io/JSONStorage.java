package addressbook.io;

import java.io.FileWriter;
import java.util.List;
import addressbook.model.ContactC;
import com.google.gson.Gson;

public class JSONStorage {

    // UC15
    public static void writeJSON(List<ContactC> list, String file)throws Exception{
        Gson gson=new Gson();
        FileWriter writer=new FileWriter(file);
        gson.toJson(list,writer);
        writer.close();
    }
}