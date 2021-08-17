package chapter3.SinglyLinkedList;

import java.util.Iterator;

public class SinglyLinkedList <E> {
	
	private static class Node <E> {
		private E element;
		private Node <E> next;
		
		public Node(E e, Node <E> n) {
			element = e;
			next = n;
		}
		
		public E getElement() { return element; }
		public Node <E> getNext() { return next; }
		public void setNext(Node <E> n) { next = n; }
	}
	
	private Node <E> head = null;
	private Node <E> tail = null;
	
	private int size = 0;
	public SinglyLinkedList() {}
	
	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }
	public E first() {
		if (isEmpty()) return null;
		return head.getElement();
	}
	public E last() {
		if (isEmpty()) return null;
		return tail.getElement();
	}
	// new's next'll point to head's next, then head points to new node
	public void addFirst(E e) {
		head = new Node<>(e, head);
		if (size == 0)
			tail = head;
		size++;
	}// new node points to null, tail's next will point to new, tail becomes new
	public void addLast(E e) {
		Node <E> newest = new Node<>(e, null);
		if (isEmpty())
			head = newest;
		else
			tail.setNext(newest);
		tail = newest;
		size++;
	}
	public E removeFirst() {
		if (isEmpty()) return null;
		E answer = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0)	//we do this, coz tail shouldn't refer to deleted node
			tail = null;
		return answer;
	}
	public E secondToLast() {	// prints second to last node
		if (isEmpty()) return null;
		Node <E> cur = head;
		Node <E> secondTolast = null;
		while (cur != tail) {
			secondTolast = cur;
			cur = cur.getNext();
		}
		return secondTolast.getElement();
	}
	public void display() {
		// display all nodes of linked list
		Node <E> cur = head;
		while (cur != null) {
			System.out.print("|" + cur.getElement() + "|" + "_| -> ");
			
			cur = cur.getNext();
		}
		System.out.println();
		/*	using for loop
		 * for (Node <E> i = head; i != null; i = i.getNext())
		 *	System.out.println(i.getElement());
		 */
	}
	public void concat(SinglyLinkedList<E> a, 
			SinglyLinkedList<E> b) {
		Node <E> a1 = a.head;
		Node <E> b1 = b.head;
		
		while (a1 != null) {// traverse over list by adding it to new list
			this.addLast(a1.getElement());
			a1 = a1.getNext();
		}
		//tail.setNext(a1);
		while (b1 != null) {
			this.addLast(b1.getElement());
			b1 = b1.getNext();
		}
		
	}
	public void swap(E X, E Y) {
		if (isEmpty()) return;
		
		if (X==Y) return;
		// Search for x (keep track of prevX and CurrX)
        Node <E> prevX = null, currX = head;
        while (currX != null && currX.getElement() != X) {
            prevX = currX;
            currX = currX.getNext();
        }
 
        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = head;
        while (currY != null && currY.getElement() != Y) {
            prevY = currY;
            currY = currY.getNext();
        }
 
        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return;
 
        // If x is not head of linked list
        if (prevX != null)
            prevX.next = currY;
        else // make y the new head
            head = currY;
 
        // If y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
            head = currX;
 
        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
	} /* reverse linkedlist */
	public static SinglyLinkedList reverse(SinglyLinkedList l) {
		
		Node prev = null;
		Node curr = l.head;
		Node next = null;
		while (curr != null) {
			next = curr.getNext();
			curr.next = prev;

			prev = curr;
			curr = next;
		}
		l.head = prev;
		return l;
	}/* delete key */
	public void delete(E key) {
		Node<E> temp = head, prev = null;
		
		if (temp != null && temp.getElement() == key) {
			head = temp.getNext();
			return;
		}// search for the key to be deleted
		while (temp != null && temp.getElement() != key) {
			prev = temp;
			temp = temp.getNext();
		}
		// If key was not present in linked list
		if (temp == null) return;
		// Unlink the node from linked list
		prev.next = temp.getNext();
	}
	public static void main(String[] args) {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
	
		list.addFirst("A");
		list.addFirst("X");
		list.addFirst("B");
		list.addFirst("C");
		list.addFirst("D");
		//System.out.println(list.tail.getElement());
		//System.out.println(list.head.getElement());
		//System.out.println(list.tail.getElement());
		//System.out.println("list1");
		//list.display();
		//System.out.println(list.secondToLast());
		SinglyLinkedList<String> list2 = new SinglyLinkedList<String>();
		
		list2.addFirst("E");
		list2.addFirst("F");
		list2.addFirst("G");
		list2.addFirst("H");
		//System.out.println("list2");
		//list2.display();
		SinglyLinkedList<String> list3 = new SinglyLinkedList<String>();
		//list3.addFirst("7");
		list3.concat(list, list2);
		
		list3.display();
		reverse(list3);
		//list3.swap("D", "C");
		list3.display();
	}
}



