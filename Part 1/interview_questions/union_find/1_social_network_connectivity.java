// Question: Social network connectivity. Given a social network containing N members and a log file 
// containing M timestamps at which times pairs of members formed friendships, design an algorithm to 
// determine the earliest time at which all members are connected (i.e., every member is a friend of 
// a friend of a friend … of a friend). Assume that the log file is sorted by timestamp and that 
// friendship is an equivalence relation. The running time of your algorithm should be MlogN or better 
// and use extra space proportional to N.

// My solution: Add a count for number of connected component(s). Think of N members as N objects, and regard M
// timestamps as M unions. Then, "the earliest time at which all members are connected" is the time when 
// count is equal to 1.

// Weighted quick union with path compression

public class WeightedQuickUnionPUF {
	private int[] id;		// id[i] = parent of i
	private int[] size;		// size[i] = number of sites in subtree rooted at i
	private int count;		// number of components

	// initializes an empty union-find data structure
	public WeightedQuickUnion(int N) {
		count = N;
		id = new int[N];
		size = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}

	// returns the number of components
	public int count() {
		return count;
	}

	//returns the component identifier for the component containing site p
	public int find(int p) {
		while (id[p] != p) {
			id[p] = id[id[p]];		// path compression, one-pass variant
			p = id[p];
		}
		return p;
	}

	// returns true if the two sites are in the same component
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	// Merges the component containinzg site p with the component containinzg site q
	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ) return;
		
		// weighted - make smaller root point to larger one
		if (size[rootP] < size[rootQ]) {
			id[rootP] = rootQ;
			size[rootQ] += size[rootP];
		}
		else {
			id[rootQ] = rootP;
			size[rootP] += size[rootQ];
		}
		count--;
	}


	// reads in a sequence of pairs of integers (between 0 and n-1) from standard input,
	// where each integer represents some object;
	// if the sites are in different components, merge the two components
	// 	and prin ttheir pair to standard output
	public static void main(String[] args) {
        int n = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
