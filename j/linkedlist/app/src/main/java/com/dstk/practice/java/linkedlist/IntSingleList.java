package com.dstk.practice.java.linkedlist;

import java.util.ArrayList;

// More method can be referred in SingleLinkedList
public class IntSingleList {
	// With head node (both head and current are pointer/reference, they only have
	// next, but data is null)
	private IntSingleListNode head; // The sentinel head node will not have data (always null)
	private IntSingleListNode current; // getNext is to fetch current value (did not use equal symbol '=')
	private IntSingleListNode rear; // refer to the rear node
	private int length; // Number of nodes

	public IntSingleListNode getHead() {
		return head;
	}

	public void setHead(IntSingleListNode head) {
		this.head = head;
	}

	public IntSingleListNode getCurrent() {
		return current;
	}

	public void setCurrent(IntSingleListNode current) {
		this.current = current;
	}

	public IntSingleListNode getRear() {
		return rear;
	}

	public void setRear(IntSingleListNode rear) {
		this.rear = rear;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	// Constructor
	public IntSingleList() {
		this.head = new IntSingleListNode();
		this.rear = new IntSingleListNode();
		this.current = new IntSingleListNode();
		this.length = 0;
	}

	public IntSingleList(IntSingleListNode head) {
		this.head = new IntSingleListNode();
		this.rear = new IntSingleListNode();
		this.current = new IntSingleListNode();
		this.head.setNext(head);
		this.rear.setNext(head);
		this.current.setNext(head);
		this.length = 1;
	}

	public void appendArray(ArrayList<Integer> intArray) {
		// rear of input int list
		IntSingleListNode node = new IntSingleListNode(intArray.get(intArray.size() - 1), null);
		IntSingleListNode rear = new IntSingleListNode();
		rear.setNext(node); // Save time complexity to iterate 2nd list again to set rear
		// Use current as cursor
		this.current.setNext(node);
		this.length++;
		// Iterate to build 2nd list
		for (int i = intArray.size() - 2; i >= 0; i--) {
			node = new IntSingleListNode(intArray.get(i), this.current.getNext());
			this.current.setNext(node);
			this.length++;
		}
		// Append 2nd list, and set flags
		if (this.head.getNext() == null) {
			this.head.setNext(this.current.getNext());
			this.rear.setNext(rear.getNext());
		} else {
			this.rear.getNext().setNext(this.current.getNext());
			this.current.setNext(this.head.getNext());
			this.rear.setNext(rear.getNext());
		}
	}

	public void printList() {
		this.current.setNext(this.head.getNext());
		while (this.current.getNext() != null) {
			System.out.println(String.format("Int node value: %d", this.current.getNext().getData()));
			this.current.setNext(this.current.getNext().getNext());
		}
	}

	// LeetCode: Get the node in the middle of the list, if node number is even,
	// return the 2nd middle node
	// Algorithm: fast and slow pointer, fast move 2 steps while slow move 1 step
	// per time
	// 1. Node number is odd, when fast pointer moved to rear, slow pointer point to
	// middle node
	// 2. Node number is even, when faster pointer's next's next is rear, slow
	// pointer's next and its next is the middle
	public IntSingleListNode getMidNode() throws Exception {
		if(this.head.getNext()==null) {
			throw new Exception("Null list");
		}
		
		// Use current as slow pointer
		this.current.setNext(this.head.getNext());
		// Init fast pointer with head
		IntSingleListNode fastPointer = new IntSingleListNode();
		fastPointer.setNext(this.head.getNext());
		
		// Iterate list till fast point to rear or the one before rear
		while(fastPointer.getNext().getNext()!=null&&fastPointer.getNext().getNext().getNext()!=null) {
			fastPointer.setNext(fastPointer.getNext().getNext().getNext());
			this.current.setNext(this.current.getNext().getNext());
		}
		
		if(fastPointer.getNext().getNext()==null) {
			return this.current.getNext();
		} else {
			return this.current.getNext().getNext();
		}
	}
}
