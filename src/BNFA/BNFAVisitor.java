package BNFA;

import general.MatchingResult;
import general.RegexBaseVisitor;
import general.RegexParser;

import java.util.HashMap;
import java.util.Stack;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
public class BNFAVisitor extends RegexBaseVisitor<MatchingResult>{
	HashMap<RuleContext, Integer> list = new HashMap<RuleContext, Integer>();
	class VarInt {
		ParseTree knoten;
		int popPos;
		MatchingResult mr = null;
		
		public VarInt(ParseTree var, int i){
			this.knoten = var;
			this.popPos = i;
		}
		public VarInt(MatchingResult mr){
			this.mr = mr;
		}
	}
	public Stack<VarInt> stack = new Stack<VarInt>();
//	public String Text;
	public String currentChar;
	public int index = -1;
	public int pos = 0;
	public boolean directionUp = false;
	
	@Override public MatchingResult visitStart(@NotNull RegexParser.StartContext ctx) {
		return visit(ctx.alternation());
	}
	@Override public MatchingResult visitKlammerung(@NotNull RegexParser.KlammerungContext ctx) {
		if(directionUp){
			return visit(ctx.parent);
		}else{
			return visit(ctx.alternation());
		}
	}
	
	@Override public MatchingResult visitVariable(@NotNull RegexParser.VariableContext ctx) {
		if(ctx.VAR().getText().equals(currentChar)){
			directionUp = true;
			return visit(ctx.parent);
		}else{
			return null;
		}
	}

	@Override public MatchingResult visitKonkatenation(@NotNull RegexParser.KonkatenationContext ctx) {
		if (directionUp){
			int i = list.get(ctx);
			list.put(ctx,i+1);
			if(i+1<ctx.children.size()){
				directionUp =false;
				return visit(ctx.getChild(i+1));
			}else{
				return visit(ctx.parent);
			}
		}else{
			list.put(ctx, 0);
			return visit(ctx.getChild(0));
		}
	}
	
	@Override public MatchingResult visitKleenestern(@NotNull RegexParser.KleenesternContext ctx) {
		stack.push(new VarInt(ctx.parent,index));
		return visit(ctx.getChild(0));
	}
	
	@Override public MatchingResult visitAlternation(@NotNull RegexParser.AlternationContext ctx) {
		if(directionUp){
			return visit(ctx.parent);
		}else{
			int kinder = ctx.getChildCount();
			for(int i = kinder-1; i>0; i--){
				VarInt current = new VarInt(ctx.getChild(i),index);
				stack.push(current);
			}
			
			return visit(ctx.getChild(0));
		}
		
	}
}