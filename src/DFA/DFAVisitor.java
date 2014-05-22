package DFA;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
public class DFAVisitor extends RegexBaseVisitor<MatchingResult>{
	class Match{
		int index, length;
		public Match(int index, int length){
			this.index = index;
			this.length = length;
		}
	}
	Match match;
	public Set<RegexParser.VariableContext> currentSet = new HashSet<RegexParser.VariableContext>();
	public Set<RegexParser.VariableContext> newSet = new HashSet<RegexParser.VariableContext>();
	public String Text;
	public ParseTree tree;
	public String currentChar;
	public int index = -1;
	public int pos = 0;
	public boolean first = true;
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
		visit(ps);
		while(index<Text.length() && newSet.size()>0){
			execute();
		}
		if(match!=null){
			return createMatch(match.index, match.length);
		}
		else {
			index = pos;
			pos++;
			if(index<Text.length()-1){
				return start(ps, text);
			} else {
				return createMatch(-1,0);
			}
		}
	}
	public void execute(){
		currentSet.clear();
		currentSet.addAll(newSet);
		newSet.clear();
		setChar();
		for(RegexParser.VariableContext vc : currentSet){
			RuleContext rc = vc.parent;
			if(rc instanceof RegexParser.KleenesternContext){
				visit(rc);
			}
			else {
				RegexParser.KonkatenationContext kc = (RegexParser.KonkatenationContext) rc;
				int nextIndex = kc.children.indexOf(vc)+1;
				if(kc.children.size()>nextIndex){
					visit(kc.children.get(nextIndex));
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
							match = new Match(pos, index-pos);
							bedingung = false;
						} else if(kcNew instanceof RegexParser.KonkatenationContext){
							RegexParser.KonkatenationContext parent = (RegexParser.KonkatenationContext) kcNew;
							int i = parent.children.indexOf(kcOld)+1;
							if(parent.children.size()>i){
								visit(parent.children.get(i));
								bedingung = false;
							}
						} else if(kcNew instanceof RegexParser.KleenesternContext){
							visit(kcNew);
							bedingung = false;
						}
					}
				}
			}
		}
	}
	@Override public MatchingResult visitStart(@NotNull RegexParser.StartContext ctx) {
		setChar();
		visit(ctx.alternation());
		return null;
	}
	@Override public MatchingResult visitKlammerung(@NotNull RegexParser.KlammerungContext ctx) {
			return visit(ctx.alternation());
		}
	
	@Override public MatchingResult visitVariable(@NotNull RegexParser.VariableContext ctx) {
		if(ctx.VAR().getText().equals(currentChar)){
			newSet.add(ctx);
		}
		return null;
	}
	@Override public MatchingResult visitKonkatenation(@NotNull RegexParser.KonkatenationContext ctx) {
		visit(ctx.getChild(0));
		return null;
	}
	@Override public MatchingResult visitKleenestern(@NotNull RegexParser.KleenesternContext ctx) {
		visit(ctx.getChild(0));
		RegexParser.KonkatenationContext kc = (RegexParser.KonkatenationContext) ctx.parent;
		int nextIndex = kc.children.indexOf(ctx)+1;
		if(kc.children.size()>nextIndex){
			visit(kc.children.get(nextIndex));
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
					match = new Match(pos, index-pos);
					bedingung = false;
				} else if(kcNew instanceof RegexParser.KonkatenationContext){
					RegexParser.KonkatenationContext parent = (RegexParser.KonkatenationContext) kcNew;
					int i = parent.children.indexOf(kcOld)+1;
					if(parent.children.size()>i){
						visit(parent.children.get(i));
						bedingung = false;
					}
				}
			}
		}
		return null;
	}
	@Override public MatchingResult visitAlternation(@NotNull RegexParser.AlternationContext ctx) {
		for(RegexParser.KonkatenationContext o : ctx.konkatenation()){
			visit(o);
		}
		return null;
	}
}