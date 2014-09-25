//
//  Chapter_1 Q5.java
//  CTCI
//
//  Modified by Lishi Jiang on 09/23/14.
//  Copyright (c) 2014 Lishi Jiang. All rights reserved.
//


public class Q5 {
	public static void main(String[] args) {
		Compress c = new Compress(args[0].toCharArray());
		System.out.println(c.compressString());
		System.out.println(c.compressString(args[0]));
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
		for (int i = 0, j = 0, k = 0; i < str.length; i++) { //O(n) times
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
	public String compressString(String s) {
		char[] ret = new char[s.length()-1];
		int i = -1, j = 0;
		while (i < s.length()) {
			int count = 0;
			do {
				count++;
				i++;
			}
			while (i < s.length()-1 && s.charAt(i) == s.charAt(i+1));
			//here: did not consider the possibility that count could be more.
			if (j > ret.length-2) {
				return s;
			}
			ret[j++] = s.charAt(i);
			ret[j++] = (char) (count + (int)'0');
			if (i == s.length() - 1) {
				break;
			}
		}
		return new String(ret);
	}
}
