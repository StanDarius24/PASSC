import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Serialize {
    public String serializa()
    {   String text = new String();
        JSONObject d;
        JSONParser jsonParser = new JSONParser();

        try {
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("C:/Users/Stannis/Desktop/Tema2/src/main/resources/data.json"));
            JSONArray constructor = (JSONArray) jsonObject.get("constructor");

            //FIELDS
            JSONArray fields = (JSONArray) jsonObject.get("fields");
            for(int i=0;i<fields.size();i++) {
                d = (JSONObject) fields.get(i);
                String name =calc(d.toString(),"Name\"");
                String type = calc(d.toString(),"Type\"");
                text = text + "Field " +type +" " +name +"\n";
            }

            //CONSTRUCTORS
            for(int i=0;i<constructor.size();i++) {
                d = (JSONObject) constructor.get(i);
                if(d.toString().contains("noarg"))
                    text = text + "Constructor void\n";
                else
                    if(d.toString().contains("1arg"))
                    {
                        String text1 = d.toString();
                        String st1;
                        while(text1!=null)
                        {
                           st1=calc(text1,"Type\"");
                           if(st1!=null)
                           text = text+ "Constructor"+ " "+ st1 +"\n";
                            else
                                break;
                            int x = text1.indexOf(st1);
                            if(x==0)
                                text1=null;
                            else
                            text1=text1.substring(x+st1.length());
                        }
                    }
                    else
                        if(d.toString().contains("2arg"))
                        {
                            String text1 = d.toString();
                            String st1,st2;
                            while(text1!=null)
                            {
                                st1=calc(text1,"Type2\"");
                                st2=calc(text1,"Type1\"");
                                if(st1!=null && st2!=null)
                                    text = text+ "Constructor"+ " "+ st2 +" "+ st1 +"\n";
                                else
                                    break;
                                int x = text1.indexOf(st2);
                                if(x==0)
                                    text1=null;
                                else
                                    text1=text1.substring(x+st2.length());

                            }
                        }
            }



            JSONArray methods = (JSONArray) jsonObject.get("methods");

            for(int i=0;i<methods.size();i++) {
                d = (JSONObject) methods.get(i);
                String text1 = d.toString();
                int dis = text1.indexOf("1arg");
                int dis2 = text1.indexOf("]");
                text1=text1.substring(dis,dis2);

                String tx1,tx2,tx3;
                while(text1!=null)
                {
                    tx1=calc(text1,"Return\"");
                    tx2=calc(text1,"Name\"");
                    tx3=calc(text1,"TypeArg\"");



                    if(tx1!=null && tx2!=null)
                        text = text+ "Method"+ " "+ tx2 +" "+ tx1 +" "+tx3 +"\n";
                    else
                        break;
                    int x = text1.indexOf(tx2);
                    if(x==0)
                        text1=null;
                    else
                        text1=text1.substring(x+tx2.length());
                }

                text1 = d.toString();

                dis = text1.indexOf("noarg");
                text1=text1.substring(dis);
                dis2 = text1.indexOf("]");
                text1=text1.substring(0,dis2);


                while(text1!=null)
                {
                    tx1=calc(text1,"Return\"");
                    tx2=calc(text1,"Name\"");


                    if(tx1!=null && tx2!=null)
                        text = text+ "Method"+ " "+ tx2 +" "+ tx1  +"\n";
                    else
                        break;
                    int x = text1.indexOf(tx2);
                    if(x==0)
                        text1=null;
                    else
                        text1=text1.substring(x+tx2.length());
                }




            }




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return text;
    }

    private String calc(String text1,String type) {
        int x = text1.indexOf(type);
        if(x==-1)
            return null;
        text1 = text1.substring(x+type.length()+2);
        x = text1.indexOf("\"");
        return text1.substring(0,x);
    }

}
