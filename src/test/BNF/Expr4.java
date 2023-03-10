package test.BNF;
import parser.Token;
import java.util.ArrayList;
import java.util.Iterator;

public class Expr4 extends BNF {
	public Expr4(ArrayList<Token> tokens) {
		super(tokens);
	}
	
	public ArrayList<String> genCode() {
		//tokens dump
		//printTokens();
		
		for(Iterator it = tokens.iterator(); it.hasNext();) {
			String s1 = it.next().toString();
			String s2 = null;

			switch(s1) {
			case "+":
				if(it.hasNext()) s2 = it.next().toString();
				codes.add("\tMOV #" + s2 + ", (R6)+ ;;; push right-num");
				
				codes.add("\tMOV -(R6), R0 ;;; pop left-num");
				codes.add("\tMOV -(R6), R1 ;;; pop right-num");
				codes.add("\tADD R1, R0 ;;;");
				codes.add("\tMOV R0, (R6)+ ;;; push result");
				break;
				
			case "-":
				if(it.hasNext()) s2 = it.next().toString();
				codes.add("\tMOV #" + s2 + ", (R6)+ ;;; push right-num");
				
				codes.add("\tMOV -(R6), R1 ;;; pop left-num");
				codes.add("\tMOV -(R6), R0 ;;; pop right-num");
				codes.add("\tSUB R1, R0 ;;;");
				codes.add("\tMOV R0, (R6)+ ;;; push result");
				break;
				
			default:
				codes.add("\tMOV #" + s1 + ", (R6)+ ;;;;;; push left-num");
			}
		}
		
		
		
		return codes;
	}
	
}
