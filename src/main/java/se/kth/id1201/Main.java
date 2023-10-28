package se.kth.id1201;

import java.util.ArrayList;

public class Main 
{
    public static void main(String[] args){
        Map map = new Map(args[0]); 
        String from = args[1];
        City fromCity = map.lookup(from);
        benchmarkNaive(map.cityValue, fromCity);
        benchmarkPaths(map.cityValue, fromCity);
        benchmarkPathsBetter(map.cityValue, fromCity);

    }


    public static void benchmarkPathsBetter(ArrayList<City> cities, City fromCity){
        PathsBetter pathsBetter = new PathsBetter();
        System.out.println("PathsBetter");
        System.out.println("***************************************");
        for(City toCity : cities){
            long t0 = System.nanoTime(); 
            Integer dist = pathsBetter.shortest(fromCity, toCity, null); 
            long time = (System.nanoTime()-t0)/1_000_000; 
            System.out.println("shortest path from "+ fromCity.name + " to "+ toCity.name + " is " + dist + " min(" + time + " ms)"); 
        }
        System.out.println("***************************************");
        System.out.println();
    }

    public static void benchmarkPaths(ArrayList<City> cities, City fromCity){
        Paths paths = new Paths();
        System.out.println("Paths");
        System.out.println("***************************************");
        for(City toCity : cities){
            long t0 = System.nanoTime(); 
            Integer dist = paths.shortest(fromCity, toCity); 
            long time = (System.nanoTime()-t0)/1_000_000; 
            System.out.println("shortest path from "+ fromCity.name + " to "+ toCity.name + " is " + dist + " min(" + time + " ms)"); 
        }
        System.out.println("***************************************");
        System.out.println();
    }

    public static void benchmarkNaive(ArrayList<City> cities, City fromCity){
        System.out.println("Naive");
        System.out.println("***************************************");
        for(City toCity : cities){
            long t0 = System.nanoTime(); 
            Integer dist = Naive.shortest(fromCity, toCity, 800); 
            long time = (System.nanoTime()-t0)/1_000_000; 
            System.out.println("shortest path from "+ fromCity.name + " to " + toCity.name + " is " + dist + " min(" + time + " ms)"); 
        }
        System.out.println("***************************************");
        System.out.println();
    }
}
