# Question
# Dynamic median. Design a data type that supports insert in logarithmic time, find-the-median 
# in constant time, and remove-the-median in logarithmic time. If the number of keys in the data 
# type is even, find/remove the lower median.

# Solution
# Use binary heap - a max heap and min heap. Max heap contains the smallest half of the numbers
# and min heap contains the largest half. The numbers of elements in max heap is either euqal to
# or 1 more than the number of elements in the min heap.

class dynamicMedian:
	def __init__(self):
		self.minHeap, self.maxHeap = [], []
		self.N = 0

	def insert(self, num):
		if self.N % 2 == 0:
			heapq.heapush(self.maxHeap, -1 * num)
			self.N += 1
			if len(self.minHeap) == 0:
				return
			if -1 * self.maxHeap[0] > self.minHeap[0]:
				toMin = -1 * heapq.heappop(self.maxHeap)
				toMax = heapq.heapop(self.minHeap)
				heapq.heappush(self.maxHeap, -1 * toMax)
				heapq.heappush(self.minHeap, toMin)

		else:
			toMin = -1 * heapq.heappushpop(self.maxHeap, -1 * num)
			heapq.heappush(self.minHeap, toMin)
			self.N += 1

	def getMedian(self):
		return (-1 * self.maxHeap[0])

