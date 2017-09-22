package fortinet;

/*Question 1: Reverses a single list.  The Node of this single list as the following:


 class Node{
 Node next;
 int value;
 }
 // Your resolution 
 // Time complexity:  
 // Space complexity:  
 public Node reverse(Node head){
 }
 // JUnit test cases */
import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseSinglyList {
	static class Node {
		Node next;
		int value;

		Node() {

		}

		Node(int value) {
			this.value = value;
			this.next = null;
		}
	}
	//time complexity: O(n) n->number of nodes in linked list 
	//space complexity: O(1)
	public static Node reverse(Node head) {
		Node current = head;
		Node prev, ahead;
		prev = null;
		while (current != null) {
			ahead = current.next;
			current.next = prev;
			prev = current;
			current = ahead;
		}

		return prev;
	}

	public static void print(Node head) {
		while (head != null) {
			System.out.println(head.value);
			head = head.next;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		print(reverse(head));
	}

	public static boolean equals(Node one, Node two) {
		while (one != null && two != null) {
			if (one.value == two.value)
				return true;
			one = one.next;
			two = two.next;
		}
		return false;
	}

	@Test
	public void testReverse() {
		Node inputList = new Node(1);
		inputList.next = new Node(2);
		inputList.next.next = new Node(3);
		inputList.next.next.next = new Node(4);

		Node expectedList = new Node(4);
		expectedList.next = new Node(3);
		expectedList.next.next = new Node(2);
		expectedList.next.next = new Node(1);
		assertEquals("Check reverseList, reversing a list with 4 elements.",
				true, equals(reverse(inputList), expectedList));
	}
}
