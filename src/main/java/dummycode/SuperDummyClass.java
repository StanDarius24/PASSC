package dummycode;

import java.util.ArrayList;

public class SuperDummyClass implements DummyInterface{

    ArrayList<String> names;

    public SuperDummyClass(ArrayList<String> newNames)
    {
        names = new ArrayList<>();
        names = newNames;
    }

    public void addString(String name)
    {
        names.add(name);
    }

    public void calculate(String path){
        System.out.println(names.toString());
    }
    public boolean containNames(String text){
        return names.contains(text);
    }
    public String toString(){
        return names.toString();
    }
}
