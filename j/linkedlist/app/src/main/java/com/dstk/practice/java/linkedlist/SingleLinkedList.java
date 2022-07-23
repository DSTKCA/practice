package com.dstk.practice.java.linkedlist;

import java.util.ArrayList;

public class SingleLinkedList {

	// With head node (both head and current are pointer/reference, they only have
	// next, but data is null)
	private SingleLinkedListNode head; // The sentinel head node will not have data (always null)
	private SingleLinkedListNode current; // getNext is to fetch current value (did not use equal symbol '=')
	private SingleLinkedListNode rear; // refer to the rear node
	private int length; // Number of nodes

	public SingleLinkedListNode getHead() {
		return head;
	}

	public SingleLinkedListNode getCurrent() {
		return current;
	}

	// Always make current point to the head after every action
	// Not disclose this to user
//	public void setCurrent(SingleLinkedListNode current) {
//		this.current = current;
//	}

	public SingleLinkedListNode getRear() {
		return rear;
	}

	// Constructors
	// If you want to write constructor with args,
	// you MUST override the default one (with no args)
	public SingleLinkedList() {
		this.head = new SingleLinkedListNode();
		this.current = new SingleLinkedListNode();
		this.rear = new SingleLinkedListNode();
		this.length = 0;
	}

	public SingleLinkedList(SingleLinkedListNode head) {
		this.head = new SingleLinkedListNode();
		this.current = new SingleLinkedListNode();
		this.rear = new SingleLinkedListNode();
		this.head.setNext(head);
		this.current.setNext(head);
		this.rear.setNext(head);
		this.length = 1;
	}

	/*
	 * Handling tips 1. Take care of the handling order of the pointer/reference 2.
	 * Take care of boundary (head, rear, 1-2 nodes exception) 3. Take care of null
	 * and memory exceed/leak 4. Usage of sentinel 5. Illustration
	 */

	// Basic Actions

	// Clear List
	public void removeAll() {
		// In Java, don't need to take care of the memory release
		// If in C, need to release all the node's memory first
		this.head = null;
		this.current = null;
		this.rear = null;
		this.length = 0;
	}

	// Init actions
	public void init() {
		this.head = new SingleLinkedListNode();
		this.current = new SingleLinkedListNode();
		this.rear = new SingleLinkedListNode();
		this.length = 0;
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
		this.length++;

		// Create list from rear item
		// Iterate array and append every item to the list
		for (int i = strArray.size() - 2; i >= 0; i--) {
			node = new SingleLinkedListNode(strArray.get(i), this.current.getNext());
			this.current.setNext(node);
			this.length++;
		}

		this.head.setNext(this.current.getNext());

	}

	// Append ArrayList
	public void appendArray(ArrayList<String> strArray) {

		// If null list, init with the strArray
		if (this.head.getNext() == null) {
			System.out.println("Init list with string array");
			this.initWithArray(strArray);
		}
		// If list not null, append array items to the rear of the list
		else {
			System.out.println("Append String array to existing list");
			// Create the rear node and set the rear pointer
			SingleLinkedListNode node = new SingleLinkedListNode(strArray.get(strArray.size() - 1), null);
			SingleLinkedListNode newRear = new SingleLinkedListNode(null, node);
			this.current.setNext(node);
			this.length++;

			// Iterate array and append every item to the 2nd part of the list
			for (int i = strArray.size() - 2; i >= 0; i--) {
				node = new SingleLinkedListNode(strArray.get(i), this.current.getNext());
				this.current.setNext(node);
				this.length++;
			}

			// Concate 2 lists
			this.rear.getNext().setNext(this.current.getNext());
			this.rear.setNext(newRear.getNext());
		}
		this.current.setNext(this.head.getNext());

	}

	// Iterate and print all nodes

	// Add or set head

	// Head handling
	public void setHead(SingleLinkedListNode head) {

		// If sentinel head's next is null, meaning null list,
		// make all head, current, and rear point to the new head
		if (this.head.getNext() == null) {
			this.head.setNext(head);
			this.current.setNext(head);
			this.rear.setNext(head);
		}

		// If head is NOT null, meaning NOT a null list,
		// only head point to the new head
		// 1. inHead.next = this.head.getNext
		// 2. this.head.setNext(head)
		else {
			head.setNext(this.head.getNext());
			this.head.setNext(head);
			this.current.setNext(head);
		}
		this.length++;
	}

