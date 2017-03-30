public class MyLinkedList{
    
    private LNode start;
    private LNode end;
    private int size;
    
    public LinkedList(){
	size = 0;
	LNode start = null;
    }
    
    private boolean add(int value){
	LNode current = start;
	
	for(int counter = 0; counter < LNode.size(), counter++;){
	    current.get(counter) = current.get(counter-1);
	}
	current[0] = value;
	start = current;
	size++;
	return true;
    }
    
    private int size(){
	return size;
    }
    
    public class LNode{
	
	public LNode(int value){
	    start = value;
	}
	
	public LNode(int value, LNode next){
	    start = value;
	    next = start.next;
	}
	
    }
}
