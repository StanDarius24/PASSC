import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {
    private ServerSocket srvS;
    private Socket s;
    private InputStream iStr;

    public byte[] receive ( Configuration configuration ) {
        int val;
        byte buffer[] = null;
        try {
            srvS = new ServerSocket ( configuration.getPort() ,2000 );
            s = srvS.accept ( );
            iStr = s.getInputStream ( );
            val = iStr.read ( );
            buffer = new byte[ val ];
            iStr.read ( buffer );
            iStr.close ( );
            s.close ( );
            srvS.close ( );
        } catch ( IOException e ) {
            System.out.println ( "IOE receiver" );
        }
        return buffer;

    }

    public String receiveMSG ( Configuration c ) {
        return unmarshal ( receive ( c ) );
    }


    private String unmarshal ( byte[] anArray ) {
        String msg = new String ( anArray );
        String m = msg.substring ( msg.indexOf ( ":" ) + 1 ,msg.length ( ) - 1 );
        m = m.substring ( 0 ,m.indexOf ( "port:" ) );
        return m;
    }
}
