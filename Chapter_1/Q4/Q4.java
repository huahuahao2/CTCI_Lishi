package Q4;

public class Q4 {
	public static void main(String[] args) {
		ReplaceString r_1 = new ReplaceString("dsak dsfa dsfa", " ", "%20");
		System.out.println("The original string is: "+ r_1.getString());
		System.out.println("After the replacement the string is: "+ r_1.replace());
		ReplaceString r_2 = new ReplaceString("dsak dsfa dsfa          ");
		System.out.println("The original string is: "+ r_2.getString().trim());
		System.out.println("After the replacement the string is: "+ r_2.replaceWithoutExtraSpace());
	}
	
}

class ReplaceString {
	private String string, replacee, replacer;
	public ReplaceString (String string, String str1, String str2) {
		this.string = string;
		this.replacee = str1;
		this.replacer = str2;
	}
	public ReplaceString (String string) {
		this.string = string;
		this.replacee = null;
		this.replacer = null;
	}
	public String replaceWithoutExtraSpace() {//but it can only do 'space' to "%20"
		char[] str = string.toCharArray();
		int i = str.length, j = str.length-1;
		for(i--; i >= 0; i--) {
			if (str[i] != ' ')
				break;
		}
		for(; i >= 0 && j >= 0; i--) {
			if (str[i] == ' ') {
				str[j--] = '%';
				str[j--] = '0';
				str[j--] = '2';
			} 
			else {
				str[j--] = str[i];
			}
		}
		for (; j>=0; j--)
			str[j] = ' ';
		String s = new String(str);
		return s.trim();
	}
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