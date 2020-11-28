package metodos;

import java.util.ArrayList;

public class Hash {
	private ArrayList<Integer> primes = new ArrayList<Integer>();

	public int Hashing(int chave, int M) {
		return chave / M;
	}

	public ArrayList<Integer> getPrimeArray() {
		return primes;
	}

	public int Hashing(String chave) {
		char carac;
		int i, soma = 0;
		for (i = 0; i < chave.length(); i++) {
			carac = chave.charAt(i);
			soma += Character.getNumericValue(carac);
		}
		return soma;
	}

	public static boolean isPrime(int n) { // Function to check if a number is Prime.
		int c = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0)
				c++;
		}
		if (c == 2)// Prime no.has 2 factors-1 and number itself.
			return true;
		else
			return false;
	}
	
	public int getPrime(int num) {
		int diff1 = 0, diff2 = 0;
	     int num1 = 0, num2 = 0;
	     for(int i = num;; i++) { //No end limit as when prime will be found we will break the loop.
	         if(isPrime(i)) {
	             diff1 = i - num;
	             num1 = i;
	             break;
	         }
	     }
	     
	     for(int i = num;; i--) { //No end limit as when prime will be found we will break the loop.
	         if(isPrime(i)) {
	             diff2 = num - i;
	             num2 = i;
	             break;
	         }
	     }
	     
	     if(diff1 < diff2) //Nearest Prime number will have least difference from given number.
	         return num1;
	     else
	         return num2;
	 
	 }

	
}
