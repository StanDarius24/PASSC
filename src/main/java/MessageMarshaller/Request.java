package MessageMarshaller;

import interfaces.Messages;

import java.io.Serializable;

public class Request implements Messages {
    public boolean type =false;
    public String name;
    public String method;
    public Serializable[] args;

    public Request(String name,String method,Serializable[] args)
    {
        this.name= name;
        this.method=method;
        this.args=args;
    }

    public Request(boolean t)
    {
        type=t;
    }


}
