import java.util.Random;

public class InsertionSort {
	static int n = 10;
	static long count;
	public static void main(String[] args) {
		Random rand = new Random();
		int k = rand.nextInt(n)+1;
		int [] arr = new int [n];
		System.out.print("Unsorted array : ");
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100);
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		int kth = searchWithInsertionSort(arr, k);
		System.out.println("The " + k + "th order statistic is " + kth);
	}
	public static int searchWithInsertionSort(int a[], int k) {
		count = 0;
		int temp,j;
		for(int i = 1; i < a.length; i++) {
			temp = a[i];
			for(j = i - 1; j >= 0 && a[j] >temp ; j--) {
				count++;
				a[j+1] = a[j];
			}
			if(j>=0) {
				if(a[i]>a[j])
					count++;
			}
			a[j+1] = temp;
		}
		System.out.print("Sorted array :   ");
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i]+ " ");
		}
		System.out.println();
		System.out.println("There are " + count + " comparisons");
		return a[k-1];
	}
}
