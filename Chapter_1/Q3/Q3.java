//
//  Chapter_1 Q3.java
//  CTCI
//
//  Created by Lishi Jiang on 03/01/14.
//  Copyright (c) 2014 Lishi Jiang. All rights reserved.
//

package Q3;

public class Q3 {
	public static void main(String[] args) {
		Permutation p = new Permutation(args[0], args[1]);
		System.out.println("These two strings are: "+p.getStr1()+", "+p.getStr2());
		System.out.println("Are they permutate: "+p.isPermutation());
	}
}

class Permutation {
	private String str1;
	private String str2;
	public Permutation(String str1, String str2) {
		this.str1 = str1;
		this.str2 = str2;
	}
	boolean isPermutation() {
		if (str1.length() != str2.length())
			return false;
		String double_string = new String(this.str2);
		double_string += str2;
		return double_string.matches("(.*)"+str1+"(.*)");
	}
	String getStr1() {
		return this.str1;
	}
	void setStr1(String str) {
		this.str1 = str;
	}
	String getStr2() {
		return this.str2;
	}
	void setStr2(String str) {
		this.str2 = str;
	}
}
