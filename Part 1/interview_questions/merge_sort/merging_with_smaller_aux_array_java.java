// Question: Merging with smaller auxiliary array. Suppose that the subarray 
// 𝚊[𝟶] to 𝚊[𝚗−𝟷] is sorted and the subarray 𝚊[𝚗] to 𝚊[𝟸∗𝚗−𝟷] is sorted. How can you 
// merge the two subarrays so that 𝚊[𝟶] to 𝚊[𝟸∗𝚗−𝟷] is sorted using an auxiliary array 
// of length nn (instead of 2n2n)?

// Solution: Copy the subarray [ a[0], a[1], ..., a[n-1] ] into the auxilliary array [ storage[0], storage[1],...., storage[n-1] ].
// Set counter i=0 at the first element of the storage, storage[0] , j=0 at the first element of the second subarray, a[n] and k=0 at the first element of the first subarray, a[0] .
// Compare storage[i] and a[j] .
// If a[j] > storage[i] ; a[k] = a[j] , k ++, j ++.
// Else, a[k] = storage[i] , k ++, i ++.
// Repeat until all the elements in the storage and the subarray [ a[n], a[n+1], ..., a[2n-1] ] is placed in the array.


public void mergeWithSmallerAuxiliaryArray(Comparable[] a, Comparable[] aux, int N) {
    
    for(int k = 0; k < N; k ++) {
        aux[k] = a[k];
    }
    
    //i - index of aux array
    //j - index of right part of a
    //k - index of merged array
    int i = 0, j = N, k = 0;
    while (k < a.length) {
        if (i >= N)
            a[k++] = a[j++];
        else if (j >= a.length) 
            a[k++] = aux[i++];
        else if (aux[i].compareTo(a[j]) < 0)
            a[k++] = aux[i++];
        else {
            a[k++] = a[j++];
        }
    }
}