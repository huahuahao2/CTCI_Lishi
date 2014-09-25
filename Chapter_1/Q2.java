//
//  Chapter_1 Q2.java
//  CTCI
//
//  Created by Lishi Jiang on 09/23/14.
//  Copyright (c) 2014 Lishi Jiang. All rights reserved.
//

public class Q2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseString s = new ReverseString();
		System.out.println("The string is: " + args[0]);
		System.out.println("The reverse string is: " + s.reverse(args[0]));
	}
}

class ReverseString {
	public String reverse(String s) {
		char[] rev_s = s.toCharArray();
		int i = 0, j = s.length()-1;
		while (i < j) {
			char temp = rev_s[i];
			rev_s[i++] = rev_s[j];
			rev_s[j--] = temp;
		}
		return new String(rev_s);
	}
}