	public void setHead(String head) {
		SingleLinkedListNode hNode = new SingleLinkedListNode(head, null);
		this.setHead(hNode);
	}

	public void removeHead() {

		// Only take action if head NOT null
		if (this.head.getNext() != null) {

			// Only 1 node in list
			if (this.head.getNext().getNext() == this.rear.getNext()) {
				this.removeAll();
				this.init();
			}
			// If there're 2 or more nodes in the list
			else {
				this.head.setNext(this.head.getNext().getNext());
				this.current.setNext(this.head.getNext());
			}
			this.length--;

		} else {
			System.out.println("No action taken since null list");
		}
	}

	// Rear handling

	public void setRear(SingleLinkedListNode rear) {
		// Null list
		if (this.head.getNext() == null) {
			// rear is head
			this.init();
			this.head.setNext(rear);
			this.rear.setNext(rear);
			this.current.setNext(rear);
		}
		// un-null lsit
		else {
			this.rear.getNext().setNext(rear);
			this.rear.setNext(rear);
		}
		this.length++;
	}

	public void setRear(String rear) {
		SingleLinkedListNode rNode = new SingleLinkedListNode(rear, null);
		this.setRear(rNode);
	}

	public void removeRear() {
		if (this.head.getNext() != null) {
			if (this.head.getNext() == this.rear.getNext()) {
				this.removeAll();
				this.init();
			} else {
				// Start iteration from head node
				this.current.setNext(this.head.getNext());
				// Iterate all nodes
				while (this.current.getNext().getNext() != this.rear.getNext()) {
					this.current.setNext(this.current.getNext().getNext());
				}
				// Remove rear
				this.current.getNext().setNext(null);
				this.rear.setNext(this.current.getNext());
				// Move current back
				this.current.setNext(this.head.getNext());
			}
			this.length--;
		}
	}

	// Search/Get node
	public SingleLinkedListNode searchByData(String data) {
		this.current.setNext(this.head.getNext());
		while (this.current.getNext().getData() != data && this.current.getNext() != this.rear.getNext()) {
			this.current.setNext(this.current.getNext().getNext());
		}
		if (this.current.getNext().getData() == data) {
			System.out.println("Node found");
			return this.current.getNext();
		}

		return null;
	}

	public SingleLinkedListNode getByIndex(int index) throws Exception {
		if (index >= this.length) {
			throw new Exception("Arg issue: Out of range!");
		}

		this.current.setNext(this.head.getNext());
		int i = 0;
		while (i < index) {
			this.current.setNext(this.current.getNext().getNext());
			i++;
		}

		return this.current.getNext();
	}

	// Add node before exist node
	public void insertBefore(String existData, String newData) {

		if (this.head.getNext() != null) {
			this.current.setNext(this.head.getNext());

			// If the first node is the exist one, add newData as head
			if (this.current.getNext().getData() == existData) {
				this.setHead(newData);
				System.out.println("Inserted as head");
			}
			// Else iterate the list to find and insert
			else {
				while (this.current.getNext().getNext().getData() != existData
						&& this.current.getNext().getNext() != this.rear.getNext()) {
					this.current.setNext(this.current.getNext().getNext());
				}
				if (this.current.getNext().getNext().getData() == existData) {
					SingleLinkedListNode newNode = new SingleLinkedListNode(newData, this.current.getNext().getNext());
					this.current.getNext().setNext(newNode);
					System.out.println(String.format("Inserted before exist node '%s'", existData));
					this.current.setNext(this.head.getNext());
					this.length++;
				} else {
					System.out.println("Node not found");
				}
			}
		} else {
			System.out.println("Null list");
		}
	}

	// Add node after current node
	public void insertAfter(String existData, String newData) {
		if (this.head.getNext() == null) {
			System.out.println("Null list");
		} else {
			// Iterate from head
			this.current.setNext(this.head.getNext());
			while (this.current.getNext().getData() != existData && this.current.getNext().getNext() != null) {
				this.current.setNext(this.current.getNext().getNext());
			}
			if (this.current.getNext().getData() == existData) {
				SingleLinkedListNode newNode = new SingleLinkedListNode(newData, this.current.getNext().getNext());
				this.current.getNext().setNext(newNode);
				this.length++;
				System.out.println(String.format("Inserted after exist node '%s'", existData));
				// If exist data at rear, after adding new node, make rear point to new rear
				if (newNode.getNext() == null) {
					this.rear.setNext(newNode);
				}
			} else {
				System.out.println(String.format("Node '%s' not found", existData));
			}
			// Move current to head node
			this.current.setNext(this.head.getNext());
		}
	}

