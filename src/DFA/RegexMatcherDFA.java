package DFA;

import general.MatchingResult;
import general.RegexLexer;
import general.RegexParser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class RegexMatcherDFA {
	
	public static void main (String[] args){
		if (args.length == 2) {
			match(args[0], args[1]).print();
		} else {
			match("a", "a").print();
//			match("(abc|acb|acd|acda)", "abbacdacf").print();
//			match("(ab)*abc", "bbbabababababababababababababcabab").print();
//			match("(ab)*c", "cabc").print();
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
