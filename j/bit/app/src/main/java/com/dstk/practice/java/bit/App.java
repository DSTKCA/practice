/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.dstk.practice.java.bit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

	final static Logger logger = LoggerFactory.getLogger(App.class);

	public String getGreeting() {
		return "Hello World!";
	}

	public static void main(String[] args) throws IOException {

		// The milliseconds indicate the running time of the app
		// It shows the single line 'System.out.println' will not impact performance,
		// hence it can be used in the experiment apps.
		// But since there's synchronized method invoking,
		// ENSURE it's NOT used in any loop/iteration of the testing apps
		// NOR in any production apps.
		long currentMillis = java.lang.System.currentTimeMillis();
//		logger.info(new App().getGreeting());
		System.out.println(new App().getGreeting());
		logger.info(String.format("Hello world running time: %d milliseconds.",
				java.lang.System.currentTimeMillis() - currentMillis));

		// Using Scanner for Getting Input from User

		// -- Concept -- : Bitwise AND &, inclusive OR |
		logger.info("Enter 2 numbers: ");
		Scanner in = new Scanner(System.in); // Another method is to use BufferedReader and InputStreamReader
		String inStr = in.nextLine();
//		String[] intArray = inStr.split(",", 2); //https://www.geeksforgeeks.org/split-string-java-examples
		String[] intArray = inStr.split(",");
		logger.info(String.format("Entered numbers: %s", Arrays.toString(intArray)));
		// 5 & 6 = 4
		logger.info(String.format("Bitwise AND (&) value of %s is %d", Arrays.toString(intArray),
				(Integer.parseInt(intArray[0]) & Integer.parseInt(intArray[1]))));
		// 5 | 6 = 7
		logger.info(String.format("Bitwise OR (|) value of %s is %d", Arrays.toString(intArray),
				(Integer.parseInt(intArray[0]) | Integer.parseInt(intArray[1]))));

		// -- Concept -- : theorem
		// n & -1 = n
		logger.info(String.format("n & -1 = n, given n = 100, n & -1 = %d", (100 & -1)));

		// -- Concept -- : Bitwise exclusive OR ^ (XOR, EOR, XEOR)
		// n ^ 0 = n
		logger.info(String.format("n ^ 0 = n, given n = 100, n ^ 0 = %d", (100 ^ 0)));
		// n ^ n = 0
		logger.info(String.format("n ^ n = 0, given n = 100, n ^ n = %d", (100 ^ 100)));
		// 0 ^ 0 = 0
		logger.info(String.format("0 ^ 0 = %d", (0 ^ 0)));

		// -- Concept -- : Commutative law of XOR
		// a ^ a ^ b = b
		logger.info(String.format("a = %d, b = %d, a ^ b = %d, b ^ a = %d", Integer.parseInt(intArray[0]),
				Integer.parseInt(intArray[1]), (Integer.parseInt(intArray[0]) & Integer.parseInt(intArray[1])),
				(Integer.parseInt(intArray[1]) & Integer.parseInt(intArray[0]))));

		// -- Concept -- : Logic AND and OR have 2 types (Not in the scope of this app):
		// 1. Short-circuit
		// 2. Non short-circuit
		// Logical exclusive OR ^ (there's no short-circuit exclusive OR, since both
		// value must be evaluated before the operation)
		logger.info(String.format("true ^ false = %b", (true ^ false)));
		logger.info(String.format("true ^ true = %b", (true ^ true)));
		logger.info(String.format("false ^ false = %b", (false ^ false)));

		// -- Concept -- : Bitwise flip
		// Given x => ~x = - (x + 1)
		// Should equal to -11
		logger.info(String.format("Given 10: ~10 = %d", ~10));

		// -- Concept -- : Bitwise shift - Left << (signed)
		// All bits left shift, and the most right bits filled by '0'
		// Given x => left shift N bits = x * (2 to the Nth power)
		// Useful exp: 1 << N = 2 to the Nth power, e.g. 1 << 3 = 2 * 2 * 2
		// Exception:
		// 1. Max shift bit number for integer is 31, for long is 63,
		// 2. until the significant bit changed, since it means the sign of the number
		// changed
		logger.info(String.format("Given 10: 10 << 3 = %d", 10 << 3));

		// -- Concept -- : Bitwise shift - Right >> (signed)
		// All bits right shift, and:
		// if positive number, significant bit is 0, then the most left bits filled by
		// '0',
		// -> given x => right shift N bits = x / (2 to the Nth power)
		// if negative number, significant bit is 1, then the most left bits filled by
		// '1'
		// -> given x =>
		// -> if x % 2 == 0, right shift N bits = x / (2 to the Nth power)
		// -> if x % 2 !- 0, right shift N bits = x / (2 to the Nth power) - 1
		logger.info(String.format("Given 10: 10 >> 3 = %d", 10 >> 3));
		logger.info(String.format("Given -16: -16 >> 3 = %d", -16 >> 3));
		logger.info(String.format("Given -9: -9 >> 3 = %d", -9 >> 3));

		// -- Concept -- : Given byte/short/int x: if x >= 0, then x >> 31 = 0, else x
		// >> 31 = -1
		int n0 = 65535;
		logger.info(String.format("Given int 65535: 65535 >> 31 = %d", n0 >> 31));
		n0 = 0;
		logger.info(String.format("Given int 0: 0 >> 31 = %d", n0 >> 31));
		n0 = -65535;
		logger.info(String.format("Given int -65535: -65535 >> 31 = %d", n0 >> 31));

		// -- Concept -- : Given long x, if x >= 0, then x >> 63 = 0, else x >> 63 = -1
		long nLong = 65535;
		logger.info(String.format("Given long 65535: 65535 >> 63 = %d", nLong >> 63));
		nLong = 0;
		logger.info(String.format("Given long 0: 0 >> 63 = %d", nLong >> 63));
		nLong = -65535;
		logger.info(String.format("Given long -65535: -65535 >> 63 = %d", nLong >> 63));

		// -- Concept -- : Bitwise shift - Right >>> (unsigned)
		// All bits right shift, and the most right bits filled by '0'
		// Given x =>
		// if x >= 0, then x >>> N = x >> N
		// if x < 0, then x >>> N will return a positive number
		logger.info(String.format("Given 10: 10 >>> 3 = %d", 10 >>> 3));
		logger.info(String.format("Given -16: -16 >>> 3 = %d", -16 >>> 3));

		// -- Algorithm -- : Judge if an integer even or odd
		// Given x, if x & 1 = 0 => x is even, else x is odd
		logger.info("Enter the number you want to check even/odd: ");
		int nEvenOdd = in.nextInt();
		logger.info(String.format("Entered number '%d' is %s", nEvenOdd, (nEvenOdd & 1) == 0 ? "even" : "odd"));

		// -- Concept -- : A bit value XOR 0 equals to itself.
		// Given integer x:
		// -- Concept -- : => 1. x ^ 0 = x
		logger.info(String.format("Given 100: 100 ^ 0 = %d", 100 ^ 0));
		logger.info(String.format("Given -100: -100 ^ 0 = %d", -100 ^ 0));
		logger.info(String.format("Given 0: 0 ^ 0 = %d", 0 ^ 0));
		// -- Concept -- : => 2. (x ^ -1) + 1 = -x
		// Be careful about the precedence of the operator. All + - * / % > <, ...
		// higher than ^
		// Use bracket to ensure the operation order
		logger.info(String.format("Given -100: (-100 ^ -1) + 1 = %d", (-100 ^ -1) + 1));
		logger.info(String.format("Given 100: (100 ^ -1) + 1 = %d", (100 ^ -1) + 1));
		logger.info(String.format("Given 0: (0 ^ -1) + 1 = %d", (0 ^ -1) + 1));

		// -- Algorithm -- : Calculate ABS (absolute value) of an integer
		// Solution:
		// According to:
		// 1. if x >=0, x >> 31/63 = 0, else x >> 31/63 = -1
		// 2. given integer x, then: x ^ 0 = x, and (x ^ -1) + 1 = -x
		// => if (x >= 0) abs = (x ^ (x >> 31/63)) +/- 0 (-(x >> 31/63))
		// else abs = (x ^ (x >> 31/63)) + 1 (- (x >> 31/63))
		logger.info("Enter the number as the argument for ABS:");
		int nAbs = in.nextInt();
		logger.info(String.format("ABS of %d: %d", nAbs, (nAbs ^ (nAbs >> 31)) - (nAbs >> 31)));

		// -- Algorithm -- : Swap 2 integer's value, no 3rd/temp variable

		// Solution 1: swap with temp variable, NOT fulfill requirement
		logger.info("Enter 2 numbers for swapping (temp variable):");
		in.nextLine(); // Just to consume the last line to ensure user input
		String inSwap = in.nextLine();
		String[] strArrSwap = inSwap.split(",");
		logger.info(String.format("Entered numbers: %s", Arrays.toString(strArrSwap)));
		// Init 2 variable
		int nSwap1 = Integer.parseInt(strArrSwap[0]);
		int nSwap2 = Integer.parseInt(strArrSwap[1]);
		// Use temp variable
		int nSwapTemp = nSwap1;
		nSwap1 = nSwap2;
		nSwap2 = nSwapTemp;
		logger.info(String.format("Swapped with temp variable, now a = %d b = %d", nSwap1, nSwap2));

		// Solution 2: Use sum but Not temp variable
		// Disadvantage: if the 2 numbers are large, there's risk the sum exceed the
		// range of data type
		logger.info("Enter 2 numbers for swapping (sum):");
		String inSwap2 = in.nextLine();
		String[] strArrSwap2 = inSwap2.split(",");
		logger.info(String.format("Entered numbers: %s", Arrays.toString(strArrSwap2)));
		// Init 2 variable
		int nSwap11 = Integer.parseInt(strArrSwap2[0]);
		int nSwap22 = Integer.parseInt(strArrSwap2[1]);
		// Use sum
		nSwap11 = nSwap11 + nSwap22;
		nSwap22 = nSwap11 - nSwap22;
		nSwap11 = nSwap11 - nSwap22;
		logger.info(String.format("Swapped with sum, now a = %d b = %d", nSwap11, nSwap22));

		// Solution 3: Use XOR (^)
		// Advantage: no temp variable, no exceed/overflow risk
		// According to:
		// 1. n ^ n = 0
		// 2. a ^ b = b ^ a
		// 3. n ^ 0 = n
		// => a ^ b ^ b = a
		logger.info("Enter 2 numbers for swapping (XOR):");
		String inSwapXor = in.nextLine();
		String[] strArrSwapXor = inSwapXor.split(",");
		logger.info(String.format("Entered numbers: %s", Arrays.toString(strArrSwapXor)));
		// Init 2 variable
		int nSwap111 = Integer.parseInt(strArrSwapXor[0]);
		int nSwap222 = Integer.parseInt(strArrSwapXor[1]);
		// Use XOR
		nSwap111 = nSwap111 ^ nSwap222;
		nSwap222 = nSwap111 ^ nSwap222;
		nSwap111 = nSwap111 ^ nSwap222;
		logger.info(String.format("Swapped with XOR, now a = %d b = %d", nSwap111, nSwap222));

		// -- Algorithm -- : To find the element displayed once (single dog)
		// According to 0 ^ n = n
		int[] intArrSingleDog = { 100, 50, 30, 70, 90, 50, 30, 100, 70 };
		logger.info(String.format("Looking for single dog in the array: %s", Arrays.toString(intArrSingleDog)));
		int nSingleDog = 0;
		for (int i = 0; i < intArrSingleDog.length; i++) {
			nSingleDog = nSingleDog ^ intArrSingleDog[i];
		}
		logger.info(String.format("The single dog in the array: %d", nSingleDog));

		// -- Algorithm -- : Basic String encrypt/decrypt
		// Solution: apply a ^ b ^ b = a, a is the original string, b is the password
		String oriStr = "Man";
		byte pwd = (byte) 198;
		logger.info(String.format("Original string '%s', original bytes '%s', password '%d / %x'", oriStr,
				Arrays.toString(oriStr.getBytes()), pwd, pwd));
		byte[] byteData = oriStr.getBytes();
		// Encryption
		for (int i = 0; i < oriStr.getBytes().length; i++) {
			byteData[i] = (byte) (byteData[i] ^ pwd);
		}
		logger.info(String.format("The encrypted bytes: %s corresponding to string '%s'", Arrays.toString(byteData),
				new String(byteData))); // TODO: Base16, Base32, Base64 format in another practice
		// Decryption
		for (int i = 0; i < byteData.length; i++) {
			byteData[i] = (byte) (byteData[i] ^ pwd);
		}
		logger.info(String.format("The decrypted bytes: %s corresponding to string '%s'", Arrays.toString(byteData),
				new String(byteData)));

		// -- Algorithm -- : Count how many 1 in a binary number
		// Solution 1: apply if (n & 1) = 0, then the most significant bit is 1, else is
		// 0.
		// Iteration: right shift signed >> 31/63 bits and count the number '1'
		logger.info("Enter the number to count '1' - solution 1:");
		int inNumShort = in.nextShort(); // Be careful about the data type and value range
		in.nextLine(); // To avoid nextLine not consumed issue
		int count = 0;
		int oriNumShort = inNumShort;

		for (int i = 0; i < 32; i++) {
			if ((inNumShort & 1) == 1) {
				count++;
			}
			inNumShort = (short) (inNumShort >> 1);
		}
		logger.info(String.format("There're %d '1' in the binary %s", count, Integer.toBinaryString(oriNumShort)));

		// Solution 2: if ((a >> 1) << 1) != a, then the least significant bit is 1,
		// else is 0
		// Iteration unsigned right shift >>> 31/63 bits and count the number '1'
		logger.info("Enter the number to count '1' - solution 2:");
		int inNumShort2 = in.nextShort(); // Be careful about the data type and value range
		in.nextLine(); // To avoid nextLine not consumed issue
		int count2 = 0;
		int oriNumShort2 = inNumShort2;

		while (inNumShort2 != 0) {
			if (((inNumShort2 >> 1) << 1) != inNumShort2) {
				count2++;
			}
			inNumShort2 = (inNumShort2 >>> 1);
		}
		logger.info(String.format("There're %d '1' in the binary %s", count2, Integer.toBinaryString(oriNumShort2)));

		// -- Algorithm -- : Judge if a number is the exponent of 2.
		// Solution: according to:
		// 1. exponent of 2 can only be positive number
		// 2. exponent of 2's binary number format is 1000...0 (start with 1 and all
		// bits after it are 0)
		// => given n is exponent of 2, (n - 1)'s format is 000...01 (only the most
		// significant bit is 1, and all other bits are 0)
		// => n & (n - 1) = 0
		logger.info("Enter the number to check if it's the exponent of '2':");
		int inNumEx = in.nextShort(); // Be careful about the data type and value range
		in.nextLine(); // To avoid nextLine not consumed issue
		if ((inNumEx & (inNumEx - 1)) == 0) { // 1st solution
			logger.info(String.format("The number %d IS an exponent of 2", inNumEx));
		} else {
			logger.info(String.format("The number %d IS NOT an exponent of 2", inNumEx));
		}

		// -- Algorithm -- : Get all the subset of a set (prerequisite: there's no
		// duplicated item)
		// Solution: according to:
		// 1. the set can be represented by a bit array (binary number)
		// 2. an item corresponds to a bit, if the bit value == 1, then the sub set
		// contains this item, otherwise NO.
		// 3. The possible combination scenario number = the Nth power of 2 (there're N
		// bits of the binary number)
		// => all subsets are all the binary number <= original binary number, include 0
		// , and the possible subsets can be built by iterating all bits of each binary.
		// (from 0 to Nth exponent of 2 (1<<N), use >>>, and check least significant bit)
		logger.info("Enter all items of the set, null or duplicated are not accepted:");
		String inStrArry = in.nextLine(); // To avoid nextLine not consumed issue
		String[] items = inStrArry.split(",");
		int nBit = items.length; // Item number, used to get the combination number and iteration
		int nIt = 1 << nBit;
		List<List<String>> subSets = new ArrayList<List<String>>();
		// Need to take care of if 1<<nBit change to negative
		if (nIt < 0) {
//			System.out.println("Exceeded the capacity!");
			logger.info("Exceeded the capacity!");
			in.close();
			return;
		}
		for (int i = 0; i < nIt; i++) {
			// Corresponding binary
			int iBin = i;
			int offset = nBit-1;
			List<String> aSet = new ArrayList<String>();
			while (iBin != 0) {
				if ((iBin & 1) == 1) {
					aSet.add(items[offset]);
				}
				iBin = (iBin >> 1);
				offset--;
			}
			subSets.add(aSet);
		}
		for (int i = 0; i < subSets.size(); i++) {
//			System.out.println(String.format("Subset %d %s", i, subSets.get(i).toString())); // To compare the performance
			logger.info(String.format("Subset %d %s", i, subSets.get(i).toString()));
		}

		in.close();

	}
}
