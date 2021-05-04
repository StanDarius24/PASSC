package Proxys;

import Commons.Address;
import Commons.AddressImpl;
import MessageMarshaller.Marshaller;
import MessageMarshaller.Reply;
import MessageMarshaller.Request;
import RequestReply.ByteStreamTransformer;
import RequestReply.Replyer;

import java.io.Serializable;
import java.lang.reflect.Method;

public class GenericProxyServer implements ByteStreamTransformer {
    private String name;
    private Object object;
    Replyer replyer;
    private static int port =0;

    public  GenericProxyServer(String n,Object o)
    {
        name = n;
        object = o;
        Address a = new AddressImpl("localhost", port);
        final GenericProxyServer tis = this;
        replyer = new Replyer(name,a);
        Thread t = new Thread(new Runnable() {
            public void run() {
                while(true) {
                    replyer.receive_transform_and_send_feedback(tis);
                }
            }
        });
        t.start();
    }
    public byte[] transform(byte[] in)
    {
       Request request = (Request) Marshaller.unmarshalRR(in);
       Reply reply = null;

       if(request.type)
       {
           reply = new Reply(this.getType());
       } else
       {
           reply = new Reply(this.call(request.name,request.method, request.args));
       }

       return Marshaller.marshal(reply);
    }

    public Address getAddress()
    {
        if(replyer != null)
            return replyer.getAddress();
        return null;
    }

    private String getType()
    {
        try{
            return object.getClass().getInterfaces()[0].getSimpleName();
        }catch ( Exception e )
        {
            e.printStackTrace();
        }
        return null;
    }

    private Serializable call(String name, String method,Serializable[] args)
    {
        Serializable retu = null;
        Object o = object;

        if(o == null)
        {
            System.out.println("Object doesnt exist");
            return null;
        }

        Class<?>[] types = new Class[args.length];

        for(int i=0;i<args.length;i++)
        {
            try{
                types[i] = (Class<?>) args[i].getClass().getDeclaredField("TYPE").get(null);
            } catch ( Exception e ) {
                e.printStackTrace();
                types[i] = args[i].getClass();
            }
        }

        Method m = null;
        try {
            m = o.getClass().getMethod(method,types);
            retu = (Serializable) m.invoke(o,(Object[]) args);
        } catch ( Exception e )
        {
            e.printStackTrace();
        }
        return retu;

    }

public void startServer()
{

}
}
