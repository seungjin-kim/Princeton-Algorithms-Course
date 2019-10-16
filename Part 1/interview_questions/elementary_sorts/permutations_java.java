// Question: Permutation. Given two integer arrays of size nn, design a subquadratic 
// algorithm to determine whether one is a permutation of the other. That is, do they 
// contain exactly the same entries but, possibly, in a different order.

// Solution:
// - Sort the two arrays
// - Compare each element at same index

import java.util.Arrays;

class Permutation {

  private static boolean isPermutation(int[] a, int[] b) {
    int[] a1 = new int[a.length];
    int[] b1 = new int[b.length];
    System.arraycopy(a, 0, a1, 0, a.length);
    System.arraycopy(b, 0, b1, 0, b.length);

    Arrays.sort(a1);
    Arrays.sort(b1);

    for (int i = 0; i < a1.length; ++i) {
      if (a1[i] != b1[i]) {
        return false;
      }
    }

    return true;
  }