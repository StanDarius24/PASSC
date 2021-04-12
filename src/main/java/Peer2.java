public class Peer2 {
    public static void main(String[] args) {

        String local= "127.0.0.1";
        Integer port=8080;
        Configuration configuration = new Configuration ( local,port );
        Receiver s = new Receiver();

        System.out.println(s.receiveMSG(configuration));

        Forwarder q = new Forwarder();

        q.sendMsg(configuration,new String("Bine tu?"));

    }
}
