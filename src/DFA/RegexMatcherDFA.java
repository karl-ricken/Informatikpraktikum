package DFA;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class RegexMatcherDFA {
	
	public static void main (String[] args){
		if (args.length == 2) {
			match(args[0], args[1]).print();
		} else { // alt:match("(ab)*", "cababc").print();
			match("(ab)*abc", "cabababc").print();
		}	
	}
	
    public static MatchingResult match(String regex, String text) {
    	
    	ANTLRInputStream input = new ANTLRInputStream(regex);
        RegexLexer lexer = new RegexLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RegexParser parser = new RegexParser(tokens);
        ParseTree tree = parser.start(); // parse
        
        return new DFAEngine(tree, text).run();
        
    }
}
