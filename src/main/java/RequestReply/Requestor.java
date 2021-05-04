
package RequestReply;

import Commons.Address;

import java.net.*;
import java.io.*;


public class Requestor
{

	private Socket s;
	private OutputStream oStr;
	private InputStream iStr;
	private String myName;
	public Requestor(String theName) { myName = theName; }


	public byte[] deliver_and_wait_feedback(Address theDest, byte[] data)
	{

		byte[] buffer = null;
		int val;
		System.out.println(theDest.dest() + " " +theDest.port() + " data " +data.toString());
		try
		{
			s = new Socket(theDest.dest(), theDest.port());
			System.out.println("Requestor: Socket"+s);
			oStr = s.getOutputStream();
			oStr.write(data);
			oStr.flush();
			iStr = s.getInputStream();
			val = iStr.read();
			buffer = new byte[val];
			iStr.read(buffer);
			System.out.println(buffer);
			iStr.close();
			oStr.close();
			s.close();
			}
		catch (IOException e) { 
                       System.out.println("IOException in deliver_and_wait_feedback"); }
		return buffer;
	}

}

