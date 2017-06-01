import java.util.*;

public class StackCalc{

    private static String operators = "+*-/%";
    
    public static boolean isOp(String c){
        return operators.indexOf(c) != -1;
    }

    public static double eval(String s){
	String[] tokens = s.split(" ");
	Stack<Double> values = new Stack<Double>();
        for (int i = 0; i < tokens.length; i++){
	    if (isOp(tokens[i])){
		values.push(perform(tokens[i], values.pop(), values.pop()));
	    }
	    else{
		values.push(Double.parseDouble(tokens[i]));
	    }
	}
	return values.pop();
    } 
    
    private static double perform(String token, Double left, Double right){
	if (token.equals("+")){
	    return right + left;
	}
	if (token.equals("-")){
	    return right - left;
	}
	if(token.equals("*")){
	    return right * left;
	}
	if(token.equals("/")){
	    return right / left;
	}
	if(token.equals("%")){
	    return right % left;
	}
	else{
	    throw new IllegalArgumentException();}
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