	// Remove node
	public void removeData(String data) {

		if (this.head.getNext() == null) {
			System.out.println("Null list");
			return;
		}

		if (this.head.getNext().getData() == data) {
			this.removeHead();
		} else {
			// Iterate from head
			this.current.setNext(this.head.getNext());
			while (this.current.getNext().getNext().getData() != data
					&& this.current.getNext().getNext() != this.rear.getNext()) {
				this.current.setNext(this.current.getNext().getNext());
			}
			if (this.current.getNext().getNext().getData() == data) {
				System.out.println("Node found");
				// Remove the node
				this.current.getNext().setNext(this.current.getNext().getNext().getNext());
				// Set flags
				if (this.current.getNext().getNext() == null) {
					this.rear.setNext(this.current.getNext());
				}
				this.length--;
			}
		}
	}

	// Remove index node
	public void removeDataAtIndex(int index) throws Exception {
		if (index >= this.length) {
			throw new Exception("Arg issue: Out of range!");
		}

		if (index == 0) {
			this.removeHead();
		} else {
			// Iterate from head
			this.current.setNext(this.head.getNext());
			int i = 0;
			while (i + 1 < index) {
				this.current.setNext(this.current.getNext().getNext());
				i++;
			}
			System.out.println(String.format("Removed node at index '%d'", index));
			// Remove the node
			this.current.getNext().setNext(this.current.getNext().getNext().getNext());
			// Set flags
			if (this.current.getNext().getNext() == null) {
				this.rear.setNext(this.current.getNext());
			}
			this.length--;
		}
	}

	// Print list
	public void printList() {

		if (this.head.getNext() == null) {
			System.out.println("Did NOT print null list");
		} else {
			System.out.println(String.format("List length: %d", this.length));
			this.current.setNext(this.head.getNext());
			while (this.current.getNext().getNext() != null) {
				System.out.println(String.format("Node data '%s'", this.current.getNext().getData()));
				this.current.setNext(this.current.getNext().getNext());
			}
			System.out.println(String.format("Node data '%s'", this.current.getNext().getData()));
		}
		this.current.setNext(this.head.getNext());

	}

	// LeetCode

	// LeetCode 1: Reverse the list
	// Algorithm
	// Iterate the list, put every node in reverse order
	public void reverseList() {

		if (this.head.getNext() == null) {
			System.out.println("Null list cannot be reversed");
			return;
		} else if (this.head.getNext() == this.rear.getNext()) {
			System.out.println("Only 1 node in list, no need to reverse");
			return;
		}
		// Can be reset just before usage
//		this.current.setNext(this.head.getNext());
		this.rear.setNext(this.head.getNext()); // Origin head is new rear

		// Init new head with new rear
		SingleLinkedListNode newHead = new SingleLinkedListNode();
		newHead.setNext(this.rear.getNext());
		// New rear next should be null, but should be done after all actions,
		// to avoid head and current also has null next
//		this.rear.getNext().setNext(null);

		// Iterate from origin 2nd node
		this.head.setNext(this.head.getNext().getNext());
		this.current.setNext(this.head.getNext());

		// Iterate till head point to rear
		while (this.head.getNext().getNext() != null) {
			// Head -> next node
			this.head.setNext(this.head.getNext().getNext());
			// Make current point to new head
			this.current.getNext().setNext(newHead.getNext());
			// Reset new head
			newHead.setNext(this.current.getNext());
			// Move current back to origin head
			this.current.setNext(this.head.getNext());
		}

		// Origin rear -> new head
		this.head.getNext().setNext(newHead.getNext());

		// Flags
		// current -> new head
		this.current.setNext(this.head.getNext()); // Move current to new head
		// rear -> null
		this.rear.getNext().setNext(null);
		// new head will be released by JVM
		// length not change

		System.out.println("List reversed");

	}

