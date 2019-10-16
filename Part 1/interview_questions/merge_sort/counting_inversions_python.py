
# Question:
# Counting inversions. An inversion in an array a[\,]a[] is a pair of entries 
# a[i]a[i] and a[j]a[j] such that i < ji<j but a[i] > a[j]a[i]>a[j]. Given an 
# array, design a linearithmic algorithm to count the number of inversions.

# Solution:

def mergeSort(arr, n):
	temp_arr = [0]*n
	return _mergeSort(arr, temp_arr, 0, n-1)

def _mergeSort(arr, temp_arr, lo, hi):
	inv_count = 0
	if lo < hi:
		mid = (lo + hi)//2
		inv_count = _mergeSort(arr, temp_arr, lo, mid)
		inv_count += _mergeSort(arr, temp_arr, mid + 1, hi)
		inv_count += merge(arr, temp_arr, lo, mid, hi)
	return inv_count

def merge(arr, temp_arr, lo, mid, hi):
	i = lo		# Starting index of left subarray
	j = mid + 1	# Starting index of right subarray
	k = lo		# Starting index of to be sorted subarray
	inv_count = 0

	while i <= mid and j <= hi:
		if arr[i] <= arr[j]:
			temp_arr[k] = arr[i]
			k += 1
			i +=1
	else:
		temp_arr[k] = arr[j]
		inv_count += (mid - i + 1)
		k + = 1
		j += 1

	while i <= mid:
		temp_arr[k] = arr[i]
		k += 1
		i += 1

	while j <= hi:
		temp_arr[k] = arr[j]
		k += 1
		j += 1

	for loop_var in range(lo, hi + 1):
		arr[loop_var] = temp_arr[loop_var]

	return inv_count


