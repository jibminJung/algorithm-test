package palindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			String target = br.readLine();
			int left = 0;
			int right = target.length() - 1;

			int type = 0;
			while (left <= right) {
				if (target.charAt(left) == target.charAt(right)) {
					left++;
					right--;
				} else {
					int l = left;
					int r = right;

					l++;
					while (l <= r) {
						if (target.charAt(l) == target.charAt(r)) {
							l++;
							r--;
						} else {
							type++;
							break;
						}
					}

					l = left;
					r = right;
					r--;
					while (l <= r) {
						if (target.charAt(l) == target.charAt(r)) {
							l++;
							r--;
						} else {
							type++;
							break;
						}
					}

				}
				if (type > 0)
					break;

			}
			System.out.println(type);

		}

	}

}
