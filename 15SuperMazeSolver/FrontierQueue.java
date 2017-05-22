import java.util.*;

public class FrontierQueue implements Frontier{
    
    private ArrayDeque<Location> dq;

    public FrontierQueue(){
        dq = new ArrayDeque<Location>();
    }

    public void add(Location l){
        dq.add(l);
    }

    public Location next(){
        return dq.remove();
    }

    public int size(){
        return dq.size();
    }

    public String toString(){
        return dq.toString();
    }
    
}
