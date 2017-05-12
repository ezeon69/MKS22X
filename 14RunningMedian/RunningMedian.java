public class RunningMedian{

    public MyHeap left, right;

    public RunningMedian(){
	left = new MyHeap(true);
	right = new MyHeap(false);
    }

    public void add(int value){
	if (left.size() + right.size() == 0){
            left.add(value);
	}
	else if (value * 1.0 > getMedian()){
            right.add(value);
        }
	else{
            left.add(value);
        }

        if (right.size() >= left.size() + 2) {
            left.add(right.remove());
	}
	else if (left.size() >= right.size() + 2){
            right.add(left.remove());
        }
    }

    public double getMedian(){
        if (left.size() == right.size()){
            return (left.peek() + right.peek()) / 2.0;
        }
	else if (left.size() > right.size()){
            return left.peek();
        }
        return right.peek();
    }

}

    
