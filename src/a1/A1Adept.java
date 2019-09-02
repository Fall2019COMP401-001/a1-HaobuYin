package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		// Create catalog of items in the store
		int count = scan.nextInt();
		String[] nameOfItems = new String[count];
		double[] priceOfItems = new double[count];
		for (int i=0;i<count;i++) {
			nameOfItems[i] = scan.next();
			priceOfItems[i] = scan.nextDouble();
		}

		// Create catalog of customers
		int count2 = scan.nextInt();
		String[] nameOfCus = new String[count2];
		int[] itemsKinds = new int[count2];
		double[] totalPrice = new double[count2];
		for (int i=0;i<count2;i++) {
			nameOfCus[i] = scan.next()+" "+scan.next();
			itemsKinds[i] = scan.nextInt();
			for (int j=0;j<itemsKinds[i];j++) {
				totalPrice[i] = totalPrice[i] + scan.nextInt() * findPrice(scan.next(), nameOfItems, priceOfItems);
			}
		}
		

		scan.close();
		
		System.out.println("Biggest:"+findCustomer(big(totalPrice), totalPrice, nameOfCus)+" " + String.format("%.2f", big(totalPrice)));
		System.out.println("Smallest:"+findCustomer(small(totalPrice), totalPrice, nameOfCus)+" " + String.format("%.2f", small(totalPrice)));
		System.out.println("Average:"+ " " + String.format("%.2f", average(totalPrice)));
	}
		/* findPrice
		 * input: name of item in store
		 * output: according price
		 * precondition: input can't be null
		 */
		
		static double findPrice (String target, String[] a, double[] b){
			for (int i=0; i < a.length; i++) {
				if (a[i].equals(target))
				    return b[i];
			}
		    return 1;
		}
		static String findCustomer (double target, double[] a, String[] b) {
			for (int i=0; i < a.length; i++) {
				if (a[i]==target) {
					return b[i];
				}
			}
			return "error";
		}
		/* biggest,smallest,average
		 * input double[] totalPrice
		 * output: double
		 * precondition: input can't be null
		 */
		static double big (double[] a) {
			double curMax = a[0];
			for (int i=1; i<a.length; i++) {
				if(a[i]>curMax) {
					curMax = a[i];
				}
			}
			return curMax;
		}
		static double small (double[] a) {
			double curMin = a[0];
			for (int i=1; i<a.length; i++) {
				if(a[i]<curMin) {
					curMin = a[i];
				}
			}
			return curMin;
		}
		static double average (double[] a) {
			double t = 0;
			for (int i=0; i<a.length; i++) {
				t=t+a[i];
			}
			return t/a.length;
		}
}
