package Q4;

public class Q4 {
	public static void main(String[] args) {
		ReplaceString r = new ReplaceString("dsak dsfa dsfa", " ", "%20");
		System.out.println("The original string is: "+ r.getString());
		System.out.println("After the replacement the string is: "+ r.replace());
	}
	
}

class ReplaceString {
	private String string, replacee, replacer;
	public ReplaceString (String string, String str1, String str2) {
		this.string = string;
		this.replacee = str1;
		this.replacer = str2;
	}
	//public String replaceWithoutExtraSpace(char[] str) {//but it can only do 'space' to "%20"
		
	//}
	public String replace() { //by doing so what we return is a copy of the string
		String[] str = string.split(replacee);
		String replacestring = str[0];
		for (int i = 1; i< str.length; i++) {
			replacestring += "%20";
			replacestring += str[i];
		}
		return replacestring;
	}
	public void setString(String string) {
		this.string = string;
	}
	public String getString() {
		return this.string;
	}
	public void setReplacee(String string) {
		this.replacee = string;
	}
	public String getReplacee() {
		return this.replacee;
	}
	public void setReplacer(String string) {
		this.replacer = string;
	}
	public String getReplacer() {
		return this.replacer;
	}
}