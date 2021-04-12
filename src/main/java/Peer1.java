public class Peer1 {
    public static void main(String[] args) {

        String local= "127.0.0.1";
        Integer port=8080;
        Configuration configuration = new Configuration ( local,port );
        Forwarder s = new Forwarder();
        s.sendMsg(configuration,new String("Hei cf"));
        Receiver q = new Receiver();
        System.out.println(q.receiveMSG(configuration));
    }
}