	// LeetCode 2: Circle detect
	// Algorithm 1: Fast and slow pointer
	// Given: fastPointer move 2 steps per time, slowPointer move 1 step
	// Then: if there's circle, after several times, fasterPointer.getNext() ==
	// slowPointer.getNext()
	public boolean hasCircle() throws Exception {

		if (this.head.getNext() == null) {
			throw new Exception("Null list");
		}

		// In examine, there might not be a rear node
//		if (this.head.getNext()==this.rear.getNext() && this.rear.getNext().getNext()==this.head.getNext() ){
//			return true;
//		}

		// Init fast and slow pointers
		// Always use setNext() but NOT symbol equal '='
		SingleLinkedListNode fastPointer = new SingleLinkedListNode();
		fastPointer.setNext(this.head.getNext());
		SingleLinkedListNode slowPointer = new SingleLinkedListNode();
		slowPointer.setNext(this.head.getNext());

//		If there's circle, there'll be no node has null next, and we only need to check fast pointer
		while (fastPointer.getNext().getNext() != null && fastPointer.getNext().getNext().getNext() != null) {
			// Slow pointer move 1 step
			slowPointer.setNext(slowPointer.getNext().getNext());
			// Fast pointer move 2 steps
			fastPointer.setNext(fastPointer.getNext().getNext().getNext());

			if (slowPointer.getNext() == fastPointer.getNext()) {
				return true;
			}
		}

		return false;
	}

	// TODO: Algorithm 2: Hash table

	// LeetCode 3: Merge 2 sequential lists into 1
	// Completed @LinkedListHandler
	
	// LeetCode 4: Remove node at the Nth position from the rear (assume length is not known, and 0 < N < length)
	
	// Algorithm 1: iteration twice
	// 1st iteration: get the length of list. 
	// 2nd iteration: remove the (length - N +1)th node
	// time complexity = O(n)
	public void removeAtReverseIndexIterateTwice(int rPos) {

		int length = 0;
		int pos = 0;
		this.current.setNext(this.head.getNext());
		
		// Interation 1 to get pos
		while(this.current.getNext().getNext()!=null) {
			length++;
			this.current.setNext(this.current.getNext().getNext());
		}
		length++;
		pos = length - rPos + 1;
		
		this.current.setNext(this.head.getNext());
		// Iteration 2 to remove the node
		for(int i=1;i<pos-1;i++) {
			this.current.setNext(this.current.getNext().getNext());
		}
		this.current.getNext().setNext(this.current.getNext().getNext().getNext());
		
		// Set flags
		if(this.current.getNext().getNext()==null) {
			this.rear.setNext(this.current.getNext());
		}
		this.current.setNext(this.head.getNext());
		this.length--;
		
	}
	// Algorithm 2: iteration once
	// 1. Set 2 pointers: current and far, let far ahead (rPos - 1) positions of current
	// 2. Iterate till far point to 1 before rear (current is 1 before the node to be removed)
	// 3. Remove current's next node
	// time complexity = O(n)
	public void removeAtReverseIndexIterateOnce(int rPos) throws Exception {

		// Null list
		if(this.head.getNext()==null) {
			System.out.println("Null list");
			return;
		}
		
		// Single node list
		if(this.head.getNext().getNext()==null) {
			// Single node list, rPos can only be 1, then clear list
			if(rPos > 1) {
				throw new Exception("Out of range!");
			}
			this.head.setNext(null);
			this.rear.setNext(null);
			this.current.setNext(null);
			this.length = 0;
			System.out.println("List changed to null");
			return;
		}
		
		// List with more than 1 node
		int interval = rPos - 1; // interval between the rPos and the rear (last 1)
		SingleLinkedListNode far = new SingleLinkedListNode();
		this.current.setNext(this.head.getNext());
		far.setNext(this.head.getNext());
		// Set far pointer
		for(int i=1;i<=interval;i++) {
			far.setNext(far.getNext().getNext());
		}
		
		// if far is rear, then remove head
		if(far.getNext().getNext()==null) {
			this.head.setNext(this.head.getNext().getNext());
			this.current.setNext(this.head.getNext());
			this.length--;
			System.out.println("Head removed");
			return;
		}
		
		// Iterate to move far and current, to 1 position before rear and the node to be removed
		while(far.getNext().getNext().getNext()!=null) {
			far.setNext(far.getNext().getNext());
			this.current.setNext(this.current.getNext().getNext());
		}
		this.current.getNext().setNext(this.current.getNext().getNext().getNext());
		
		// Set flag
		if(this.current.getNext().getNext()==null) {
			this.rear.setNext(this.current.getNext());
		}
		this.length--;
		
	}
	
	// LeetCode: Get the node in the middle of the list, if node number is even, return the 2nd middle node
	// Completed in IntSingleList
}
