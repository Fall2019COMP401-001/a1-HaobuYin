package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		// Your code follows here.
		// Create catalog of items in the store
		int count = scan.nextInt();
		String[] nameOfItems = new String[count];
		double[] priceOfItems = new double[count];
		for (int i = 0; i < count; i++) {
			nameOfItems[i] = scan.next();
			priceOfItems[i] = scan.nextDouble();
		}

		// Create catalog of customers
		int count2 = scan.nextInt();
		String[] nameOfCus = new String[count2];
		int[] itemsKinds = new int[count2];
		int[] itemstat = new int[count];
		int[] itemPopu = new int[count];
		double[] totalPrice = new double[count2];
		for (int i = 0; i < count2; i++) {
			nameOfCus[i] = scan.next() + " " + scan.next();
			itemsKinds[i] = scan.nextInt();
			for (int j = 0; j < itemsKinds[i]; j++) {
				int temp = scan.nextInt();
				String target = scan.next();
			    itemPopu[findItem(target, nameOfItems)]++;
				itemstat[findItem(target, nameOfItems)] = itemstat[findItem(target, nameOfItems)] + temp;
				totalPrice[i] = totalPrice[i] + temp * findPrice(target, nameOfItems, priceOfItems);
			}
		}
		scan.close();
		// Create statistic for each item;

		for (int i = 0; i < count; i++) {
			if (itemstat[i] != 0) {
				System.out.println(itemPopu[i]+" custormers bought " + itemstat[i] + " " + nameOfItems[i]);
			} else {
				System.out.println("No customers bought " + nameOfItems[i]);
			}
		}
	}
	/*
	 * findPrice input: name of item in store output: according price precondition:
	 * input can't be null
	 */

	static double findPrice(String target, String[] a, double[] b) {
		for (int i = 0; i < a.length; i++) {
			if (a[i].equals(target))
				return b[i];
		}
		return 1;
	}

	static String findCustomer(double target, double[] a, String[] b) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == target) {
				return b[i];
			}
		}
		return "error";
	}

	static int findItem(String target, String[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i].equals(target))
				return i;
		}
		return 10;
	}

	/*
	 * biggest,smallest,average input double[] totalPrice output: double
	 * precondition: input can't be null
	 */
	static double big(double[] a) {
		double curMax = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > curMax) {
				curMax = a[i];
			}
		}
		return curMax;
	}

	static double small(double[] a) {
		double curMin = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < curMin) {
				curMin = a[i];
			}
		}
		return curMin;
	}

	static double average(double[] a) {
		double t = 0;
		for (int i = 0; i < a.length; i++) {
			t = t + a[i];
		}
		return t / a.length;
	}
}
