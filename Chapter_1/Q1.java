//
//  Chapter_1 Q1.java
//  CTCI
//
//  Created by Lishi Jiang on 02/27/14.
//  Copyright (c) 2014 Lishi Jiang. All rights reserved.
//
import java.util.HashSet;

public class Q1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueCharacter unique = new UniqueCharacter(args[0]);
		System.out.println("The string is: " + unique.getString());
		System.out.println("Unique?: " + unique.determine());
		System.out.println("Unique?: " + unique.determine_HashSet());
		System.out.println("Unique?: " + unique.determine_ASCII());
	}
}

class UniqueCharacter {
	private String string;
	public UniqueCharacter(String string) {
		this.string = string;
	}
	public boolean determine() {
		char c[] = string.toCharArray();
		for (int i = 0; i < c.length; i++)
			for (int j = i+1; j < c.length; j++)
				if (c[i] == c[j])
					return false;
		return true;
	}
	public boolean determine_ASCII() {//assuming it is ASCII coding
		if (string.length() > 256)
			return false;
		boolean character[] = new boolean[256];
		char c[] = string.toCharArray();
		for (char i : c) {
			if (!character[(int)i])
				character[(int)i] = true;
			else
				return false;
		}
		return true;
	}
	public boolean determine_HashSet() {
		HashSet<Character> has = new HashSet<Character>();
		for (int i = 0; i < string.length(); i++) {
			if (has.contains(string.charAt(i))) {
				return false;
			}
			else
				has.add(string.charAt(i));
		}
		return true;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
}
