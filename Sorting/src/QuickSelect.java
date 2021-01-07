import java.util.Random;

public class QuickSelect {
	static int n = 10;
	static int count;
	static int totalCount = 0;
	static Random rand = new Random();
	static int k = rand.nextInt(n)+1;
	public static void main(String[] args) {
		int [] arr = new int [n];
		System.out.print("Unsorted array :     ");
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100);
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		int ik = k-1;
		int kth = quickSelect(arr,0,arr.length-1,ik);
		System.out.print("After quick select : ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		System.out.println("There are " + totalCount + " comparisons when the " + k + "th is reached");
		System.out.println("The " + k + "th order statistic is " + kth);
	}
	public static int quickSelect(int a[], int low, int high, int k) {
		if (low == high) return a[low];
		int pivot = partition(a, low, high);
		if (k == pivot) 
			return a[k];
		if (k < pivot)
			return quickSelect(a, low, pivot-1, k);
		else
			return quickSelect(a, pivot+1, high, k);
	}
	public static int partition(int a[], int low, int high) {
		count = 0;
		int pivotValue = a[high];
		int i = low;
		for (int j = low; j < high; ++j) {
			count++;
			if (a[j] < pivotValue)
	            swap(a, i++, j);
		}
		swap(a, i, high);
		totalCount += count;
		//System.out.println(count);
		return i;
	}
	private static void swap(int[] a, int i, int j) {
	      int temp = a[i];
	      a[i] = a[j];
	      a[j] = temp;
	   }
}
