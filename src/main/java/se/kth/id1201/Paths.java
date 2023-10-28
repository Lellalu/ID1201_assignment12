package se.kth.id1201;

public class Paths {
    City[] path; 
    int sp;

    public Paths(){ 
        path = new City[54]; 
        sp = 0; 
    }

    public Integer shortest(City from, City to){ 
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
            Integer dist = shortest(conn.city, to);
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
        Map map = new Map(args[0]); 
        String from = args[1]; 
        String to = args[2]; 

        long t0 = System.nanoTime(); 
        Integer dist = new Paths().shortest(map.lookup(from), map.lookup(to)); 
        long time = (System.nanoTime()-t0)/1_000_000; 
        System.out.println("shortest:" + dist + " min(" + time + " ms)"); 
    }
}
