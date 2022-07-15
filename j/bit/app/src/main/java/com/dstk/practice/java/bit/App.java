/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.dstk.practice.java.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		Scanner in = new Scanner(System.in);
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

		// -- Concept -- : Bitwise exclusive OR ^ (XOR, EOR, XEOR)
		// 1 ^ 0 = 1
		logger.info(String.format("1 ^ 0 = %d", (1 ^ 0)));
		// 1 ^ 1 = 0
		logger.info(String.format("1 ^ 1 = %d", (1 ^ 1)));
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
		// if positive number, significant bit is 0, then the most left bits filled by '0',
		// -> given x => right shift N bits = x / (2 to the Nth power)
		// if negative number, significant bit is 1, then the most left bits filled by '1'
		// -> given x =>
		// -> if x % 2 == 0, right shift N bits = x / (2 to the Nth power)
		// -> if x % 2 !- 0, right shift N bits = x / (2 to the Nth power) - 1
		logger.info(String.format("Given 10: 10 >> 3 = %d", 10 >> 3));
		logger.info(String.format("Given -16: -16 >> 3 = %d", -16 >> 3));
		logger.info(String.format("Given -9: -9 >> 3 = %d", -9 >> 3));
		
		// -- Concept -- : Given byte/short/int x: if x >= 0, then x >> 31 = 0, else x >> 31 = -1
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
		// Be careful about the precedence of the operator. All + - * / % > <, ... higher than ^
		// Use bracket to ensure the operation order
		logger.info(String.format("Given -100: (-100 ^ -1) + 1 = %d", (-100 ^ -1) + 1));
		logger.info(String.format("Given 100: (100 ^ -1) + 1 = %d", (100 ^ -1) + 1));
		logger.info(String.format("Given 0: (0 ^ -1) + 1 = %d", (0 ^ -1) + 1));
		
		// -- Algorithm -- : Calculate ABS (absolute value) of an integer
		// Solution:
		// According to:
		// 1. if x >=0, x >> 31/63 = 0, else x >> 31/63 = -1
		// 2. given integer x: x ^ 0 = x, and (x ^ -1) + 1 = -x
		// => if (x >= 0) abs = (x ^ (x >> 31/63)) +/- 0 (-(x >> 31/63))
		//	  else abs = (x ^ (x >> 31/63)) + 1 (- (x >> 31/63))
		logger.info("Enter the number as the argument for ABS:");
		int nAbs = in.nextInt();
		logger.info(String.format("ABS of %d: %d", nAbs, (nAbs ^ (nAbs >> 31)) - (nAbs >> 31)));

		in.close();

	}
}