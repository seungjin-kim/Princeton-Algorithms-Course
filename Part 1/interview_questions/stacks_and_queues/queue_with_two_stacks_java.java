/**
 * Coursera - Algorithms Part I
 * Week 2 - Interview Questions - Stacks and Queues
 *
 * Question 1: Queue with two stacks
 *
 * Implement a queue with two stacks so that each queue operations takes a
 * constant amortized number of stack operations.
 */

/*
Solution

Enqueue: push new element onto input stack
Dequeue: If outbox is empty, refill it by popping each element from inbox and
	pushing it onto outbox.
	Pop and return the top element from outbox

Each element will be pushed twice and popped twice, giving amortized constant time
operations.
*/


class QueueTwo<item> {
	private Stack<Item> input = new Stack<Item>();
	private Stack<Item> output = new Stack<Item>();

	public void enqueue(Item item) {
		if (isEmpty()) {
			throw new java.util.NoSuchElementException();
		}
		input.push(item);
	}

	public Item dequeue() {
		if (isEmpty()) {
			throw new java.util.NoSuchElementException();
		}

		if(output.isEmpty()) {
			while (!input.isEmpty()) {
				output.push(input.pop());
			}
		}
		return output.pop();
	}
}



