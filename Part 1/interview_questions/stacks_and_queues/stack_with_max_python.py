
# Question: Stack with max. Create a data structure that efficiently supports the stack 
# operations (push and pop) and also a return-the-maximum operation. Assume the elements 
# are real numbers so that you can compare them.

# Solution: 
# - Create one main stack and another to track the max element
# - Push the first element to both stacks
# - From second element, push element to main stack. Then compare the element with top element
# 	of track stack. If current element is greater, then push the current elemetn to track stack,
# 	otherwise push top element of track stack again 
# - If you pop element from main stack, pop from track stack as well
# - To get the max of main stack, return the top element of track stack

class StackWithMax:
	def __init__(self):
		self.mainStack = []
		self.trackStack = []

	def push(self, x):
		self.mainStack.append(x)
		if (len(self.mainStack) == 1):
			self.trackStack.append(x)
			return

	def getMax(self):
		return self.trackStack[-1]

	def pop(self):
		self.mainStack.pop()
		self.trackStack.pop()