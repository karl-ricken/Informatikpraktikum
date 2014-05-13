package DFA;

public class StringInt {
	public int index;
	public String match;
	public boolean success;
	public int length;
	public StringInt(boolean b){
		this.success = b;
	}
	public StringInt(int index, String s){
		this.index = index;
		match = s;
	}
	public String toString(){
		if(match!=null){
			return match;
		}
		return "";
	}
}