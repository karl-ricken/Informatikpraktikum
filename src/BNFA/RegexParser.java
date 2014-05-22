// Generated from Regex.g4 by ANTLR 4.1
package BNFA;
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
		RULE_start = 0, RULE_alternation = 1, RULE_konkatenation = 2, RULE_kleenestern = 3, 
		RULE_klammerung = 4, RULE_variable = 5;
	public static final String[] ruleNames = {
		"start", "alternation", "konkatenation", "kleenestern", "klammerung", 
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
		public AlternationContext alternation() {
			return getRuleContext(AlternationContext.class,0);
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
			setState(12); alternation();
			setState(13); match(EOF);
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
		enterRule(_localctx, 2, RULE_alternation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15); konkatenation();
			setState(20);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(16); match(4);
				setState(17); konkatenation();
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
		enterRule(_localctx, 4, RULE_konkatenation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(26);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(23); variable();
					}
					break;

				case 2:
					{
					setState(24); kleenestern();
					}
					break;

				case 3:
					{
					setState(25); klammerung();
					}
					break;
				}
				}
				setState(28); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==3 || _la==VAR );
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
		enterRule(_localctx, 6, RULE_kleenestern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			switch (_input.LA(1)) {
			case VAR:
				{
				setState(30); variable();
				}
				break;
			case 3:
				{
				setState(31); klammerung();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(34); match(2);
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
		public AlternationContext alternation() {
			return getRuleContext(AlternationContext.class,0);
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
		enterRule(_localctx, 8, RULE_klammerung);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); match(3);
			setState(37); alternation();
			setState(38); match(1);
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
		enterRule(_localctx, 10, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40); match(VAR);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\7-\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\3\3\3\3\3\7\3\25\n\3"+
		"\f\3\16\3\30\13\3\3\4\3\4\3\4\6\4\35\n\4\r\4\16\4\36\3\5\3\5\5\5#\n\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\2\b\2\4\6\b\n\f\2\2+\2\16\3\2\2\2"+
		"\4\21\3\2\2\2\6\34\3\2\2\2\b\"\3\2\2\2\n&\3\2\2\2\f*\3\2\2\2\16\17\5\4"+
		"\3\2\17\20\7\2\2\3\20\3\3\2\2\2\21\26\5\6\4\2\22\23\7\6\2\2\23\25\5\6"+
		"\4\2\24\22\3\2\2\2\25\30\3\2\2\2\26\24\3\2\2\2\26\27\3\2\2\2\27\5\3\2"+
		"\2\2\30\26\3\2\2\2\31\35\5\f\7\2\32\35\5\b\5\2\33\35\5\n\6\2\34\31\3\2"+
		"\2\2\34\32\3\2\2\2\34\33\3\2\2\2\35\36\3\2\2\2\36\34\3\2\2\2\36\37\3\2"+
		"\2\2\37\7\3\2\2\2 #\5\f\7\2!#\5\n\6\2\" \3\2\2\2\"!\3\2\2\2#$\3\2\2\2"+
		"$%\7\4\2\2%\t\3\2\2\2&\'\7\5\2\2\'(\5\4\3\2()\7\3\2\2)\13\3\2\2\2*+\7"+
		"\7\2\2+\r\3\2\2\2\6\26\34\36\"";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}