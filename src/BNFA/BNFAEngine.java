package BNFA;
import org.antlr.v4.runtime.tree.ParseTree;

public class BNFAEngine {
	ParseTree tree;
	String text;
	public BNFAEngine(ParseTree tree, String text) {
		this.tree = tree;
		this.text = text;
		// implement constructor
	}

	public MatchingResult run() {
		BNFAVisitor v = new BNFAVisitor();
		return v.start(tree, text);
		// to implement (replace dummy return)
	}
		

}
