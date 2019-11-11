//Authors: Stanley Lin & Yajie Zhang
//Program to find the Longest Palindromic Subsequence in a string (non-contiguous) & (contiguous)
//References: https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/, https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
//Encoding: UTF-8
import java.io.*;

public class LPS {
	public static void main(String[] args) throws IOException {
		//Read in text file, program assumes file is in the same directory as the source code
		File inputFile = new File("QueensCollegeDescription.txt");
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();
			
		while(line != null) {
			sb.append(line);
			sb.append("\n");
			line = br.readLine();
		}
		//Convert text to String
		String orig_sequence = sb.toString();
		//Clean up String by removing all non-alphabetic characters, and setting all letters to uppercase
	 	String mod_sequence = orig_sequence.replaceAll("[^a-zA-Z]","").toUpperCase();
	
		//Close Buffered Reader
		br.close();
		System.out.println("File name: " + inputFile.getName());
		System.out.println();
		System.out.println("ORIGINAL TEXT");
		System.out.println();
		System.out.println(orig_sequence);
		System.out.println();
		System.out.println("Total character count: " + countChars(orig_sequence));
		System.out.println();
		System.out.println("CLEANED UP TEXT");
		System.out.println();
		System.out.println(mod_sequence);
		System.out.println();
		System.out.println("Total character count: " + countChars(mod_sequence));
		System.out.println();
		System.out.println("LPS (non-contiguous): " + lps(mod_sequence));	
		System.out.println("LPS (non-contiguous) length: " + countChars(lps(mod_sequence)));	
		System.out.println("LPS (contiguous) length: " + longestPalSubstr(mod_sequence));
				
	}

	// A utility function to get max of two integers 
    static int max (int x, int y) { 
    	return (x > y)? x : y; 
    } 
      
    // Returns the length of the longest  
    // palindromic subsequence in seq 
    static String lps(String seq) {  
    	int n = seq.length(); //get length of input string
    	int i, j, cl; 
    	// Create a table to store results of subproblems 
    	int L[][] = new int[n][n];
    	
    	
    	// Strings of length 1 are palindrome of length 1 
    	for (i = 0; i < n; i++) 
    		L[i][i] = 1; 
        //Build table matrix      
        for (cl= 2; cl <= n; cl++) { 
            for (i = 0; i < n - cl + 1; i++) { 
                j = i + cl - 1; 
                if (seq.charAt(i) == seq.charAt(j) && cl == 2) {
                	L[i][j] = 2; 
                }
                else if (seq.charAt(i) == seq.charAt(j)) {
                	L[i][j] = L[i + 1][j - 1] + 2; 
                }
                else {
                	L[i][j] = max(L[i][j - 1], L[i + 1][j]); 
                }
            } 
        }
        //Rebuild String from table matrix
        StringBuffer strBuff = new StringBuffer();
        int x = 0, y = n - 1;
        while(x < y) {
        	if(seq.charAt(x) == seq.charAt(y)) {
        		strBuff.append(seq.charAt(x));
        		x++;
        		y--;
        	}
        	else if(L[x][y-1] > L[x+1][y]) {
        		y--;
        	}
        	else {
        		x++;
        	}
        }
        
        StringBuffer strBuffCopy = new StringBuffer(strBuff);
        String str = strBuffCopy.reverse().toString();
        if(x == y) {
        	strBuff.append(seq.charAt(x)).append(str);
        }
        else {
        	strBuff.append(str);
        }
       
        return strBuff.toString(); 
    }
    
    static int longestPalSubstr(String str) { 
        int n = str.length();   // get length of input string 
	
        boolean table[][] = new boolean[n][n]; 
	//All strings of length 1 are palindromes
        int maxLength = 1; 
        for (int i = 0; i < n; ++i) 
            table[i][i] = true; 
 
        int start = 0; 
        for (int i = 0; i < n - 1; ++i) { 
            if (str.charAt(i) == str.charAt(i + 1)) { 
                table[i][i + 1] = true; 
                start = i; 
                maxLength = 2; 
            } 
        } 
          
        // Check for lengths greater than 2. k is length 
        // of substring 
        for (int k = 3; k <= n; ++k) {                                
            for (int i = 0; i < n - k + 1; ++i)  { 
                
                int j = i + k - 1; 
         
                if (table[i + 1][j - 1] && str.charAt(i) ==  
                                          str.charAt(j)) { 
                    table[i][j] = true; 
  
                    if (k > maxLength) { 
                        start = i; 
                        maxLength = k; 
                    } 
                } 
            } 
        } 
        System.out.print("LPS (contiguous): "); 
        printSubStr(str, start, start + maxLength - 1); 
          
        return maxLength; // return length of LPS 
    } 
    
    static void printSubStr(String str, int low, int high) { 
        System.out.println(str.substring(low, high + 1)); 
    } 
}
