package NamingServer;

import Commons.Address;
import Commons.AddressImpl;
import RequestReply.ByteStreamTransformer;

public class NamingServerTransformer implements ByteStreamTransformer {

    @Override
    public byte[] transform(byte[] in) {

        String data = new String(in);
        System.out.println("Am primit: " + data.substring(0,data.length()-1));

        //formatul: register:numeserver:adresadest:port
        //sau query:numeserver
        String ret = null;
        String operation = data.substring(0, data.indexOf(":"));
        data = data.substring(data.indexOf(":")+1);
        if (operation.equalsIgnoreCase("egister")) {
            String name = data.substring(0, data.indexOf(":"));
            data = data.substring(data.indexOf(":")+1);
            String addressname = data.substring(0, data.indexOf(":"));
            data = data.substring(data.indexOf(":")+1);
            String sport = data.substring(0,data.length()-1);
            System.out.println(sport);

            int port = Integer.parseInt(sport);
			System.out.println(operation);
			System.out.println(name);
			System.out.println(addressname);
			System.out.println(sport);
			System.out.println(port);

            //inregistreaza serverul conform la ce primeste
            NamingServer.register(name, new AddressImpl(addressname, port));

            //trimite inapoi "ok"
            ret = "ok";
        }

        else if (operation.equalsIgnoreCase("uery")) {
            String name = data.substring(0,data.length()-1);
            System.out.println(name);
            //ia adresa
            Address a = NamingServer.getAddress(name);
            if (a != null)

                ret = a.dest() + ":" + a.port();
            else ret = "0"; //0 la eroare
        }
        System.out.println("Ret " +ret);
        //returneaza raspunsul(ok, 0, sau adresa)
        byte[] b = new byte[ret.length()];
        b = ret.getBytes();
        b[0] = (byte) ret.length();

        /*
        String m = " " + theMsg.sender + ":" + theMsg.data;
		byte b[] = new byte[m.length()];
		b = m.getBytes();
		b[0] = (byte)m.length();
		return b;
         */

        return b;

    }

}
