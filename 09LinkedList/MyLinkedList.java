import java.util.*;

public class MyLinkedList implements Iterable<Integer>{

    //instance variables
    private LNode start;
    private LNode end;
    private int size;

    //constructors
    public MyLinkedList(){
	size = 0;
        start = null;
	end = null;
    }

    public Iterator<Integer> iterator(){
        return new MyLinkedListIterator(this);
    }

    //LNode
    private class LNode{
        LNode prev;
        LNode next;
        int value;
	
	public LNode(int val){
	    prev = null;
	    this.value = val;
	    next = null;
	}
	
	public LNode(int val, LNode nextNode, LNode prevNode){
	    this.prev = prevNode;
	    this.value = val;
	    this.next = nextNode;
	}

	public String toString(){
	    return value + "";
	}	
    }

    //iterator

    private class MyLinkedListIterator implements Iterator<Integer>{

	private MyLinkedList list;
	private LNode current;

	public MyLinkedListIterator(MyLinkedList mll) {
            this.list = list;
            current = start;
        }

	public boolean hasNext(){
	    return currentNode != null;
	}

	public Integer next(){
	    if (hasNext()){
		int total = current.value;
		current = current.next;
		return total;
	    }
	    else{
		throw new NoSuchElementException();
	    }
	}

	public void remove(){
            throw new UnsupportedOperationException();
        }
    }
	
    //methods
    public int size(){
	return size;
    }
    
    private LNode getNthNode(int index){
	if ((index < 0) || (index >= size())){
	    throw new IndexOutOfBoundsException();
	}
	LNode current;
	int counter = 0;
        if (counter > size / 2){
	    current = end;
            counter = size - 1;
            while (counter > index) {
                current = current.prev;
                counter--;
            }
	}
	else{
	    current = start;
	    while (counter < index){
		current = current.next;
		counter++;
	    }
	}
	return current;
    }

    private void addAfter(LNode location, LNode toBeAdded){
	if (size == 0){
	    start = toBeAdded;
	    end = toBeAdded;
	}
	else if (location.next == null){
	    toBeAdded.prev = location;
            location.next = toBeAdded;
            end = location.next;
	}
	else{
            toBeAdded.prev = location;
            toBeAdded.next = location.next;
            location.next = toBeAdded;
            toBeAdded.next.prev = toBeAdded;
	}
	size++;
    }

    private void remove(LNode target){
	if (target.prev == null && target.next == null){
            start = null;
            end = null;
	}
	else if (target.prev == null){
            target.next.prev = null;
            head = target.next;
	}
	else if (target.next == null){
            target.prev.next = null;
            tail = target.prev;
        }
	else{
            target.prev.next = target.next;
            target.next.prev = target.prev;
        }
        size--;
    }

    public String toString(){
	String total = "[";
	LNode current = start;
        while (current != null) {
            if (current != start) {
                total += ", ";
            }
            total += current.toString(true);
            current = current.next;
        }
	total += "]";
	return total;
    }

    public boolean add(int val){
        addAfter(tail,new LNode(value));
	return true;
    }

    public int get(int index){
	if ((index < 0) || (index >= size())){
	    throw new IndexOutOfBoundsException();
	}
	return getNthNode(index).value;
    }

    public int set(int index, int newValue){
        if ((index < 0) || (index >= size())){
	    throw new IndexOutOfBoundsException();
	}
        LNode target = getNthNode(index);
	int total = target.value;
	target.value = newValue;
	return total;
    }

    public int indexOf(int value){
	LNode current = start;
	for (int counter = 0; counter < size; counter++){
	    if (current.value == value){
		return counter;
	    }
	    current = current.next;
	}	
        return -1;
    }

    public int remove(int index){
        LNode target = getNthNode(index);
	remove(target);
	return target.value;
    }

    public void add(int index,int value){
        if (index == size){
	    add(value);
	}
	else{
	    addBefore(getNthNode(index), new LNode(value));
	}
    }
}
	


