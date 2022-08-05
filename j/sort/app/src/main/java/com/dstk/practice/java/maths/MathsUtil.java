package com.dstk.practice.java.maths;

public class MathsUtil {

	// SquareRoot with dichotomy
	public static double SquareRoot1(double square, double delta) throws Exception {

		if (square < 0) {
			throw new Exception("Don't input value less than zero!");
		}

		// Special value
		if (square == 1.0) {
			return 1.0;
		}

		// Init upper limit, lower limit, and the potential value
		double limitUpper = square;
		double limitLower = 0;
		double value = square / 2;
		int count = 0;

		// Iterate to check if |value * value - square| < delta
		while ((value * value - square >= delta) || (-(value * value - square) >= delta)) {
			if (value * value - square > 0) {
				limitUpper = value;
				value = (limitUpper + limitLower) / 2;
			} else {
				limitLower = value;
				value = (limitUpper + limitLower) / 2;
			}
			count++;
		}

		return value;
	}

	// SquareRoot with Newton's method
	public static double SquareRoot2(double square, double delta) throws Exception {

		if (square < 0) {
			throw new Exception("Don't input value less than zero!");
		}

		// Special value
		if (square == 1.0) {
			return 1.0;
		}

		// Given curve: y = x^2 -n (n>0)
		// => (-x, 0), (x, 0) are the 2 intersection points of the curve and X-axis
		// => x = Sqrt(n) when y = 0
		//
		// Derivative (tangent slope): f'(x) = 2x
		//
		// Newton's method:
		// xp+1 = xp - f(xp)/f'(xp)
		// => xp+1 = xp - (x^2-n)/2xn = xp/2 + n/2xn = (xp + n/xp) / 2
		//
		// Let x0 = n, iterately get xp+1:
		// this moves the point of tangency close to (x0, 0) gradually
		// when xp+1 - x0 < delta, xp+1 is the square root
		int count = 0;
		double value = square;
		while ((value * value - square >= delta) || ((square - value * value) >= delta)) {
			value = (value + square / value) / 2;
			count++;
		}

		return value;
	}

}
