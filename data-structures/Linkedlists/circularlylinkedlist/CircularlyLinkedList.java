package chapter3.circularlylinkedlist;

public class CircularlyLinkedList<E> {
	// tail will always point to the head in circular
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
	private Node <E> tail = null;
	private int size = 0;
	
	public CircularlyLinkedList() {}
	
	public int size() {return size;}
	public boolean isEmpty() {return size == 0;} 
	public E first() {
		if (isEmpty()) return null;
		return tail.getNext().getElement();	// head is after tail
	}
	public E last() {	//1st to back
		if (isEmpty()) return null;
		return tail.getElement();	// old head becomes new tail
	}
	// update methods
	public void rotate() {
		if (tail != null)
			tail = tail.getNext();
	}
	public void addFirst(E e) {// add elem to front
		if (size == 0) {
			tail = new Node<> (e, null);
			tail.setNext(tail);
		} else {
			//Node <E> newest = ;
			tail.setNext(new Node<> (e, tail.getNext()));	// link itself circularly
		}
		size++;
	}
	public void addLast(E e) {
		addFirst(e);	// add elem to end of list
		tail = tail.getNext();	// new becomes tail
	}
	public E removeFirst() {
		if (isEmpty()) return null;
		Node <E> head = tail.getNext();
		if (head == tail) tail = null;
		else tail.setNext(head.getNext());
		size--;
		return head.getElement();
	}
	public void display() {
		Node <E> cur = tail.getNext();
		while (cur != tail) {
			System.out.println(cur.getElement());
			cur = cur.getNext();
		}// prints tail
		System.out.println(cur.getElement());
	}
	public boolean equals(CircularlyLinkedList<E> list) {
		if (list == null) return false;
		if (this.size() != list.size()) return false;
		Node <E> cur1 = tail.getNext();	// trverse prim list
		Node <E> cur2 = list.tail.getNext();	// traverse other
		while (cur1 != tail) {
			if (!cur1.getElement().equals(cur2.getElement())) return false;
			cur1 = cur1.getNext();
			cur2 = cur2.getNext();
		}
		return true;
	}
	public static void main(String[] args) {
		CircularlyLinkedList<String> list = new CircularlyLinkedList<String>();
		list.addFirst("A");
		list.addLast("B");
		list.addLast("C");
		list.addFirst("0");
		//System.out.println(list.size());
		//list.display();
		CircularlyLinkedList<String> list2 = new CircularlyLinkedList<String>();
		list2.addFirst("A");
		list2.addLast("B");
		list2.addLast("C");
		list2.addFirst("0");
		System.out.println(list.equals(list2));
	}
}


