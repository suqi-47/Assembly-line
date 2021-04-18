public class ASSN1_212 {
	// A space optimized solution for assembly line scheduling
		public static void main(String[] args) {
			int a[][] = {{4, 5, 3, 2},
					{2, 10, 1, 4}};
			int t[][] = {{0, 7, 4, 5},
					{0, 9, 2, 8}};
			int e[] = {10, 12}, x[] = {18, 7};

			System.out.println(AssembleTime(a, t, e, x));
		}

		public static int AssembleTime(int a[][], int t[][],
										int e[], int x[]) {
			int n = a[0].length;
			
			// time taken to leave first station in line 1
			int first = e[0] + a[0][0];

			// time taken to leave first station in line 2
			int second = e[1] + a[1][0];
			
			for (int i = 1; i < n; i++) {
				int up = Math.min(first + a[0][i],
						second + t[1][i] + a[0][i]),
						down = Math.min(second + a[1][i],
								first + t[0][i] + a[1][i]);
				first = up;
				second = down;
			}

			first += x[0];
			second += x[1];

			return Math.min(first, second);
		}
}
