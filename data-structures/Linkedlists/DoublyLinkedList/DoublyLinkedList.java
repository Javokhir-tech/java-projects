package chapter3.DoublyLinkedList;


public class DoublyLinkedList <E> {
	private static class Node <E> {
		private E element;
		private Node <E> prev;
		private Node <E> next;
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}
		public E getElement() { return element; }
		public Node <E> getNext() { return next; }
		public Node <E> getPrev() { return prev;}
		public void setPrev(Node <E> p) { prev = p; }
		public void setNext(Node <E> n) { next = n; }
	}
	private Node <E> header;
	private Node <E> trailer;
	private int size = 0;
	// sentinels won't store value
	public DoublyLinkedList() {	// sentinels
		header = new Node<> (null, null, null);
		trailer = new Node<> (null, header, null);
		header.setNext(trailer);
	}
	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }
	public E first() {
		if (isEmpty()) return null;
		return header.getNext().getElement();
	}
	public E last() {
		if (isEmpty()) return null;
		return trailer.getPrev().getElement();
	}
	// update methods
	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}
	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}
	public E removeFirst() {
		if (isEmpty()) return null;
		return remove(header.getNext());
	}
	public E removeLast() {
		if (isEmpty()) return null;
		return remove(trailer.getPrev());
	}
	private void addBetween(E e, Node <E> pred, Node <E> succ) {
		Node <E> newest = new Node<>(e, pred, succ);
		pred.setNext(newest);
		succ.setPrev(newest);
		size++;
	}
	private E remove(Node <E> node) {
		Node <E> pred = node.getPrev();
		Node <E> succ = node.getNext();
		pred.setNext(succ);
		succ.setPrev(pred);
		size--;
		return node.getElement();
	}
	public E middle() {
		if (isEmpty()) return null;
		Node <E> cur1 = header;
		Node <E> cur2 = trailer;
		
		if(cur1.getNext() == null || cur2.getPrev() == null)
			return cur1.getElement();
		else {
			while(cur1.getNext() != null && cur2.getPrev() != null) {
				if (cur1.equals(cur2) || cur1.equals(cur2.getPrev()))
					return cur1.getElement();
				cur2 = cur2.getPrev();
				cur1 = cur1.getNext();
			}
		}
		return null;
	}
	public boolean equals(DoublyLinkedList<E> list) {
		if (list == null) return false;
		if (this.size() != list.size()) return false;
		Node <E> cur1 = this.header.getNext();	// trverse prim list
		Node <E> cur2 = list.header.getNext();	// traverse other
		while (cur1 != trailer) {
			if (!cur1.getElement().equals(cur2.getElement())) return false;
			cur1 = cur1.getNext();
			cur2 = cur2.getNext();
		}
		return true;
	}
	public void display() {
		// display all nodes of linked list
		Node <E> cur = header;
		while (cur != null) {
			System.out.print("<- |" + cur.getElement() + "|" + " -> ");
			
			cur = cur.getNext();
		}
		System.out.println();
		/*	using for loop
		 * for (Node <E> i = head; i != null; i = i.getNext())
		 *	System.out.println(i.getElement());
		 */
	}
	public void concat(DoublyLinkedList<E> a, 
			DoublyLinkedList<E> b) {
		Node <E> a1 = a.header.getNext();
		Node <E> b1 = b.header.getNext();
		
		while (a1 != null && a1.getElement() != null) {	// below
			this.addLast(a1.getElement());
			a1 = a1.getNext();
		}
		//tail.setNext(a1);
		while (b1 != null && b1.getElement() != null) {	// avoid empty sentinels b/w lists
			this.addLast(b1.getElement());
			b1 = b1.getNext();
		}
	}
	public static DoublyLinkedList reverse(DoublyLinkedList l) {
		
		Node prev = null;
		Node curr = l.header;
		Node next = null;
		while (curr != null) {
			next = curr.getNext();
			curr.next = prev;

			prev = curr;
			curr = next;
		}
		l.header = prev;
		return l;
	}
	public static void main(String[] args) {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.addFirst("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		
		//System.out.println(list.middle());
		DoublyLinkedList<String> list2 = new DoublyLinkedList<String>();
		list2.addFirst("E");
		list2.addLast("F");
		list2.addLast("G");
		list2.addLast("H");
		//System.out.println(list.equals(list2));
		DoublyLinkedList<String> list3 = new DoublyLinkedList<String>();
		list3.concat(list, list2);
		list3.display();
		//System.out.println(list3.size());
		reverse(list3);
		list3.display();
	}
}






