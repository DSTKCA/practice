package com.dstk.practice.java.linkedlist;

public class LinkedListHandler {
	
	// LeetCode exam
	// Merge 2 sequential lists into a new sequential list
	// Algorithm:
	// Iterate 2 list, until one of them is null:
	// compare head, move the smaller one into the new list and remove it from
	// origin list
	// After iteration, check if there's any left nodes, if yes, append them into
	// rear
	public static IntSingleList mergeList(IntSingleList aList, IntSingleList bList) throws Exception {

		// Args check
		if (aList.getHead().getNext() == null || bList.getHead().getNext() == null) {
			throw new Exception("Cannot compare and merge null list!");
		}

		if (aList.getHead().getNext() == null && bList.getHead().getNext() != null) {
			System.out.println("List a is null, return list b.");
			return bList;
		} else if (aList.getHead().getNext() != null && bList.getHead().getNext() == null) {
			System.out.println("List b is null, return list a.");
			return aList;
		}

		// Set the flag of input lists
		aList.getCurrent().setNext(aList.getHead().getNext());
		bList.getCurrent().setNext(bList.getHead().getNext());

		// Init merged list with head
		IntSingleList mergedList = new IntSingleList();
		if (aList.getHead().getNext().getData() >= bList.getHead().getNext().getData()) {
			mergedList.getHead().setNext(bList.getHead().getNext());
			bList.getCurrent().setNext(bList.getHead().getNext());
			bList.getCurrent().setNext(bList.getCurrent().getNext().getNext());
		} else {
			mergedList.getHead().setNext(aList.getHead().getNext());
			aList.getCurrent().setNext(aList.getHead().getNext());
			aList.getCurrent().setNext(aList.getCurrent().getNext().getNext());
		}
		// Set rear of merged list for next step iteration usage
		mergedList.getRear().setNext(mergedList.getHead().getNext());
		// Length flag;
		mergedList.setLength(aList.getLength() + bList.getLength());

		// Iteration comparison and appending
		while (aList.getCurrent().getNext() != null && bList.getCurrent().getNext() != null) {
			// 1. compare current, move the smaller one into merged list rear
			// 2. move current to next node
			if (aList.getCurrent().getNext().getData() >= bList.getCurrent().getNext().getData()) {
				mergedList.getRear().getNext().setNext(bList.getCurrent().getNext());
				mergedList.getRear().setNext(mergedList.getRear().getNext().getNext());
				bList.getCurrent().setNext(bList.getCurrent().getNext().getNext());
			} else {
				mergedList.getRear().getNext().setNext(aList.getCurrent().getNext());
				mergedList.getRear().setNext(mergedList.getRear().getNext().getNext());
				aList.getCurrent().setNext(aList.getCurrent().getNext().getNext());
			}
		}

		// append remained part of 1 out of 2 list
		if (aList.getCurrent().getNext() != null) {
			mergedList.getRear().getNext().setNext(aList.getCurrent().getNext());
			mergedList.getRear().setNext(aList.getRear().getNext());
		} else {
			mergedList.getRear().getNext().setNext(bList.getCurrent().getNext());
			mergedList.getRear().setNext(bList.getRear().getNext());
		}

		// Set flags
		mergedList.getCurrent().setNext(mergedList.getHead().getNext());

		// return merged list
		return mergedList;
	}
}
