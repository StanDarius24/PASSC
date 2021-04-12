public class Configuration {
    private String local;
    private Integer port;

    public Configuration ( String name, Integer s ) {
        local = name;
        port = s;
    }
    public String getLocal()
    {
        return local;
    }

    public Integer getPort()
    {
        return port;
    }
}
