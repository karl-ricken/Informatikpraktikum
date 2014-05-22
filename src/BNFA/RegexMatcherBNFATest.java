package BNFA;
import static org.junit.Assert.*;

import org.junit.Test;

public class RegexMatcherBNFATest {

	private void check(String regex, String text, int correctStartingPosition, String correctMatchedString){
		MatchingResult calculatedResult = RegexMatcherBNFA.match(regex, text);
		boolean c1 = (calculatedResult.getStartingPosition() == correctStartingPosition);
		boolean c2 = calculatedResult.getMatchedString().equals(correctMatchedString);
		assertTrue(c1 && c2);
	}
	
	@Test public void noMatch() {check("a", "b", -1, "");} // This means that your program should return a MatchingResultForBNFAEngine with startingPosition -1, if there is no match. 

	@Test public void t01() {check("a", "a", 0, "a");}
	@Test public void t02() {check("1", "1", 0, "1");}
	@Test public void t03() {check("b", "baa", 0, "b");}
	@Test public void t04() {check("b", "aba", 1, "b");}
	@Test public void t05() {check("b", "aab", 2, "b");}
	@Test public void t06() {check("ab", "baba", 1, "ab");}
	@Test public void t07() {check("(ab)a", "baba", 1, "aba");}
	@Test public void t08() {check("aba", "babab", 1, "aba");}
	@Test public void t09() {check("c", "a", -1, "");}
	
	@Test public void t10() {check("(ab)*", "cababc", 1, "abab");}
	@Test public void t11() {check("(ab)*", "cabababc", 1, "ababab");}
	@Test public void t12() {check("(ab)*", "cabababc", 1, "ababab");}
	@Test public void t13() {check("(ab)*c", "cabc", 0, "c");}
	@Test public void t14() {check("(ab)*c", "ababc", 0, "ababc");}
	
	@Test public void t15() {check("a|b", "a", 0, "a");}
	@Test public void t16() {check("a|b", "b", 0, "b");}
	@Test public void t17() {check("a|b|c", "c", 0, "c");}
	@Test public void t18() {check("(a|b)|c", "c", 0, "c");}
	@Test public void t19() {check("(ab|cd)", "kab", 1, "ab");}
	@Test public void t20() {check("(ab|cd)", "kcd", 1, "cd");}
	@Test public void t21() {check("(ab|cd)", "a", -1, "");}

	@Test public void t22() {check("(ab|cd)*", "zzababcdcdzz", 2, "ababcdcd");}
	@Test public void t23() {check("(ab|cd)*", "zzabcdabcdzz", 2, "abcdabcd");}
	@Test public void t24() {check("k(ab|cd)*", "zkabcdabcdmz", 1, "kabcdabcd");}
	@Test public void t25() {check("k(ab|cd)*m", "zkabcdabcdmz", 1, "kabcdabcdm");}
	
	@Test public void t26() {check("(ab|c*d)*", "zzzababcdccdabccccd", 3, "ababcdccdabccccd");}
	
	//	Write also your own unit tests here
	
}
