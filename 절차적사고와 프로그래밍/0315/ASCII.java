package hw;

import java.util.Scanner;

public class ASCII {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String a = in.nextLine();
		String b = in.next();
		
		try {
			int num1 = Integer.parseInt(a);
			int num2 = Integer.parseInt(b);
			
			System.out.println("Integer1: " + a);
			System.out.println("Integer2: " + b);
			
			int sum = num1 + num2;
			
			System.out.println("Sum: " + sum);
			
			char ch = (char)sum;
			byte by = (byte)ch;
			
			System.out.println("---- ASCII Value ----");
			System.out.println("Character: " + ch);
			System.out.println("Deminical: " + by);
		}
		catch(NumberFormatException e){
			e.printStackTrace();
		}
	}

}
