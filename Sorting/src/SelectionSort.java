import java.util.Random;

public class SelectionSort {
	static int n = 10;
	static long count;
	public static void main(String[] args) {
		Random rand = new Random();
		int k = rand.nextInt(n)+1;
		int [] arr = new int [n];
		System.out.print("Unsorted array :       ");
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100);
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		int kth = selectionSort(arr,k);
		System.out.println("The " + k + "th order statistic is " + kth);
	}
	public static int selectionSort(int[] a, int k) {
		count = 0;
		int mid = a.length/2;
		if(k <= mid) {
			for (int i = 0; i < k; ++i) {
				int min = i;
		        for (int j = i+1; j < a.length; ++j) { // Find the smallest element in the unsorted portion
		        	count++;
		        	if (a[j] < a[min])
		        		min = j;
		        }
		     // Swap it into the correct spot
		        int temp = a[i];
		        a[i] = a[min];
		        a[min] = temp;
			}
		}
		else if(k > mid) {
			for (int i = 0; i <= a.length-k; ++i) {
				int max = 0;
		        for (int j = 1; j < a.length-i; ++j) { // Find the largest element in the unsorted portion
		        	count++;
		        	if (a[j] > a[max])
		        		max = j;
		        }
		     // Swap it into the correct spot
		        int temp = a[a.length-i-1];
		        a[a.length-i-1] = a[max];
		        a[max] = temp;
			}
		}
		System.out.print("Partial sorted array : ");
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i]+ " ");
		}
		System.out.println();
		System.out.println("There are " + count + " comparisons");
	    return a[k-1];
	}
}
