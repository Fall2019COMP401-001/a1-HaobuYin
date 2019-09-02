package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here
		// Declaring variables
		int count =scan.nextInt();
		String[] firstNames = new String[count];
		String[] lastNames = new String[count];
		int[] itemsKinds = new int[count];
		int[] itemNums = new int[count];
		String[] itemNames = new String[count];
		double[] itemPrices = new double[count];
		double[] totalPrice = new double[count];
		
		// Read input from customers
		for (int i=0; i<count; i++) {
		    firstNames[i]=scan.next();
		    lastNames[i] =scan.next();
		    itemsKinds[i] =scan.nextInt();
		    for (int j=0; j<itemsKinds[i];j++) {
		        itemNums[j] = scan.nextInt();
		        itemNames[j] = scan.next();
                itemPrices[j] = scan.nextDouble();
                totalPrice[i] = totalPrice[i] + itemNums[j] * itemPrices[j];
		   }
		}
		scan.close();
		
		for (int i=0;i<count;i++) {
		System.out.println(nameEditor(firstNames[i], lastNames[i])+ " " + String.format("%.2f", totalPrice[i]));
		}
	}
		
		/* nameEditor
		 * input first name and last name
		 * output: a string
		 * precondition: input can't be null
		 */
		static String nameEditor (String a, String b) {
			return a.charAt(0) + ". "+b+":";
		}
		
}
