package se.kth.id1201;

import java.util.ArrayList;

public class City {
    String name;
    ArrayList<Connection> connections;

    public City(String name){
        this.name = name;
        this.connections = new ArrayList<Connection>();

    }

    public void connect(City next, int distance){
        this.connections.add(new Connection(next, distance));
    } 
}
