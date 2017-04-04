public class MyLinkedList{
    
    private LNode start;
    private LNode end;
    private int size;
    
    public MyLinkedList(){
	size = 0;
        start = new LNode();
    }
    
    public class LNode{
	private LNode next;
	private int value;
	
	public LNode(){
	}
	
	public LNode(int val){
	    value = val;
	    next = null;
	}
	
	public LNode(int val, LNode next){
	    value = val;
	    next = nextNode;
	}
	
    }
    private boolean add(int val){
	if (size == 0){
	    start = new LNode(val);
	    size++;
	}
	else{
	    end.next = LNode(val);
	}
	size++;
	return true;
    }
    
    private int size(){
	return size;
    }

    private int get(int index){
	for (counter = 0; counter < index; counter++){
	    Lnode current = start;
	    current = current.next;
	}
	return current.value;
    }

    private int set(int index, int newValue){
	for (counter = 0; counter < index; counter++){
	    Lnode current = start;
	    current = current.next;
	}
        current.value = newValue;
	return current.value;
    }
}
