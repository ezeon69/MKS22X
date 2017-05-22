import java.util.*;

public class FrontierPriorityQueue implements Frontier{

    private MyHeap h;

    public FrontierPriorityQueue(){
	h = new MyHeap();
    }

    public void add(Location l){
        h.add(l);
    }

    public Location next(){
        return h.remove();
    }

    public int size(){
        return h.size();
    }

    public String toString(){
        return h.toString();
    }
    
}
