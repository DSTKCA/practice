package com.dstk.practice.java.linkedlist;

public class SingleLinkedListNode {
	
	private String data;
	private SingleLinkedListNode next;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public SingleLinkedListNode getNext() {
		return next;
	}
	public void setNext(SingleLinkedListNode next) {
		this.next = next;
	}
	
	public SingleLinkedListNode() {
		this.data = null;
		this.next = null;
//		this.next = new SingleLinkedListNode(); // This will cause dead loop
	}
	
	public SingleLinkedListNode(String data, SingleLinkedListNode next) {
		this.data = data;
		this.next = next;
	}
	
	public void printNodeValue() {
		if (this.data!=null) {
			System.out.println("Node value: " + this.data);
		}
	}
}
