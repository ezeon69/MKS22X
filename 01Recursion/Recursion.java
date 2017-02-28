public class Recursion {

    public static String name(){
	return "Luo,Jiajun";
    }
    
    public static double sqrt(double n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	if (n == 0){
	    return n;
	}
	return guess(1, n);
    }
   
    private static double guess(double g, double old){
	if (Math.abs((g*g - old)/old) < 0.0000000001){
	    return g;
	}
        double better_guess = (old / g + g) / 2;
	return guess(better_guess, old);	
    }
}
