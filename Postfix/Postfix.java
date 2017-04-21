public class Postfix{

    private static String operators = "+*-/%";
    
    public boolean isOperator(char c){
        return operators.indexOf(c) != -1;
    }


}
