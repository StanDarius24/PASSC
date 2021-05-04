package MessageMarshaller;

import interfaces.Messages;

public class Message implements Messages
{
	public String sender;
	public String data;
	public Message(String theSender, String rawData)
	{
		sender = theSender;
		data = rawData;
	}

	public String toString()
	{
		return sender + " " + data;
	}
}