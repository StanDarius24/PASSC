import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Forwarder {
    private Socket socket;
    private OutputStream outputStream;

    private byte[] marshal(String theMsg) {
        byte b[] = new byte[theMsg.length()];
        b = theMsg.getBytes();
        b[0] = (byte) theMsg.length();
        return b;
    }

    private void deliver(Configuration configuration, byte[] data) {
        try {
            socket = new Socket(configuration.getLocal(), configuration.getPort());
            outputStream = socket.getOutputStream();
            outputStream.write(data);
            outputStream.flush();
            outputStream.close();
            socket.close();
        } catch ( IOException e ) {
            System.out.println("For error------" + e);
            e.printStackTrace();
        }

    }

    public void sendMsg(Configuration configuration, String theMsg) {
        System.out.println("Message delivered is: " + theMsg + " port: " + configuration.getPort());
        String news = "Message delivered is: " + theMsg + " port: " + configuration.getPort();
        deliver(configuration,marshal(news));
    }

}
