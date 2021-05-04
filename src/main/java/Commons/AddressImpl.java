package Commons;

public class AddressImpl implements Address{
    private final String destinatar;
    private final int port;

    public AddressImpl(String dest,int i)
    {
        destinatar=dest;
        port=i;
    }

    @Override
    public String dest()
    {
        return destinatar;
    }
    @Override
    public int port()
    {
        return port;
    }
}
