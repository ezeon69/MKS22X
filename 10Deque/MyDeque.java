import java.util.*;

public class MyDeque{

    private String[] data;
    private int size;
    private int front;
    private int back;
    
    public MyDeque(){
	data = new String[10];
	size = 0;
	front = 0;
	back = 0;
    }
    
    public void addFirst(String s){
	if (s == null){
	    throw new NullPointerException();
	}
	if (size == data.length) {
	    expand();
	}
        if (size == 0){
	}
	else if (front == 0){
	    front = data.length - 1;
	}
	else{
	    front = -1;
	}
	data[front] = s;
	size++;
    }

    public void addLast(String s){
	if (s == null){
	    throw new NullPointerException();
	}
	if (size == data.length){
	    expand();
	}
        if(size == 0){
	}
	else if (back == data.length - 1){
	    back = 0;
	}
	else{
	    back++;
	}
	data[back] = s;
	size++;
    }

    public String removeFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	String total = data[front];
	data[front] = null;
        if ((front == data.length - 1) || (size == 1)){
	    front = 0;
	}
        else{
	    front++;
	}
	size--;
	return total;
    }

    public String removeLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	String total = data[back];
	data[back] = null;
        if (back == 0){
	    back = data.length - 1;
	}
	else if (size == 1){
	    back = 0;
	}
	else{
	    back--;
	}
	size--;
	return total;
    }

    public String getFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return data[front];
    }

    public String getLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return data[back];
    }

    public void expand(){
	String[] newAry = new String[data.length * 2];
        for (int i = 0,  j = front; j < (front + size); i++, j++){
	    newAry[j] = data[i % data.length];
	}
	data = newAry;
	front = 0;
	back = size - 1;
    }
    
}

    
