
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;


public class Main {
    public static void main(String[] args){
      /*  if(args.length<1)
        {
            System.out.println("No argument!");
            System.exit(1);
        } */



        File file = new File("C:/Users/Stannis/Desktop/Tema2/src/main/java/Dummy.jar");

        try{
            URLClassLoader loader = URLClassLoader.newInstance(new URL[] {new URL("jar:file:" + file + "!/")});

            JarInputStream stream =new JarInputStream(new FileInputStream(file));

            JarEntry entry;

            while ((entry = stream.getNextJarEntry()) != null)
            {
                if(entry.toString().endsWith(".class") )
                {
                    String name = entry.getName().substring(0,entry.getName().length()-6);



                    name=name.replace("/",".");




                    try {

                        Class c = loader.loadClass(name);


                        //TYPE
                        if(Modifier.isPublic(c.getModifiers()))
                            System.out.print("Public - ");
                        else
                        if(Modifier.isPrivate(c.getModifiers()))
                            System.out.print("Private - ");
                        else
                        if(Modifier.isProtected(c.getModifiers()))
                            System.out.print("Protected - ");
                        if(Modifier.isAbstract(c.getModifiers()))
                            System.out.print("Abstract - ");
                        else
                        if(Modifier.isInterface(c.getModifiers()))
                            System.out.print("Interface - ");
                        else
                        if(Modifier.isFinal(c.getModifiers()))
                            System.out.print("Final - ");
                        else
                        if(Modifier.isStatic(c.getModifiers()))
                            System.out.println("Static - ");


                       // SUPERCLASS
                        if(!Modifier.isInterface(c.getModifiers())) {
                            Class superClass = c.getSuperclass();
                            System.out.println(name + " extends " + superClass.getName());
                        }
                        else
                        {
                            System.out.println(name);
                        }

                        Field[] fields = c.getDeclaredFields();
                        if(fields.length>0) {
                            System.out.print("fields: ");
                            for (Field i : fields) {
                                System.out.print(i.getName() + " ");
                            }
                            System.out.println();
                        }

                        Method[] methods = c.getDeclaredMethods();

                        if(methods.length>0)
                        {
                            System.out.println("methods: ");
                            for(Method i : methods)
                            {
                                // visibility
                                if(Modifier.isPrivate(i.getModifiers()))
                                    System.out.print("Private ");
                                else
                                    if(Modifier.isPublic(i.getModifiers()))
                                        System.out.print("Public ");
                                    else
                                        if(Modifier.isProtected(i.getModifiers()))
                                            System.out.print("Protected ");
                                // type
                                if(Modifier.isAbstract(i.getModifiers()))
                                    System.out.print("Abstract ");
                                else
                                    if(Modifier.isStatic(i.getModifiers()))
                                        System.out.print("Static ");
                                    else
                                        if(Modifier.isFinal(i.getModifiers()))
                                            System.out.print("Final ");

                                System.out.print(i.getName());
                                        Parameter[] parameters = i.getParameters();

                                        if(parameters.length>0)
                                        { int cont=0;
                                            System.out.print("( ");

                                            for(Parameter j : parameters)
                                            {   cont++;
                                                System.out.print(j.getType()+ " " + j.getName() +" ");
                                                if(cont<parameters.length)
                                                    System.out.print(",");
                                            }
                                            System.out.println(" ) ");

                                        }
                                        else
                                            System.out.println("( void )");



                            }
                            System.out.println();
                        }




                    } catch (Exception e)
                    {
                        System.out.println("Class invalid");
                        System.exit(1);
                    }

                }
            }
            stream.close();

        }catch (Exception ex) {
            System.out.println("Invalid path given.");
            System.exit(1);
        }
















    }

}
