package com.dstk.practice.java.linkedlist;

public class IntSingleListNode {
	private int data;
	private IntSingleListNode next;
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public IntSingleListNode getNext() {
		return next;
	}
	public void setNext(IntSingleListNode next) {
		this.next = next;
	}
	
	public IntSingleListNode() {
		this.data = 0;
		this.next = null;
//		this.next = new IntSingleListNode(); // This will cause dead loop
	}
	
	public IntSingleListNode(int data, IntSingleListNode next) {
		this.data = data;
		this.next = next;
	}
	
	public void printNodeValue() {
		System.out.println("Node value: " + this.data);
	}
}
