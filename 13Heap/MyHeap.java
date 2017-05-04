import java.util.*;

public class MyHeap{
    
    private List<String> data;
    private int size;
    private int max;
    
    public MyHeap(){
	data = new List<String>;
	size = 0;
	max = 1;
    }

    public MyHeap(boolean t){
	if (t){
	    new MyHeap();
	}
	else{
	    data = new List<String>;
	    size = 0;
	    max = 0;
	}
    }
    
    public int size(){
	return size;
    }
    
    public void add(String s){
	data.add(s);
	size++;
	pushUp();
    }

    public String remove(){
	String total = peek();
	data[0] = data[size];
	data[size] = null;
	size--;
	pushDown();
	return total;
    }

    public String peek(){
	return data[0];
    }

    private void pushUp(){
	
    }

    private void pushDown(){
	
    }


}
