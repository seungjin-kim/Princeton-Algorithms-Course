# Question: Intersection of two sets. Given two arrays 𝚊[] and 𝚋[], each containing 
# n distinct 2D points in the plane, design a subquadratic algorithm to count the 
# number of points that are contained both in array 𝚊[] and array 𝚋[].

# Solution: Sort arrays a and b (takes O(m log m + n log n) time)
# 	Find union / intersection of two sorted arrays


arr1.sort()

def printIntersection(arr1, arr2, m, n):
	arr1.sort()
	arr2.sort()

	i, j = 0, 0
	while i < m and j < n:
		if arr1[i] < arr2[j]:
			i += 1
		elif arr2[j] < arr1[i]:
			j += 1
		else:
			print(arr2[j])
			j += 1
			i += 1

