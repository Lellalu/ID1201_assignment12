package se.kth.id1201;

import java.util.HashSet;

public class HashMap{
    public class Node{
        String name;
        City city;

        public Node(String name, City city){
            this.name = name;
            this.city = city;
        }
    }

    private Node[] data;
    private int size;

    public HashMap(int size){
        this.size = size;
        data = new Node[size];
    }

    private Integer hash(String name){
         int hash = 0; 
         for(int i = 0; i < name.length(); i++){ 
            hash = (hash * 31 % size) + name.charAt(i); 
        } 
        return hash % size; 
    }

    public void collisions(){
        HashSet<Integer> seen = new HashSet<Integer>();
        int index;
        int numCollision = 0;
        for(Node node : data){
            if(node == null){
                continue;
            }
            index = hash(node.name);
            if(seen.contains(index)){
                numCollision++;
            }else{
                seen.add(index);
            }
        }
    
        System.out.println("there are "+ numCollision + " collisions.");
    }


    public boolean containsKey(String name){
        int index = hash(name);
        for(int i = 0; i < size; i++){
            if(data[(index+i)%size] == null){
                return false;
            }

            if(data[(index+i)%size].name.equals(name)){
                return true;
            }
        }
        return false;
    }

    public City get(String name){
        int index = hash(name);
        for(int i = 0; i < size; i++){
            if(data[(index+i)%size].name.equals(name)){
                return data[(index+i)%size].city;
            }
        }
        return null;
    }

    public void put(String name, City city){
        int index = hash(name);
        for(int i = 0; i < size; i++){
            if(data[(index+i)%size] == null){
                data[(index+i)%size] = new Node(name, city);
                return;
            }

             if(data[(index+i)%size].name.equals(name)){
                data[(index+i)%size] = new Node(name, city);
                return;
             }
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            if(data[i] == null){
                sb.append(Integer.toString(i) + ": Empty" + '\n');
            }else{
                sb.append(Integer.toString(i) + ": " + data[i].name + '\n');
            }
        }
        return sb.toString();
    }
    
}
