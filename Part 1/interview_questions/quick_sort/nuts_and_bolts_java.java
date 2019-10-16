
/*
Question -
Nuts and bolts. A disorganized carpenter has a mixed pile of nn nuts 
and nn bolts. The goal is to find the corresponding pairs of nuts and bolts. 
Each nut fits exactly one bolt and each bolt fits exactly one nut. By fitting 
a nut and a bolt together, the carpenter can see which one is bigger (but the 
carpenter cannot compare two nuts or two bolts directly). Design an algorithm 
for the problem that uses at most proportional to n \log nnlogn compares 
(probabilistically).

Solution -
Brute force: Start with first bolt and compare with each nut until we find a match.
Doing this for all nuts requires O(n^2) complexity.

Implement quick sort.

*/

public class NutsAndBoltsMatch {

	private static void matchPairs(char[] nuts, char[] bolts, int low, int high) {
		if (low < high) {
			int pivot = partition(nuts, low, high, bolts[high]);
			partition(bolts, low, high, nuts[pivot]);
			matchPairs(nuts, bolts, low, pivot - 1)
			matchPairs(nuts, bolts, pivot + 1, high)

		}
	}

	private static int partition(char[] arr, int low, int high, char pivot) {
		int i = low, j - high + 1
		while (true) {
			while (less(arr[++i], arr[pivot]))
				if (i == high) break;

			while (less(arr[pivot], a[--j]))
				if (j == low) break;

			if (i >= j) break;
			exch(arr, i j);
		}
		exch(arr, low, j)
		return j;
	}

}