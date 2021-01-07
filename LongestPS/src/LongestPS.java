import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LongestPS {
	static int max (int x, int y) { return (x > y)? x : y; } 
	static int longestPalindromicSubsequence(String sequence) { 
    int n = sequence.length(); 
    int i, j, cl; 
    // Create a table to store results of subproblems 
    int L[][] = new int[n][n];  
      
    // Strings of length 1 are palindrome of length 1 
    for (i = 0; i < n; i++) 
        L[i][i] = 1; 
    for (cl=2; cl<=n; cl++) 
    { 
        for (i=0; i<n-cl+1; i++) 
        { 
            j = i+cl-1; 
            if (sequence.charAt(i) == sequence.charAt(j) && cl == 2) 
            L[i][j] = 2; 
            else if (sequence.charAt(i) == sequence.charAt(j)) 
            L[i][j] = L[i+1][j-1] + 2; 
            else
            L[i][j] = max(L[i][j-1], L[i+1][j]); 
        } 
    }    
    return L[0][n-1]; 
	}
	
	static String longestContiguousSubsequence(String a, String b) { 
        int m = a.length(); 
        int n = b.length(); 
        char X[] = a.toCharArray(); 
        char Y[] = b.toCharArray(); 
  
        int L[][] = new int[m + 1][n + 1]; 
        for (int i = 0; i <= m; i++) { 
            for (int j = 0; j <= n; j++) { 
                if (i == 0 || j == 0) { 
                    L[i][j] = 0; 
                } else if (X[i - 1] == Y[j - 1]) { 
                    L[i][j] = L[i - 1][j - 1] + 1; 
                } else { 
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]); 
                } 
            } 
        } 
        int index = L[m][n]; 
        char[] lcs = new char[index + 1];
        int i = m, j = n; 
        while (i > 0 && j > 0) {
        	if (X[i - 1] == Y[j - 1]) { 
                // Put current character in result  
                lcs[index - 1] = X[i - 1]; 
                i--; 
                j--; 
  
                // reduce values of i, j and index  
                index--;
        	}
        	else if (L[i - 1][j] > L[i][j - 1]) { 
                i--; 
            } else { 
                j--; 
            } 
        }
        String ans = ""; 
        for (int x = 0; x < lcs.length; x++) { 
            ans += lcs[x]; 
        } 
        return ans; 
    } 
	static String longestPalSubsequence(String str) { 
        // Find reverse of str  
        String rev = str; 
        rev = reverse(rev); 
  
        // Return LCS of str and its reverse  
        return longestContiguousSubsequence(str, rev); 
    } 
  
    static String reverse(String str) { 
        String ans = ""; 
        // convert String to character array  
        // by using toCharArray  
        char[] try1 = str.toCharArray(); 
  
        for (int i = try1.length - 1; i >= 0; i--) { 
            ans += try1[i]; 
        } 
        return ans; 
    } 
    static void printLCS(String str, int low, int high) { 
        System.out.println(str.substring(low, high + 1)); 
    } 
    static int longestPalSubseq(String str) { 
        int maxLength = 1; // The result (length of LPS) 
  
        int start = 0; 
        int len = str.length(); 
  
        int low, high;
        for (int i = 1; i < len; ++i)  
        { 
            // Find the longest even length palindrome with  
            // center points as i-1 and i. 
            low = i - 1; 
            high = i; 
            while (low >= 0 && high < len 
                    && str.charAt(low) == str.charAt(high)) { 
                if (high - low + 1 > maxLength) { 
                    start = low; 
                    maxLength = high - low + 1; 
                } 
                --low; 
                ++high; 
            } 
            low = i - 1; 
            high = i + 1; 
            while (low >= 0 && high < len 
                    && str.charAt(low) == str.charAt(high)) { 
                if (high - low + 1 > maxLength) { 
                    start = low; 
                    maxLength = high - low + 1; 
                } 
                --low; 
                ++high; 
            } 
        }
        System.out.print("the “longest palindromic non-contiguous subsequence” : \n"); 
        printLCS(str, start, start + maxLength - 1); 
        System.out.println();
  
        return maxLength; 
    } 


	public static void main(String args[]) throws FileNotFoundException {
		  
	        File text = new File("QueensCollegeDescription.txt");
	        System.out.println("The file name : " + text);
	        System.out.println();
	        Scanner scnr = new Scanner(text);
	        String line = null;
	        System.out.println("the content of the file before it was cleaned : ");
	        while(scnr.hasNextLine()){
	            line = scnr.nextLine();
	            System.out.println(line);
	        } 
	        System.out.println();
	        int lengthBefore = line.length();
	        System.out.println("the number of characters before it was cleaned : " + lengthBefore);
	        System.out.println();
	        String lineUpper = line.toUpperCase();
	        //System.out.println(lineUpper);
	        String line2 = lineUpper.replaceAll("[^A-Z]", "");
	        System.out.println("the content of the file after it was cleaned : \n" + line2);
	        System.out.println();
	        int lengthAfter = line2.length();
	        System.out.println("the number of characters after it was cleaned : " + lengthAfter);
	        System.out.println();
	        System.out.println("the “longest palindromic non-contiguous subsequence” : ");
	        System.out.println(longestPalSubsequence(line2));
	        System.out.println();
	        System.out.println("The length of the “longest palindromic non-contiguous subsequence” : "+ longestPalindromicSubsequence(line2));
	        System.out.println();
	        System.out.println("The length of the “longest palindromic contiguous subsequence” : " +  longestPalSubseq(line2));
	       
	}
	
}
