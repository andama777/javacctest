package test.BNF;
import parser.Token;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class BNF {
	protected ArrayList<Token> tokens = new ArrayList<Token>();
	protected ArrayList<String> codes = new ArrayList<String>();
	
	public BNF(ArrayList<Token> tokens) {
		this.tokens = tokens;
	}
	
	public void add(Token token) {
		tokens.add(token);
	}
	
	public String dump(String s) {
		StringBuffer sb = new StringBuffer();
		sb.append(";;; ");
		sb.append(s);
		return sb.toString();
	}
	public void printTokens() {
		for (Iterator it = tokens.iterator(); it.hasNext();) {
			System.out.println(dump(it.next().toString()));
		}
	}
	
	public abstract ArrayList<String> genCode();
}
