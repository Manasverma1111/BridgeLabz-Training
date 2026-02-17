package addressbook.io;

import addressbook.model.ContactC;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONServerClient {

    // UC16
    public static void send(ContactC c)throws Exception{
        URL url=new URL("http://localhost:3000/contacts");
        HttpURLConnection con=(HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        OutputStream os=con.getOutputStream();
        os.write(c.toString().getBytes());
        os.close();
        con.getResponseCode();
    }
}