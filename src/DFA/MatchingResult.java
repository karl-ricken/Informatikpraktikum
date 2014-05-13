package DFA;
public class MatchingResult {

	private int startingPosition;
	private String matchedString;

	public MatchingResult(int i, String s) {
		startingPosition = i;
		matchedString = s;
	}

	public int getStartingPosition() {
		return startingPosition;
	}

	public String getMatchedString() {
		return matchedString;
	}

	public void print() {
		if (startingPosition == -1) {
			System.out.println("There is no match!");
		} else {
			System.out.println("Matching position: " + startingPosition);
			System.out.println("Matched substring: " + matchedString);
		}
	}

}