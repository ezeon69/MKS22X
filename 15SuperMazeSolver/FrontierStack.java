import java.util.*;

import java.util.*;

public class FrontierStack implements Frontier{
    
    private Stack<Location> sk;

    public FrontierStack(){
        sk = new Stack<Location>();
    }

    public void add(Location l){
        sk.push(l);
    }

    public Location next(){
        return sk.pop();
    }

    public int size(){
        return sk.size();
    }

    public boolean hasNext(){
	return sk.size() != 0;
    }
    
}
