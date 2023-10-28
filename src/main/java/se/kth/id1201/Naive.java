package se.kth.id1201;

public class Naive {
    public static void main(String[] args){ 
        Map map = new Map(args[0]); 
        String from = args[1]; 
        String to = args[2]; 

        Integer max = Integer.valueOf(args[3]);
        long t0 = System.nanoTime(); 
        Integer dist = shortest(map.lookup(from), map.lookup(to), max); 
        long time = (System.nanoTime()-t0)/1_000_000; 
        System.out.println("shortest:" + dist + " min(" + time + " ms)"); 
    }

    public static Integer shortest(City from, City to, Integer max){
        if(max < 0){
            return null;
        }
        if(from == to){
            return 0;
        }
        Integer shrt = null;
        for(Connection conn : from.connections){
            Integer dist = shortest(conn.city, to, max-conn.distance);
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
        return shrt;
    }
}
