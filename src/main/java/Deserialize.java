import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

public class Deserialize{

    data d;
    String text;
    public Deserialize()
    {
        d=new data(); text = new String();
    }

    public String deser()
    {
        Map FieldsMap = new HashMap();
        Class<?> dataclass = d.getClass();
        Field[] fields = dataclass.getDeclaredFields();

        if(fields.length>0)
            for(Field i : fields)
            {
               String name = i.getName();
               String type = i.getType().toString();
               type= type.replace("class java.lang.","");
               FieldsMap.put(type,name);
            }
        Set set = FieldsMap.entrySet();

        Iterator itr = set.iterator();

        while(itr.hasNext())
        {
            Map.Entry entry = (Map.Entry)itr.next();
            text = text + "Field " + entry.getKey() + " " + entry.getValue() + "\n";
        }

        int nrcrt=0;
        Constructor[] constructors = dataclass.getDeclaredConstructors();
        for(Constructor i : constructors)
        {
            Parameter[] parameters = i.getParameters();

            if(parameters.length>0)
            { int cont=0;
                text = text +"Constructor " ;
                for(Parameter j : parameters)
                {   cont++;

                    text = text + j.getType().toString().replace("class java.lang.","") +" " ;

                }
                text= text+"\n";

            }
            else {
                text = text +"Constructor " ;
                text = text + "void";
                text= text+"\n";}
            }

        Method[] methods = dataclass.getDeclaredMethods();

        if(methods.length>0)
        {
            for (Method i : methods) {
                Parameter[] parameters = i.getParameters();

                if(parameters.length==0)
                {
                  text = text + "Method " + i.getName() + " Void" ;
                }
                else
                {   text=text +"Method " + i.getName() + " ";
                    for(Parameter j : parameters)
                    {
                        text=text  + j.getType().toString().replace("class java.lang.","") ;
                    }
                }

                String retur = i.getReturnType().toString().replace("class java.lang.","");

                text = text+ " " + retur + "\n";


            }
        }

        return text;


        }


    }




