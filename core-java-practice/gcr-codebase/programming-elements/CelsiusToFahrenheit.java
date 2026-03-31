package com.alpha;

import java.util.Scanner;

public class CelsiusToFahrenheit {
	
	public static float convert(float celTemp) {
		float fahTemp = 9 * (celTemp / 5) + 32;
		return fahTemp;
	}
	
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		float temp = sc.nextFloat();
		float res = convert(temp);
		System.out.println(res + " deg Fah");
	}
}
