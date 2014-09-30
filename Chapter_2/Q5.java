//
//  Chapter_2 Q2.java
//  CTCI
//
//  Created by Lishi Jiang on 09/29/14.
//  Copyright (c) 2014 Lishi Jiang. All rights reserved.
//
//	It is still not fully implemented.
//

import java.util.HashSet;
import java.util.LinkedList;
public class Q5 {
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		a.next = b;
		ListNode c = new ListNode(4);
		b.next = c;
		ListNode d = new ListNode(4);
		c.next = d;
		ListNode e = new ListNode(5);
		d.next = e;
		ListNode f = new ListNode(6);
		e.next = f;
		//f.next = a;
		/*ListNode.printNode(a);
		ListNode.printNode(d);
		System.out.println("\n");
		ListNode.printNode(sum(a, d));*/
		System.out.println(palindrome(a));
	}
	public static ListNode sum(ListNode a, ListNode b) {
		int carry = 0;
		ListNode aHead = a, bHead = b;
		while (a != null && b != null) {
			carry = (a.val+b.val+carry)/10;
			a.val = (a.val+b.val+carry)%10;
			b.val = (a.val+b.val+carry)%10;
			a = a.next;
			b = b.next;
		}
		while (a != null && a.next != null) {
			carry = (a.next.val+carry)/10;
			a.next.val = (a.next.val+carry)%10;
		}

		while (b != null && b.next != null) {
			carry = (b.next.val+carry)/10;
			b.next.val = (b.next.val+carry)%10;
		}

		if (carry == 1) {
			ListNode c = new ListNode(1);
			if (a != null) {
				a.next = c;
			}
			if (b != null) {
				b.next = c;
			}
		}
		if (a != null) {
			return aHead;
		}
		if (b != null) {
			return bHead;
		}
		return aHead;
	}
	public static boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        /*if (head.next == head) {
            return true;
        }*/
        if(head.next == null)
            return false;
        ListNode run = head.next.next;
        while(run != null) {
            if (run == head)
                return true;
            head = head.next;
            if(run.next == null)
                return false;
            run = run.next.next;
        }
        return false;
    }
    //see what a greate code I write!!
    public boolean hasCycle_old(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null&&fast.next!=null) {
        	fast = fast.next.next;
        	slow = slow.next;
        	if(slow == fast){
        		return true;
        	}
        }
        return false;
    }
    //math is more amazing.
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null&&fast.next!=null) {
        	fast = fast.next.next;
        	slow = slow.next;
        	if(slow == fast){
        		break;
        	}
        }
        if (fast==null||fast.next==null) {
        	return null;
        }
        while(true) {
        	fast = fast.next;
        	head = head.next;
        	if(head == fast){
        		break;
        	}
        }
        return fast;
    }
    public static boolean palindrome(ListNode head) {
    	LinkedList<ListNode> past = new LinkedList<ListNode>();
    	ListNode cur = head;
    	while(cur != null) {
    		past.push(cur);
    		cur = cur.next;
    	}
    	cur = head;
    	while(cur != null) {
    		if (cur.val != past.pop().val) {
    			return false;
    		}
    		cur = cur.next;
    	}
    	return true;
    }

}
class ListNode {
	int val;
	ListNode next;
	ListNode (int val) {
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
