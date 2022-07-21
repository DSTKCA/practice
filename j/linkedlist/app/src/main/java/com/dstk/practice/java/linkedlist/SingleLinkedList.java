package com.dstk.practice.java.linkedlist;

import java.util.ArrayList;

public class SingleLinkedList {

	// With head node (both head and current are pointer/reference, they only have
	// next, but data is null)
	private SingleLinkedListNode head; // The sentinel head node will not have data (always null)
	private SingleLinkedListNode current; // getNext is to fetch current value (did not use equal symbol '=')
	private SingleLinkedListNode rear; // refer to the rear node

	public SingleLinkedListNode getHead() {
		return head;
	}

	public SingleLinkedListNode getCurrent() {
		return current;
	}

	public void setCurrent(SingleLinkedListNode current) {
		this.current = current;
	}

	public SingleLinkedListNode getRear() {
		return rear;
	}

	public void setRear(SingleLinkedListNode rear) {
		this.rear = rear;
	}

	// Constructors
	// If you want to write constructor with args,
	// you MUST override the default one (with no args)
	public SingleLinkedList() {
		this.head = new SingleLinkedListNode();
		this.current = new SingleLinkedListNode();
		this.rear = new SingleLinkedListNode();
	}

	public SingleLinkedList(SingleLinkedListNode head) {
		this.head = new SingleLinkedListNode();
		this.current = new SingleLinkedListNode();
		this.rear = new SingleLinkedListNode();
		this.head.setNext(head);
		this.current.setNext(head);
		this.rear.setNext(head);
	}

	/*
	 * Handling tips 1. Take care of the handling order of the pointer/reference 2.
	 * Take care of boundary (head, rear, 1-2 nodes exception) 3. Take care of null
	 * and memory exceed/leak 4. Usage of sentinel 5. Illustration
	 */

	// Basic Actions

	// Clear List
	public void removeAll() {
		this.head = null;
		this.current = null;
		this.rear = null;
	}

	// Init for next step
	public void init() {
		this.head = new SingleLinkedListNode();
		this.current = new SingleLinkedListNode();
		this.rear = new SingleLinkedListNode();
	}

	// Init with ArrayList
	public void initWithArray(ArrayList<String> strArray) {

		System.out.println("Initialize with String array");

		// Clean the list and re-init
		this.removeAll();
		this.init();

		// Create the rear node and set the rear pointer
		SingleLinkedListNode node = new SingleLinkedListNode(strArray.get(strArray.size() - 1), null);
		this.rear.setNext(node);
		this.current.setNext(node);

		// Create list from rear item
		// Iterate array and append every item to the list
		for (int i = strArray.size() - 2; i >= 0; i--) {
			node = new SingleLinkedListNode(strArray.get(i), this.current.getNext());
			this.current.setNext(node);
		}

		this.head.setNext(this.current.getNext());

		// Print the result
		this.printList();

	}

	// Append ArrayList
	public void appendArray(ArrayList<String> strArray) {

		// If null list, init with the strArray
		if (this.head.getNext() == null) {
			System.out.println("Append String array: null");
			this.initWithArray(strArray);
		}
		// If list not null, append array items to the rear of the list
		else {
			System.out.println("Append String array: not null");
			// Create the rear node and set the rear pointer
			SingleLinkedListNode node = new SingleLinkedListNode(strArray.get(strArray.size() - 1), null);
			SingleLinkedListNode newRear = new SingleLinkedListNode(null, node);
			this.current.setNext(node);

			// Iterate array and append every item to the 2nd part of the list
			for (int i = strArray.size() - 2; i >= 0; i--) {
				node = new SingleLinkedListNode(strArray.get(i), this.current.getNext());
				this.current.setNext(node);
			}

			// Concate 2 lists
			this.rear.getNext().setNext(this.current.getNext());
			this.rear.setNext(newRear.getNext());
		}

		// Print the result
		this.printList();
	}

	// Iterate and print all nodes
	public void printList() {

		if (this.head.getNext() == null) {
			System.out.println("Did NOT print null list");
		} else {
			this.current.setNext(this.head.getNext());
			while (this.current.getNext() != null) {
				System.out.println(String.format("Node data '%s'", this.current.getNext().getData()));
				this.current.setNext(this.current.getNext().getNext());
				;
			}
		}

	}

	// Add or set head
	public void setHead(SingleLinkedListNode inHead) {

		// If sentinel head or current is null, init it
		if (this.head == null) {
			this.head = new SingleLinkedListNode();
		}
		if (this.current == null) {
			this.current = new SingleLinkedListNode();
		}

		// If sentinel head's next is null, meaning null list,
		// head point to the inHead
		// current = inHead
		if (this.head.getNext() == null) {
			this.head.setNext(inHead);
			this.current = inHead;
		}

		// If head is NOT null, meaning NOT a null list,
		// only head point to the new head
		// 1. inHead.next = this.head.getNext
		// 2. this.head.setNext(head)
		else {
			inHead.setNext(this.head.getNext());
			this.head.setNext(inHead);
		}
	}

	// Remove head
	public void removeHead() {

		// Only take action if head NOT null
		if (this.head.getNext() != null) {

			// Only 1 node in list
			if (this.head.getNext().getNext() == null) {
				this.head.setNext(null);
				this.current = null;
			}
			// If there're 2 or more nodes in the list
			else {
				// If current == head, current should be moved together with head
				if (this.current == this.head.getNext()) {
					this.current = this.current.getNext();
				}
				this.head.setNext(this.head.getNext().getNext());
			}

		} else {
			System.out.println("No action taken since null list");
		}
	}

	// Add rear
	// Remove rear

	// Search node by data
	// Remove current node
	// Add node before current node
	// Add node after current node

	// LeetCode

	// Reverse the list
	// Circle detect
	// Merge (might be outside the class)
	// Remove node at the Nth position from the rear
	// Get the node in the middle of the list

}
