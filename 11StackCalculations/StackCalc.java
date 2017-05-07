import java.util.*;

public class StackCalc{

    private static String operators = "+*-/%";
    
    public static boolean isOp(String c){
        return operators.indexOf(c) != -1;
    }

    public static double eval(String s){
	String[] tokens = s.split(" ");
	Stack<Double> values = new Stack<Double>();
	for(String token : tokens){
	    if(isOp(token)){
		values.push(perform(token,values.pop(),values.pop()));
	    }
	    else{
		values.push(Double.parseDouble(token));
	    }
	} 
	return values.pop();
    }
    
    public static double perform(String token, double left, double right){
	if (token.equals("+")){
	    return (left + right);
	}
	else if (token.equals("-")){
	    return (left - right);
	}
	else if (token.equals("+")){
	    return (left * right);
	}
	else if (token.equals("+")){
	    return (left / right);
	}
	else{
	    return (left % right);
	}
    }
    public static void main(String[] args){
	System.out.println(StackCalc.eval("10 2 +"));//12.0
	System.out.println(StackCalc.eval("10 2 -"));//8.0
	System.out.println(StackCalc.eval("10 2.0 +"));//12.0
	System.out.println(StackCalc.eval("11 3 - 4 + 2.5 *"));//30.0
	System.out.println(StackCalc.eval("8 2 + 99 9 - * 2 + 9 -"));//893.0
	System.out.println(StackCalc.eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -"));//104.0
    }
}