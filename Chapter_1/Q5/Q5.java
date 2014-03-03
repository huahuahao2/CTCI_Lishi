package Q5;

public class Q5 {
	public static void main(String[] args) {
		Compress c = new Compress(args[0].toCharArray());
		System.out.println(c.compressString());
	}
}

class Compress {
	private char[] str;
	public Compress(char[] str) {
		this.str = str;
	}
	public char[] getString() {
		return this.str;
	}
	public void setString(char[] str) {
		this.str = str;
	}
	public char[] compressString() {
		char[] cs = new char[str.length];
		for (int i = 0, j = 0, k = 0; i < str.length; i++) {
			if (j >= str.length)
				return str;
			else
				cs[j++] = str[i];
			for(k = 0; i < str.length; i++, k++)
				if (str[i] != cs[j-1]) {
					i--;
					break;}
			for (int n = 0; n < Integer.toString(k).length(); n++)
				if (j >= str.length)
					return str;
				else
					cs[j++] = Integer.toString(k).charAt(n);
		}
		return cs;
	}
}
