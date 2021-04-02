import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class TeleportedEntities implements Runnable{

    @Override
    public void run() {
        newFolder();
    }

    private void newFolder() {

        String path = new String("C:/Users/Stannis/Desktop/Tema2/src/main/java/NewEntity");
        File directory = new File(path);
        File[] contents = directory.listFiles();
        String name = new String();
        Class<?>[] paramtypes = new Class[] {};

        for (File f : contents) {
            System.out.println();
            name = f.getName().replace(".java","");

            if(f.canRead())
            {
                try{

                    Class<?> c = Class.forName("NewEntity." +name);

                    System.out.println(c.getName());

                    Method[] methods = c.getDeclaredMethods();

                    for(Method j : methods)
                    {
                        Method mt = c.getMethod(j.getName(),paramtypes);
                        Object something = c.newInstance();
                        mt.invoke(something, new Object[]{});
                    }

                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
