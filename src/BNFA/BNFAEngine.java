package BNFA;
import general.MatchingResult;

import org.antlr.v4.runtime.tree.ParseTree;

import BNFA.BNFAVisitor.VarInt;

public class BNFAEngine {
	ParseTree tree;
	String text;
	BNFAVisitor myVisitor;
	public BNFAEngine(ParseTree tree, String text) {
		this.tree = tree;
		this.text = text;
		myVisitor = new BNFAVisitor();
//		myVisitor.Text = text;
	}

	public MatchingResult run() {
		setChar();
		MatchingResult result = myVisitor.visit(tree);
		while(result == null && (myVisitor.index<text.length() || !myVisitor.stack.empty())){
			if(myVisitor.stack.empty()){
				result = runNext();
			}else{
				VarInt current = myVisitor.stack.pop();
				if(current.popPos>=text.length()){
					continue;
				}
				if(current.mr!=null && current.mr.getMatchedString().length()>0){
					return current.mr;
				}
				else if(current.mr!=null){
					continue;
				}
				myVisitor.index = current.popPos;
				myVisitor.currentChar = "" + text.charAt(myVisitor.index);
				result = myVisitor.visit(current.knoten);
			}
		}
		if(result==null){
			return createMatch(-1,0);
		}
		return result;
	}
	private void setChar(){
		if(myVisitor.index<text.length()-1){
			myVisitor.index ++;
			myVisitor.currentChar = "" + text.charAt(myVisitor.index);
		} else {
			myVisitor.index ++;
		}
	}
	
	public MatchingResult runNext(){
		myVisitor.index = myVisitor.pos;
		myVisitor.pos++;
		return run();
	}
	public MatchingResult createMatch(int index, int length){
		return new MatchingResult(index, index>=0 ? text.substring(index, index+length) : "");
	}
		

}
