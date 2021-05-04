import Commons.Address;
import Commons.AddressImpl;
import Generator.ProxyGenerator;
import MessageMarshaller.Marshaller;
import MessageMarshaller.Message;
import MessageMarshaller.Reply;
import MessageMarshaller.Request;
import RequestReply.Requestor;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        Address a = new AddressImpl("localhost", 1234);
        Requestor r = new Requestor("Darius");
        String aas = new String("register:darius:adresa:8893");
        /*
        String m = " " + theMsg.sender + ":" + theMsg.data;
		byte b[] = new byte[m.length()];
		b = m.getBytes();
		b[0] = (byte)m.length();
		return b;
         */
        byte data[] = new byte[aas.length()];
        data = aas.getBytes();

        data[0]=(byte)aas.length();
        byte [] response = r.deliver_and_wait_feedback(a, data);
        System.out.println("Am primit: " + new String(response));
        String ggs = new String("query:darius");
        byte data1[] = new byte[ggs.length()];
        data1 = ggs.getBytes();
        data1[0]=(byte) ggs.length();
        response = r.deliver_and_wait_feedback(a, data1);
        System.out.println("Am primit: " + new String(response));



    }
}
