import java.util.Random;

public class MergeSort {
	static int n = 10;
	static int count;
	static int totalCount = 0;
	static Random rand = new Random();
	static int k = rand.nextInt(n)+1;
	public static void main(String[] args) {
		int [] arr = new int [n];
		System.out.print("Unsorted array :       ");
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100);
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		mergeSort(arr,0,arr.length-1);
		System.out.print("Partial sorted array : ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		System.out.println("There are " + totalCount + " comparisons when the " + k + "th is reached");
		System.out.println("The " + k + "th order statistic is " + arr[k-1]);
	}
	public static void mergeSort(int a[], int low, int high) {
		int mid = 0;
		if(low < high) {
			mid = low + (high-low)/2;
			mergeSort(a,low,mid);
			mergeSort(a,mid+1,high);
			merge(a,low,mid,high);
		}
	}
	public static void merge(int a[], int low, int mid, int high) {
		count = 0;
		int [] left = new int[mid-low+1];
		int [] right = new int [high-mid];
		for (int i = 0; i < left.length; i++)
			left[i] = a[low+i];
		for (int j = 0; j < right.length; j++)
			right[j] = a[mid+1+j];
		int i = 0, j = 0; 
		  
        // Initial index of merged subarry array 
        int l = low; 
        if(low ==0 && high ==a.length-1) {
        	while (i < (mid-low+1) && j < (high-mid)&& l<k) { 
            	count++;
                if (left[i] <= right[j]) { 
                    a[l] = left[i]; 
                    i++; 
                } 
                else{ 
                    a[l] = right[j]; 
                    j++; 
                } 
                l++;
            } 
      
            // Copy remaining elements of L[] if any 
            while (i < (mid-low+1)) { 
                a[l] = left[i]; 
                i++; 
                l++; 
            } 
            while (j < (high-mid)) { 
                a[l] = right[j]; 
                j++; 
                l++; 
            }
        }else {
        	while (i < (mid-low+1) && j < (high-mid)) { 
            	count++;
                if (left[i] <= right[j]) { 
                    a[l] = left[i]; 
                    i++; 
                } 
                else{ 
                    a[l] = right[j]; 
                    j++; 
                } 
                l++;
            } 
      
            // Copy remaining elements of L[] if any 
            while (i < (mid-low+1)) { 
                a[l] = left[i]; 
                i++; 
                l++; 
            } 
            while (j < (high-mid)) { 
                a[l] = right[j]; 
                j++; 
                l++; 
            }
        }
        totalCount += count;
        
	}
}
