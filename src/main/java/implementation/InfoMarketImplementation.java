package implementation;


import interfaces.InfoMarket;

public class InfoMarketImplementation implements InfoMarket {


    @Override
    public String getRoadInfo(int road) {
        if(road == 1 )
            return "Ploua";
        else if(road == 2)
            return "Ninge";
        else
            return "Soare";
    }

    @Override
    public float getTemp(String city) {
        if(city.equals("Timisoara"))
            return 12.2f;
        else if(city.equals("Caransebes"))
            return 22.4f;
        else
            return 14.5f;
    }
}
