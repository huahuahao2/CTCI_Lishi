//
//  Chapter_2 Q1.java
//  CTCI
//
//  Created by Lishi Jiang on 09/23/14.
//  Copyright (c) 2014 Lishi Jiang. All rights reserved.
//

import java.util.HashSet;

public class Q1 {
	public static void main(String[] args) {
		ListNode a = new ListNode('f');
		ListNode b = new ListNode('e');
		a.next = b;
		ListNode c = new ListNode('d');
		b.next = c;
		ListNode d = new ListNode('c');
		c.next = d;
		ListNode e = new ListNode('b');
		d.next = e;
		ListNode f = new ListNode('a');
		e.next = f;
		ListNode.printNode(a);
		LinkedList_Chapter2 x = new LinkedList_Chapter2();
		System.out.println("\n");
		ListNode.printNode(x.partition(a, 'g'));
		//System.out.println("\n" + x.partition(a, 'd').val);
	}
}
class ListNode {
	char val;
	ListNode next;
	ListNode (char val) {
		this.val = val;
		this.next = null;
	}
	static public void printNode(ListNode head) {
		while(head!=null) {
			System.out.print("->" + head.val);
			head = head.next;
		}
	}
}
class LinkedList_Chapter2 {
	public ListNode remove(ListNode head) {
		HashSet<Character> past = new HashSet<Character>();
		if (head == null) {
			return head;
		}
		ListNode list = head;
		past.add(head.val);
		while(list.next!=null) {
			if (!past.contains(list.next.val)) {
				past.add(list.next.val);
				list = list.next;
			}
			else {
				list.next = list.next.next;
			}
		}
		return head;
	}
	public ListNode kthToTheLast(ListNode head, int k) {
		ListNode list = head;
		while (k != 0) {
			k--;
			if (list == null) {
				return null;
			}                       
			list = list.next;
		}
		while(list.next != null) {
			head = head.next;
			list = list.next;
		}
		return head;
	}
	public ListNode partition(ListNode head, char x) {
		ListNode first = null, second = null;
		ListNode firstHead = null, secondHead = null;
		while(head!=null) {
			if (head.val < x) {
				if (first == null ) {
					first = head;
					firstHead = first;
				}
				else {
					firstHead.next = head;
					firstHead = firstHead.next;
				}
			}
			else {
				if (second == null ) {
					second = head;
					secondHead = second;
				}
				else {
					secondHead.next = head;
					secondHead = secondHead.next;
				}
			}
			head = head.next;
		}
		
		if (first!=null) {
			firstHead.next = second;
			if (second != null) {
				secondHead.next = null;
			}
			return first;
		}
		else {
			if (second != null) {
				secondHead.next = null;
			}
			return second;
		}
	}
}
