package Generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;

public class ProxyGenerator {
    public static void generateFile(String name)
    {
       try{
           String clname = name + "ClientProxy";
           System.out.println("src/main/java/Proxys/" +clname +".java");
           File f = new File("src/main/java/Proxys/" +clname +".java" );
           FileWriter fw = new FileWriter(f);
           BufferedWriter buf = new BufferedWriter(fw);

           /*
           package Proxys;
           import java.io.Serializable;
           import Commons.Address;
           import MessageMarshaller.Marshaller;
           import MessageMarshaller.Reply;
           import MessageMarshaller.Request;
           import RequestReply.Request;
            */
           buf.write("package Proxys;\nimport java.io.Serializable;\nimport Commons.Address;\nimport MessageMarshaller.Marshaller;\nimport MessageMarshaller.Reply;\nimport MessageMarshaller.Request;\nimport RequestReply.Requestor;\n");
           buf.write("import interfaces." + name+";\n");
           buf.write("public class " + clname + " implements " +name+"\n");
           buf.write("{\nprivate String name;\nprivate Address address;\n");
           buf.write("public " + clname + "(String n, Address a) { name = n; address = a; }\n");

           Class<?> c = Class.forName("interfaces." +name);
           Method[] methods = c .getDeclaredMethods();

           for(Method m : methods)
           {
               String retType = m.getReturnType().getSimpleName();
               buf.write("public " + retType + " " + m.getName() +"(");
               Class<?> parameters[] = m.getParameterTypes();
               int i=0;
               for(Class<?> p : parameters)
               {
                   buf.write(p.getSimpleName());
                   buf.write(" arg" + i);
                   if(i != parameters.length-1)
                    buf.write(",");
                   i++;
               }
               buf.write(") {\n");

               buf.write("Serializable[] args = new Serializable[]{");
               i = 0;
               for (Class<?> p : parameters) {
                   buf.write(" arg"+i);
                   if (i!= parameters.length - 1)
                       buf.write(",");
                   i++;
               }
               buf.write("};\n");
               buf.write("Request msg = new Request(name, \"" + m.getName() +"\", args);\n");
               buf.write("Requestor r = new Requestor(name);\n");
               buf.write("byte[] repl = r.deliver_and_wait_feedback(address, Marshaller.marshal(msg));\n");
               buf.write("Reply rmsg = (Reply)Marshaller.unmarshalR(repl);\n");

               if (retType.equals("float"))
                   retType = "Float";
               else if (retType.equals("int"))
                   retType = "Integer";
               buf.write("return ("+ retType + ") rmsg.reply;\n");
               buf.write("}\n");

           }
            /*
            public classInfoMarketClientProxy implements InfoMarket
            {
            private String name;
            private Address address;
            public InfoMarketClientProxy(String n, Address a) { name = n; address = a; }
            public String getRoadInfo(int arg0) {
            public float getTemp(String arg0) {
             */
           buf.write("}\n");
           buf.close();

       } catch ( Exception e )
       {
           e.printStackTrace();
       }
    }
}
