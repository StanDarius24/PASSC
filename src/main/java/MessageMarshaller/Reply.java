package MessageMarshaller;

import interfaces.Messages;

import java.io.Serializable;

public class Reply implements Messages {
    public Serializable reply;
    public Reply(Serializable reply)
    {
        this.reply = reply;
    }

}
