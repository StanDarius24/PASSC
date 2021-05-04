package Proxys;
import java.io.Serializable;
import Commons.Address;
import MessageMarshaller.Marshaller;
import MessageMarshaller.Reply;
import MessageMarshaller.Request;
import RequestReply.Requestor;
import interfaces.InfoMarket;
public class InfoMarketClientProxy implements InfoMarket
{
private String name;
private Address address;
public InfoMarketClientProxy(String n, Address a) { name = n; address = a; }
public String getRoadInfo(int arg0) {
Serializable[] args = new Serializable[]{ arg0};
Request msg = new Request(name, "getRoadInfo", args);
Requestor r = new Requestor(name);
byte[] repl = r.deliver_and_wait_feedback(address, Marshaller.marshal(msg));
Reply rmsg = (Reply)Marshaller.unmarshalR(repl);
return (String) rmsg.reply;
}
public float getTemp(String arg0) {
Serializable[] args = new Serializable[]{ arg0};
Request msg = new Request(name, "getTemp", args);
Requestor r = new Requestor(name);
byte[] repl = r.deliver_and_wait_feedback(address, Marshaller.marshal(msg));
Reply rmsg = (Reply)Marshaller.unmarshalR(repl);
return (Float) rmsg.reply;
}
}
