package se.kth.id1201;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Map {
    HashMap cities;
    ArrayList<City> cityValue;
    private final int mod = 541;

    public Map(String file){
        cityValue = new ArrayList<City>();
        cities = new HashMap(mod);
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            String[] values;
            City cityA;
            City cityB;
            while((line = br.readLine()) != null){
                values = line.split(",");
                if(cities.containsKey(values[0])){
                    cityA = cities.get(values[0]);
                }else{
                    cityA = new City(values[0]);
                    cities.put(values[0], cityA);
                    cityValue.add(cityA);
                }

                if(cities.containsKey(values[1])){
                    cityB = cities.get(values[1]);
                }else{
                    cityB = new City(values[1]);
                    cities.put(values[1], cityB);
                    cityValue.add(cityB);
                }

                cityA.connect(cityB, Integer.valueOf(values[2]));
                cityB.connect(cityA, Integer.valueOf(values[2]));
            }
            //System.out.println(cities);
        cities.collisions();
        }catch(Exception e){
            System.out.println(e);
        }
    }


    public City lookup(String name){
        return cities.get(name);
    }
}
