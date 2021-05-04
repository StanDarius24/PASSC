package ToyOrb;

import Commons.Address;
import Commons.AddressImpl;
import MessageMarshaller.Marshaller;
import MessageMarshaller.Reply;
import MessageMarshaller.Request;
import NamingServer.NamingServer;
import Proxys.GenericProxyServer;
import RequestReply.Requestor;
import com.sun.jdi.request.ClassUnloadRequest;

import java.lang.reflect.Constructor;

public class ToyOrb {
    private static String NamingServerAddress = "localhost";
    private static int NamingServerPort = 1234;
    private static AddressImpl NamingAddress = new AddressImpl(NamingServerAddress,NamingServerPort);

    public static void register(String name, Object o) {
        Requestor r = new Requestor(name);
        GenericProxyServer proxyServer = new GenericProxyServer(name, o);

        Address address = proxyServer.getAddress();

        String msg = "register:" + name + ":" + address.dest() + ":" + address.port();
        System.out.println(msg);
        byte data[] = new byte[msg.length()];
        data = msg.getBytes();
        data[0] = (byte) msg.length();
        byte[] answer = r.deliver_and_wait_feedback(NamingAddress, data);

        String asw = new String(answer);
        System.out.println(asw);
        if (!(asw.contains("k"))) {
            System.out.println("Eroare la conexiune");
        }
        proxyServer.startServer();
    }

        public static Object getObjectReference(String name) {

        Requestor r = new Requestor(name);
        String msg = "query:" + name;
        byte data[] = new byte[msg.length()];
        data =msg.getBytes();
        data[0] = (byte) msg.length();
        byte[] answer = r.deliver_and_wait_feedback(NamingAddress,data);
        String asw = new String(answer);
            System.out.println("Val este" + asw);
        String addressx = asw.substring(0,asw.indexOf(":"));
        int port = Integer.parseInt(asw.substring(asw.indexOf(":")+1));
        Address a = new AddressImpl(addressx,port);

        Request request = new Request(true);
        byte[] repl = r.deliver_and_wait_feedback(a, Marshaller.marshal(request));
        Reply reply = (Reply) Marshaller.unmarshalR(repl);
        String int_name = (String) reply.reply;
            System.out.println("int name " + int_name);
        String class_name ="Proxys." + int_name +"ClientProxy";
        System.out.println(class_name);
        try{
            Constructor<?> c = Class.forName(class_name).getConstructor(
                    new Class[]{ String.class, Address.class });
            return c.newInstance(name,a);
        } catch ( ClassNotFoundException e )
        {
            System.out.println("CLASS NOT FOUND!!!!!!!");
            e.printStackTrace();
        } catch ( Exception e )
        {
            System.out.println("Alta problema ceva la clase, e bai");
            e.printStackTrace();
        }
        return null;

    }

}
