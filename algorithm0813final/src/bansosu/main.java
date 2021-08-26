package bansosu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
	static boolean[] prime;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		prime = new boolean[n+6];
		makePrime();
		while(true) {
			if(chk(n)) {
				System.out.println(n);
				break;
			}
			n++;
		}
		
	}
	static void makePrime() {
		for (int i = 0; i < prime.length; i++) {
			prime[i] = true;
		}
		prime[0] = prime[1] = false;
		for (int i = 0; i*i < prime.length; i++) {
			if(!prime[i]) continue;
			for (int j = i+i; j < prime.length; j+=i) {
				prime[j] = false;
			}
		}
	}
	static boolean chk(int x) {
		if(prime[x])return false;
		for (int i = 2; i < prime.length; i++) {
			if(!prime[i])continue;
			if(prime[x/i]&&x%i==0&&x/i!=i) {
				return true;
			}
		}
		return false;
	}

}
