import java.util.*;

public class MyLinkedList{
    
    private LNode start;
    private LNode end;
    private int size;
    
    public MyLinkedList(){
	size = 0;
        start = new LNode();
    }
    
    private class LNode{
        LNode prev;
        LNode next;
        int value;
	
	public LNode(){
	}
	
	public LNode(int val){
	    value = val;
	    next = null;
	}
	
	public LNode(int val, LNode nextNode){
	    value = val;
	    next = nextNode;
	}

	public String toString(){
	    return value + "";
	}
	
    }

    public int size(){
	return size;
    }
    
    private LNode getNthNode(int n){
	LNode current = start;
	for (int counter = 0; counter < n; counter++){
	    current = current.next;
	}
	return current;
    }

    private void addAfter(LNode location, LNode toBeAdded){

    }

    private void remove(LNode target){

    }

    public String toString(){
	String total = "[";
	LNode current = start;
	for (int counter = 0; counter < size(); counter++){
	    total += current.value;
	    current = current.next;
	}
	total += "]";
	return total;
    }

    public boolean add(int val){
	if (size == 0){
	    start = new LNode(val);
	    size++;
	}
	else{
	    end.next = new LNode(val);
	}
	size++;
	return true;
    }

    public int get(int index){
	return getNthNode(index).value;
    }

    public int set(int index, int newValue){
	LNode current = start;
	for (int counter = 0; counter < index; counter++){
	    current = current.next;
	}
        current.value = newValue;
	return current.value;
    }

    public int indexOf(int value){
	LNode current = start;
	for (int counter = 0; counter < size(); counter++){
	    current = current.next;
	    if (current.value == value){
		return counter;
	    }
	}
        return 0;
    }

    public int remove(int index){

    }

    public void add(int index,int value){

    }
    
}
