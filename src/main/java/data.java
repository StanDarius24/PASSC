

public class data {
    Integer number;
    String text;
    Float numberf;

    //Constructors

    public data()
    {

    }
    public data(String x)
    {
        text = x;
    }
    public data(Integer x)
    {
        number = x;
    }
    public data(String s,Integer i)
    {
        text = s;
        number = i;
    }
    public data(Float f,String s)
    {
        text = s;
        numberf = f;
    }

    //Methods

    public void Calculate()
    {
        System.out.println("Calculate method");
    }
    public Float Divide()
    {
        return numberf/number;
    }
    public Integer Multiply(Integer x)
    {
        return number*x;
    }
    public Float Divide(Float f)
    {
        return numberf/f;
    }

}
