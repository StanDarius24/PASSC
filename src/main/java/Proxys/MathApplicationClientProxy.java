package Proxys;
import java.io.Serializable;
import Commons.Address;
import MessageMarshaller.Marshaller;
import MessageMarshaller.Reply;
import MessageMarshaller.Request;
import RequestReply.Requestor;
import interfaces.MathApplication;
public class MathApplicationClientProxy implements MathApplication
{
private String name;
private Address address;
public MathApplicationClientProxy(String n, Address a) { name = n; address = a; }
public int add(int arg0,int arg1) {
Serializable[] args = new Serializable[]{ arg0, arg1};
Request msg = new Request(name, "add", args);
Requestor r = new Requestor(name);
byte[] repl = r.deliver_and_wait_feedback(address, Marshaller.marshal(msg));
Reply rmsg = (Reply)Marshaller.unmarshalR(repl);
return (Integer) rmsg.reply;
}
}
