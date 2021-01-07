import java.util.Arrays;
import java.util.Random;

public class MedianOfmedians {
	static int n = 10;
	static int count = 0;
	public static void main(String[] args) {
		Random rand = new Random();
		int k = rand.nextInt(n)+1;
		int [] arr = new int [n];
		System.out.print("Unsorted array:          ");
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100);
			System.out.print(arr[i]+ " ");
		}
		int kth = getKthSmallestQuickSelectWorstCaseLinearTime(arr, 0, arr.length - 1, k);
		System.out.print("\nAfter median of medians: ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		System.out.println("There are " + count + " comparisons");
		System.out.println("The " + k + "th order statistic is " + kth);
		
	}
	private static int getKthSmallestQuickSelectWorstCaseLinearTime(int arr[], int low, int high, int k) {

        if (k > 0 && k <= high - low + 1) {
            // number of elements in array
            int n = high - low + 1;

            int i, median[] = new int[(n + 4) / 5];

            for (i = 0; i < median.length - 1; i++) {
                median[i] = getMedian(Arrays.copyOfRange(arr, 5 * i + low, 5 * i + low + 4), 5);
            }

            if (n % 5 == 0) {
                median[i] = getMedian(Arrays.copyOfRange(arr, 5 * i + low, 5 * i + low + 4), 5);
                i++;
            } else {
                median[i] = getMedian(Arrays.copyOfRange(arr, 5 * i + low, 5 * i + low + (n % 5)), n % 5);
                i++;
            }

            int medOfMed = i == 1 ? median[i - 1]
                    : getKthSmallestQuickSelectWorstCaseLinearTime(median, 0, i - 1, i / 2);

            int partition = partitionPractise(arr, low, high, medOfMed);

            if (partition - low == k - 1) {
                return arr[partition];
            }

            if (partition - low > k - 1) {
                return getKthSmallestQuickSelectWorstCaseLinearTime(arr, low, partition - 1, k);
            }

            return getKthSmallestQuickSelectWorstCaseLinearTime(arr, partition + 1, high, k - (partition + 1) + low);
        }

        return -1;
    }

    private static int getMedian(int arr[], int n) {
        Arrays.sort(arr);
        return arr[n / 2];
    }


    private static void swap(int[] arr, int i, int index) {
        if (arr[i] == arr[index]) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }

    private static int partitionPractise(int[] arr, int low, int high, int pivot) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == pivot) {
                swap(arr, i, high);
                break;
            }
        }
        int index = low - 1;
        int i = low;
        while (i < high) {
        	count++;
            if (arr[i] < pivot) {
                index++;
                swap(arr, i, index);
            }
            i++;
        }
        index++;
        swap(arr, index, high);
        return index;
    }

}

	
	

