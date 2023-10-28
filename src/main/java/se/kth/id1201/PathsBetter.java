package se.kth.id1201;
import java.util.ArrayList;

public class PathsBetter {
    City[] path; 
    int sp;

    public PathsBetter(){ 
        path = new City[54]; 
        sp = 0; 
    }

    public Integer shortest(City from, City to, Integer max){ 
        Integer shrt = null;
        if(from == to){
            return 0;
        } 
        for(int i = 0; i < sp; i++){
            if(path[i] == from) 
                return null; 
        } 
        path[sp++] = from;
        for(Connection conn : from.connections){
            if(max != null && conn.distance > max){
                continue;
            }
            Integer dist = shortest(conn.city, to, shrt);
            if(dist != null){
                if (shrt == null){
                    shrt = dist + conn.distance;
                }else{
                    if(dist + conn.distance < shrt){
                        shrt = dist + conn.distance;
                    }
                }
            }
        }
        path[sp--] = null; 
        return shrt;
    }

    public static void main(String[] args){ 
        benchmark(args[0]);
        /* 
        Map map = new Map(args[0]); 
        String from = args[1]; 
        String to = args[2]; 

        long t0 = System.nanoTime(); 
        Integer dist = new PathsBetter().shortest(map.lookup(from), map.lookup(to), null); 
        long time = (System.nanoTime()-t0)/1_000_000; 
        System.out.println("shortest:" + dist + " min(" + time + " ms)"); 
        */
    }

    public static void benchmark(String file){
        Map map = new Map(file); 
        ArrayList<City> cities = map.cityValue;
        String from = "Malmö"; 
        City fromCity = map.lookup(from);
        for(City city : cities){
            City toCity = city;
            long t0 = System.nanoTime(); 
            Integer dist = new PathsBetter().shortest(fromCity, toCity, null); 
            long time = (System.nanoTime()-t0)/1_000_000; 
            System.out.println("shortest path from Malmö to " + toCity.name + " is " + dist + " min(" + time + " ms)"); 
        }
    }
}
