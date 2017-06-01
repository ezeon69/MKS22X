public class RunningMedian{

    public MyHeap min, max;

    public RunningMedian(){
	min = new MyHeap(false);
	max = new MyHeap(true);
    }

    public void add(int value){
	if (min.size() == 0 && max.size() == 0){
            max.add(value);
	}
	else if ((double)value < getMedian()){
            max.add(value);
	    if (max.size() >= min.size() + 1) {
		min.add(max.remove());
	    }
	    else if (min.size() >= max.size() + 1){
		max.add(min.remove());
	    }
        }
	else{
            min.add(value);
	    if (max.size() >= min.size() + 1) {
		min.add(max.remove());
	    }
	    else if (min.size() >= max.size() + 1){
		max.add(min.remove());
	    }
        }
    }

    public double getMedian(){
        if (min.size() == max.size()){
            return (min.peek() + max.peek()) / 2.0;
        }
	else if (max.size() > min.size()){
            return max.peek();
        }
	else{
	    return min.peek();
	}
    }

}

    
