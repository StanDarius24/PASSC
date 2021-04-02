import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ExistingEntitiesClass implements Runnable{

    @Override
    public void run()
    {
        while(true) {

            execExistinglife();
        try {
            Thread.sleep(5000);
        }catch (Exception e) {e.printStackTrace();}
        }
    }

    public void execExistinglife() {
        String path = new String("C:/Users/Stannis/Desktop/Tema2/src/main/java/EntitiesThatLiveInUniverse");
        File directory = new File(path);


        Class noparams[] = {};
        File[] contents = directory.listFiles();
        String name = new String();
        for (File f : contents) {
            name = f.getName();
            if (name.contains(".class")) {
                name=name.replace(".class", "");
                try {

                    URLClassLoader loader = URLClassLoader.newInstance(new URL[]{new URL("file:" + directory  )});
                    Class c =loader.loadClass("EntitiesThatLiveInUniverse."+name);
                    Object obj = c.newInstance();

                    Method[] methods = c.getDeclaredMethods();
                    if(methods.length>0)
                    {
                        for (Method i : methods) {

                            if(Modifier.isPublic(i.getModifiers())){
                            System.out.println("Method: " + i.getName());


                            Parameter[] parameters = i.getParameters();

                            if(parameters.length==0)
                            {
                                Method method = c.getDeclaredMethod(i.getName(), noparams);
                                method.invoke(obj, null);
                            }
                            else
                                if(parameters.length==1)
                                {
                                    for(Parameter j : parameters)
                                    {

                                        if(j.getType().toString().equals("class java.lang.String"))
                                        {
                                            System.out.println("a intrat");

                                            Object[] stringArgs = new Object[] { new String("Darius")};
                                            Method method = c.getDeclaredMethod(i.getName(), String.class);
                                            method.invoke(obj,stringArgs);
                                        }
                                    }
                                }
                            }
                        }


                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
