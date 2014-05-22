package BNFA;

import java.util.Stack;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
public class BNFAVisitor extends RegexBaseVisitor<MatchingResult>{
	class Match{
		int index, length;
		public Match(int index, int length){
			this.index = index;
			this.length = length;
		}
	}
	
	class varInt {
		ParseTree knoten;
		int popPos;
		MatchingResult mr = null;
		
		public varInt(ParseTree var, int i){
			this.knoten = var;
			this.popPos = i;
		}
		public varInt(MatchingResult mr){
			this.mr = mr;
		}
	}
	Match match;
	public Stack<varInt> stack = new Stack<>();
	public String Text;
	public ParseTree tree;
	public String currentChar;
	public int index = -1;
	public int pos = 0;
	private void setChar(){
		if(index<Text.length()-1){
			index ++;
			currentChar = "" + Text.charAt(index);
		} else {
			index ++;
		}
	}
	private MatchingResult createMatch(int index, int length){
		return new MatchingResult(index, index>=0 ? Text.substring(index, index+length) : "");
	}
	public MatchingResult start(ParseTree ps, String text){
		this.Text = text;
		MatchingResult result = visit(ps);
		while(result == null && index<text.length()){
			if(stack.empty()){
				index = pos;
				pos++;
				result = start(ps,text);
			}else{
				varInt current = stack.pop();
				if(current.mr!=null){
					return current.mr;
				}
				index = current.popPos;
				currentChar = "" + Text.charAt(index);
				result = visit(current.knoten);
			}
		}
		if(result==null){
			return createMatch(-1,0);
		}
		return result;
	}
	public MatchingResult next(RegexParser.VariableContext vc){
		setChar();
		RuleContext rc = vc.parent;
		if(rc instanceof RegexParser.KleenesternContext){
			return visit(rc);
		}
		else {
			RegexParser.KonkatenationContext kc = (RegexParser.KonkatenationContext) rc;
			int nextIndex = kc.children.indexOf(vc)+1;
			if(kc.children.size()>nextIndex){
				return visit(kc.children.get(nextIndex));
			}
			else {
				RuleContext kcNew = kc;
				boolean bedingung = true;
				while(bedingung){
					RuleContext kcOld = kcNew;
					kcNew = kcNew.parent;
					while(!(kcNew instanceof RegexParser.KonkatenationContext) && !(kcNew instanceof RegexParser.StartContext) && !(kcNew instanceof RegexParser.KleenesternContext)){
						kcOld = kcNew;
						kcNew = kcNew.parent;
					}
					if(kcNew instanceof RegexParser.StartContext){
						return createMatch(pos,index-pos);
					} else if(kcNew instanceof RegexParser.KonkatenationContext){
						RegexParser.KonkatenationContext parent = (RegexParser.KonkatenationContext) kcNew;
						int i = parent.children.indexOf(kcOld)+1;
						if(parent.children.size()>i){
							return visit(parent.children.get(i));
						}
					} else if(kcNew instanceof RegexParser.KleenesternContext){
						return visit(kcNew);
					}
				}
			}
			return null;
		}
	}
	@Override public MatchingResult visitStart(@NotNull RegexParser.StartContext ctx) {
		setChar();
		
		return visit(ctx.alternation());
	}
	@Override public MatchingResult visitKlammerung(@NotNull RegexParser.KlammerungContext ctx) {
			return visit(ctx.alternation());
		}
	
	@Override public MatchingResult visitVariable(@NotNull RegexParser.VariableContext ctx) {
		if(ctx.VAR().getText().equals(currentChar)){
			return next(ctx);
		}else{
			return null;
		}
	}
	@Override public MatchingResult visitKonkatenation(@NotNull RegexParser.KonkatenationContext ctx) {
		
		return visit(ctx.getChild(0));
	}
	@Override public MatchingResult visitKleenestern(@NotNull RegexParser.KleenesternContext ctx) {
		MatchingResult result = null,result1;
		RegexParser.KonkatenationContext kc = (RegexParser.KonkatenationContext) ctx.parent;
		int nextIndex = kc.children.indexOf(ctx)+1;
		if(kc.children.size()>nextIndex){
			varInt current = new varInt(kc.children.get(nextIndex),index);
			stack.push(current);
		}
		else {
			RuleContext kcNew = kc;
			boolean bedingung = true;
			while(bedingung){
				RuleContext kcOld = kcNew;
				kcNew = kcNew.parent;
				while(!(kcNew instanceof RegexParser.KonkatenationContext) && !(kcNew instanceof RegexParser.StartContext)){
					kcOld = kcNew;
					kcNew = kcNew.parent;
				}
				if(kcNew instanceof RegexParser.StartContext){
					stack.push(new varInt(createMatch(pos,index-pos)));
					bedingung = false;
				} else if(kcNew instanceof RegexParser.KonkatenationContext){
					RegexParser.KonkatenationContext parent = (RegexParser.KonkatenationContext) kcNew;
					int i = parent.children.indexOf(kcOld)+1;
					if(parent.children.size()>i){
						varInt current = new varInt(parent.children.get(i),index);
						stack.push(current);
						bedingung = false;
					}
				}
			}
		}
		result1 = visit(ctx.getChild(0));
		if (result1 == null){
			return result;
		}else{
			return result1;
		}
	}
	@Override public MatchingResult visitAlternation(@NotNull RegexParser.AlternationContext ctx) {
		int kinder = ctx.getChildCount();
		for(int i = kinder-1; i>0; i--){
			varInt current = new varInt(ctx.getChild(i),index);
			stack.push(current);
		}
		
		return visit(ctx.getChild(0));
	}
}