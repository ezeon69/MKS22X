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

    public boolean hasNext(){
	return dq.size() != 0;
    }
    
}
