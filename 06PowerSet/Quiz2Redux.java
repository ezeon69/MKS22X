import java.util.*;

public class Quiz2Redux{  
    /*Returns an ArrayList<String> that contains all subsets of the
     *characters of String s. Assume s has no duplicate characters.
     *the characters should appear in the same order that they occur 
     *in the original string.
     */
    
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	String finish = "";
	help(words,s,0,finish);
	Collections.sort(words);
	return words;
    }
  
    private static void help(ArrayList<String> words,String s, int pos, String finish){
        if (pos >= s.length()){
	    words.add(finish);      
	}
	else{
	    help(words,s,pos + 1,finish + s.charAt(pos));
	    pos++;
	    help(words,s,pos,finish);
	}
    }

    public static void main(String[]args){
	System.out.println(combinations("abcde"));
    }
}
