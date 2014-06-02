package DFA;
import general.MatchingResult;

import org.antlr.v4.runtime.tree.ParseTree;

public class DFAEngine {
	ParseTree tree;
	String text;
	public DFAEngine(ParseTree tree, String text) {
		this.tree = tree;
		this.text = text;
		// implement constructor
	}

	public MatchingResult run() {
		DFAVisitor v = new DFAVisitor();
		return v.start(tree, text);
		// to implement (replace dummy return)
	}
		

}
