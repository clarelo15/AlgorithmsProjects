import java.util.Random;

public class HeapSort {
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
		heapSort(arr);
		System.out.println("There are " + totalCount + " comparisons when the " + k + "th is reached");
	}
	public static void heapSort(int a[]) {
		int n = a.length; 
		int mid = n/2;
		if(k <= mid) {
			for (int i = n / 2 - 1; i >= 0; i--)           //Build heap (rearrange array)
				minHeapify(a, n, i);
			for (int i = n-1; i >= 0; i--) {                   // One by one extract an element from heap
				if(k+i < n) {
					System.out.print("Partial sorted array : ");
					for(int j = a.length-1; j >= 0; j--) {
						System.out.print(a[j]+ " ");
					}
					System.out.println("\nThe " + k + "th order statistic is " + a[a.length-k]);
					return;
				}
				int temp = a[0];                           // Move current root to end
	            a[0] = a[i]; 
	            a[i] = temp;
	            minHeapify(a, i, 0);                          // call min heapify on the reduced heap
			}
		}
		else {
			for (int i = n / 2 - 1; i >= 0; i--)           //Build heap (rearrange array)
				maxHeapify(a, n, i);
			for (int i = n-1; i >= 0; i--) {                   // One by one extract an element from heap
				if(k > i+1) {
					System.out.print("Partial sorted array : ");
					for(int j = 0; j <a.length ; j++) {
						System.out.print(a[j]+ " ");
					}
					System.out.println("\nThe " + k + "th order statistic is " + a[k-1]);
					return;
				}
				int temp = a[0];                           // Move current root to end
	            a[0] = a[i]; 
	            a[i] = temp;
	            maxHeapify(a, i, 0);                          // call max heapify on the reduced heap
			}
		}
		
	}
    public static void maxHeapify(int a[], int n, int root) {
    	count = 0;
    	int largest = root;
    	int left = 2*root+1;
    	int right = 2*root+2;
    	count++;
    	if (left < n && a[left] > a[largest])
    		largest = left;
    	count++;
    	if (right < n && a[right] > a[largest])
    		largest = right;
    	if (largest != root) {
    		int temp = a[root];
    		a[root] = a[largest];
    		a[largest] = temp;
    		maxHeapify(a, n, largest);
    	}
    	totalCount += count;
    }
    public static void minHeapify(int a[], int n, int root) {
    	count = 0;
    	int smallest = root;
    	int left = 2*root+1;
    	int right = 2*root+2;
    	count++;
    	if (left < n && a[left] < a[smallest])
    		smallest = left;
    	count++;
    	if (right < n && a[right] < a[smallest])
    		smallest = right;
    	if (smallest != root) {
    		int temp = a[root];
    		a[root] = a[smallest];
    		a[smallest] = temp;
    		minHeapify(a, n, smallest);
    	}
    	totalCount += count;
    }
}
