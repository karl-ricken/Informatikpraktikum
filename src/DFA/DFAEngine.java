package DFA;
import org.antlr.v4.runtime.tree.ParseTree;

public class DFAEngine {

	public DFAEngine(ParseTree tree, String text) {
		DFAVisitor dfa = new DFAVisitor();
		StringInt res = dfa.start(tree, text);
		if(res==null)	System.out.println("Jeffrey hat alles falsch gemacht!");
		System.out.println("Index: " + res.index + "; Lenght: " + res.length);
		// implement constructor
	}

	public MatchingResult run() {	
		// to implement (replace dummy return)
		return new MatchingResult(-1,"");
	}
		

}
