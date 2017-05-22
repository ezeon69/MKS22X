import java.util.*;

import java.util.*;

public class FrontierStack implements Frontier{
    
    private Stack<Location> sk;

    public FrontierStack(){
        sk = new Stack<Location>();
    }

    public void add(Location l){
        sk.add(l);
    }

    public Location next(){
        return sk.pop();
    }

    public int size(){
        return sk.size();
    }

    public String toString(){
        return sk.toString();
    }
    
}
