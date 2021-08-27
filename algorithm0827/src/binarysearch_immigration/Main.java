package binarysearch_immigration;

public class Main {
	static int n=6;
	static int[] times= {7,10};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long longest = 0;
		for (int e : times) {
			longest = Math.max(longest, e);
		}
		long max = longest * (n / times.length);

		long l = 0;
		long r = max;

		while (l < r) {
			long mid = (l + r) / 2;
			if (possible(mid)) {
				r=mid;
			} else {
				l=mid+1;
			}
		}
		System.out.println(l);
	}

	static boolean possible(long x) {
		long passed = 0L;
		for (int i = 0; i < times.length; i++) {
			passed += x / times[i];
			if (passed >= n) {
				return true;
			}
		}

		return false;

	}

}
