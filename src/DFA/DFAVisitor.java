package DFA;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

import DFA.RegexParser.KonkatenationContext;

public class DFAVisitor extends RegexBaseVisitor<StringInt>{
	/*ausdruck:	alternation*				;
	alternation:	konkatenation ('|' konkatenation)*	;
	konkatenation:	(VAR | kleenestern | klammerung)+	;
	kleenestern:	(VAR | klammerung)'*'			;
	klammerung:	'(' ausdruck ')'			;

	VAR:		[a-z]					;*/
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
//	Queue<RuleContext> warteschlange;
	private void setChar(){
		if(index<Text.length()-1){
			index ++;
			currentChar = "" + Text.charAt(index);
		}
	}
	public StringInt start(ParseTree ps, String text){
		this.Text = text;
		visit(ps);
		while(index<Text.length() && newSet.size()>0){
			execute();
		}
		if(match!=null){
			StringInt res = new StringInt(true);
			res.index = pos;
			res.length = index - pos;
			return res;
		}
		else {
			index = pos;
			pos++;
			if(index<Text.length()-2){
				return start(ps, text);
			} else {
				StringInt res = new StringInt(false);
				res.index = pos;
				res.length = index - pos;
				return res;
			}
		}
	}
	public StringInt execute(){
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
				RegexParser.KonkatenationContext kc = (KonkatenationContext) rc;
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
						while(!(kcNew instanceof RegexParser.KonkatenationContext) && !(kcNew instanceof RegexParser.StartContext)){
							kcOld = kcNew;
							kcNew = kcNew.parent;
						}
						if(kcNew instanceof RegexParser.StartContext){
							match = new Match(pos, index-pos);
							//TODO Match gefunden/generieren!
							bedingung = false;
						} else if(kcNew instanceof RegexParser.KonkatenationContext){
							RegexParser.KonkatenationContext parent = (KonkatenationContext) kcNew;
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
		
		return null;
	}
	@Override public StringInt visitStart(@NotNull RegexParser.StartContext ctx) {
		setChar();
		visit(ctx.ausdruck());
//		execute();
		return null;
	}
	@Override public StringInt visitKlammerung(@NotNull RegexParser.KlammerungContext ctx) {
			return visit(ctx.ausdruck());
		}
	@Override public StringInt visitAusdruck(@NotNull RegexParser.AusdruckContext ctx) {
		for(RegexParser.AlternationContext o : ctx.alternation()){
			visit(o);
		}
		return null;
	}
	@Override public StringInt visitVariable(@NotNull RegexParser.VariableContext ctx) {
		if(ctx.VAR().getText().equals(currentChar)){
			newSet.add(ctx);
		}
		return null;
	}
	@Override public StringInt visitKonkatenation(@NotNull RegexParser.KonkatenationContext ctx) {
		visit(ctx.getChild(0));
		return null;
	}
	@Override public StringInt visitKleenestern(@NotNull RegexParser.KleenesternContext ctx) {
		visit(ctx.getChild(0));
		RegexParser.KonkatenationContext kc = (KonkatenationContext) ctx.parent;
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
					//TODO Match gefunden/generieren!
					bedingung = false;
				} else if(kcNew instanceof RegexParser.KonkatenationContext){
					RegexParser.KonkatenationContext parent = (KonkatenationContext) kcNew;
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
	@Override public StringInt visitAlternation(@NotNull RegexParser.AlternationContext ctx) {
		for(RegexParser.KonkatenationContext o : ctx.konkatenation()){
			visit(o);
		}
		return null;
	}
}