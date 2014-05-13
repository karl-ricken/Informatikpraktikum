// Generated from Regex.g4 by ANTLR 4.1
package DFA;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RegexParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__3=1, T__2=2, T__1=3, T__0=4, VAR=5;
	public static final String[] tokenNames = {
		"<INVALID>", "')'", "'*'", "'('", "'|'", "VAR"
	};
	public static final int
		RULE_start = 0, RULE_ausdruck = 1, RULE_alternation = 2, RULE_konkatenation = 3, 
		RULE_kleenestern = 4, RULE_klammerung = 5, RULE_variable = 6;
	public static final String[] ruleNames = {
		"start", "ausdruck", "alternation", "konkatenation", "kleenestern", "klammerung", 
		"variable"
	};

	@Override
	public String getGrammarFileName() { return "Regex.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public RegexParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(RegexParser.EOF, 0); }
		public AusdruckContext ausdruck() {
			return getRuleContext(AusdruckContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexVisitor ) return ((RegexVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14); ausdruck();
			setState(15); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AusdruckContext extends ParserRuleContext {
		public AlternationContext alternation(int i) {
			return getRuleContext(AlternationContext.class,i);
		}
		public List<AlternationContext> alternation() {
			return getRuleContexts(AlternationContext.class);
		}
		public AusdruckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ausdruck; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexVisitor ) return ((RegexVisitor<? extends T>)visitor).visitAusdruck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AusdruckContext ausdruck() throws RecognitionException {
		AusdruckContext _localctx = new AusdruckContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_ausdruck);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3 || _la==VAR) {
				{
				{
				setState(17); alternation();
				}
				}
				setState(22);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlternationContext extends ParserRuleContext {
		public List<KonkatenationContext> konkatenation() {
			return getRuleContexts(KonkatenationContext.class);
		}
		public KonkatenationContext konkatenation(int i) {
			return getRuleContext(KonkatenationContext.class,i);
		}
		public AlternationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alternation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexVisitor ) return ((RegexVisitor<? extends T>)visitor).visitAlternation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlternationContext alternation() throws RecognitionException {
		AlternationContext _localctx = new AlternationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_alternation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); konkatenation();
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(24); match(4);
				setState(25); konkatenation();
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KonkatenationContext extends ParserRuleContext {
		public List<KlammerungContext> klammerung() {
			return getRuleContexts(KlammerungContext.class);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public KleenesternContext kleenestern(int i) {
			return getRuleContext(KleenesternContext.class,i);
		}
		public List<KleenesternContext> kleenestern() {
			return getRuleContexts(KleenesternContext.class);
		}
		public KlammerungContext klammerung(int i) {
			return getRuleContext(KlammerungContext.class,i);
		}
		public KonkatenationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_konkatenation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexVisitor ) return ((RegexVisitor<? extends T>)visitor).visitKonkatenation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KonkatenationContext konkatenation() throws RecognitionException {
		KonkatenationContext _localctx = new KonkatenationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_konkatenation);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(34); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					setState(34);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						setState(31); variable();
						}
						break;

					case 2:
						{
						setState(32); kleenestern();
						}
						break;

					case 3:
						{
						setState(33); klammerung();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(36); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KleenesternContext extends ParserRuleContext {
		public KlammerungContext klammerung() {
			return getRuleContext(KlammerungContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public KleenesternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kleenestern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexVisitor ) return ((RegexVisitor<? extends T>)visitor).visitKleenestern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KleenesternContext kleenestern() throws RecognitionException {
		KleenesternContext _localctx = new KleenesternContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_kleenestern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			switch (_input.LA(1)) {
			case VAR:
				{
				setState(38); variable();
				}
				break;
			case 3:
				{
				setState(39); klammerung();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(42); match(2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KlammerungContext extends ParserRuleContext {
		public AusdruckContext ausdruck() {
			return getRuleContext(AusdruckContext.class,0);
		}
		public KlammerungContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_klammerung; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexVisitor ) return ((RegexVisitor<? extends T>)visitor).visitKlammerung(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KlammerungContext klammerung() throws RecognitionException {
		KlammerungContext _localctx = new KlammerungContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_klammerung);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44); match(3);
			setState(45); ausdruck();
			setState(46); match(1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(RegexParser.VAR, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexVisitor ) return ((RegexVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); match(VAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\7\65\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\3\7\3\25\n"+
		"\3\f\3\16\3\30\13\3\3\4\3\4\3\4\7\4\35\n\4\f\4\16\4 \13\4\3\5\3\5\3\5"+
		"\6\5%\n\5\r\5\16\5&\3\6\3\6\5\6+\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\2\t\2\4\6\b\n\f\16\2\2\63\2\20\3\2\2\2\4\26\3\2\2\2\6\31\3\2\2\2\b"+
		"$\3\2\2\2\n*\3\2\2\2\f.\3\2\2\2\16\62\3\2\2\2\20\21\5\4\3\2\21\22\7\2"+
		"\2\3\22\3\3\2\2\2\23\25\5\6\4\2\24\23\3\2\2\2\25\30\3\2\2\2\26\24\3\2"+
		"\2\2\26\27\3\2\2\2\27\5\3\2\2\2\30\26\3\2\2\2\31\36\5\b\5\2\32\33\7\6"+
		"\2\2\33\35\5\b\5\2\34\32\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2"+
		"\2\37\7\3\2\2\2 \36\3\2\2\2!%\5\16\b\2\"%\5\n\6\2#%\5\f\7\2$!\3\2\2\2"+
		"$\"\3\2\2\2$#\3\2\2\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\t\3\2\2\2(+\5\16"+
		"\b\2)+\5\f\7\2*(\3\2\2\2*)\3\2\2\2+,\3\2\2\2,-\7\4\2\2-\13\3\2\2\2./\7"+
		"\5\2\2/\60\5\4\3\2\60\61\7\3\2\2\61\r\3\2\2\2\62\63\7\7\2\2\63\17\3\2"+
		"\2\2\7\26\36$&*";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}