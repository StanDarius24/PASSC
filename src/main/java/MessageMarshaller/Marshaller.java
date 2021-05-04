package MessageMarshaller;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.lang.String;


public class Marshaller
{
	/*
	private boolean type =false;
    private String name;
    private String method;
    private Serializable[] args;
	 */
	public static byte[] marshal(Request request)
	{/*
		String m = " " + request.name +":" +request.method;
		byte b[] = new byte[m.length()];
		b=m.getBytes();
		b[0]=(byte)m.length();
		Serializable[] x = request.args;
		byte data[] =  SerializationUtils.serialize(request);
		byte f[] = new byte[m.length()+data.length];
		for(int i =0;i<m.length();i++)
			f[i]=b[i];
		f[m.length()] = (byte)data.length;
		for(int i=m.length()+1;i<m.length()+data.length;i++)
			f[i]=data[i-m.length()-1];
		return f;*/
		Serializable x = request;
		byte data[] = SerializationUtils.serialize(x);
		return data;

	}
	/*
		String msg = new String(byteArray);
		String sender = msg.substring(1, msg.indexOf(":"));
		String m = msg.substring(msg.indexOf(":")+1, msg.length()-1);
		return new Message(sender, m);
	private boolean type =false;
    private String name;
    private String method;
    private Serializable[] args;
	 */
	public static Request unmarshalRR(byte[] byteArray)
	{ /*
		int n = (int) byteArray[0];
		byte x[] = new byte[n];
		for(int i=0;i<n;i++)
			x[i]=byteArray[i];
		String text = new String(x);
		x= new byte[(int)byteArray[n]];
		for(int i = n;i<n+byteArray[n];i++)
			x[i-n]=byteArray[i];

		Serializable[] xy = SerializationUtils.deserialize(byteArray);

		String name = text.substring(1,text.indexOf(":"));
		String ds = text.substring(text.indexOf(":"));

		Request rs = new Request(name,ds,xy);


		return rs;*/
		Serializable ss = SerializationUtils.deserialize(byteArray);
		Request rs = (Request) ss;
		return  rs;

	}

	public static byte[] marshal(Message theMsg)
	{
		String m = " " + theMsg.sender + ":" + theMsg.data;
		byte b[] = new byte[m.length()];
		b = m.getBytes();
		b[0] = (byte)m.length();
		return b;
	}
			//public Serializable reply;
	public static byte[] marshal(Reply reply)
	{
		return SerializationUtils.serialize(reply);
	}

	public static Reply unmarshalR(byte[] byteArray)
	{
		return SerializationUtils.deserialize(byteArray);
	}

	public static Message unmarshal(byte[] byteArray)
	{
		String msg = new String(byteArray);
		String sender = msg.substring(1, msg.indexOf(":"));
		String m = msg.substring(msg.indexOf(":")+1, msg.length());
		return new Message(sender, m);
	}

}





