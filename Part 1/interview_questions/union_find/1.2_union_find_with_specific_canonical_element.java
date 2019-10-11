// Question: Union-find with specific canonical element. Add a method 𝚏𝚒𝚗𝚍() to the union-find data type so 
// that 𝚏𝚒𝚗𝚍(𝚒) returns the largest element in the connected component containing ii. The operations, 
// 𝚞𝚗𝚒𝚘𝚗(), 𝚌𝚘𝚗𝚗𝚎𝚌𝚝𝚎𝚍(), and 𝚏𝚒𝚗𝚍() should all take logarithmic time or better.

// For example, if one of the connected components is \{1, 2, 6, 9\}{1,2,6,9}, then the 𝚏𝚒𝚗𝚍() method 
// should return 99 for each of the four elements in the connected components.

public class UFWithFindLargest {
    private int id[]; // id[i] = parent of node i
    private int sz[]; // sz[i] = size of node i
    private int large[]; // large[i] = largest element in component
    
    public UFWithFindLargest(int N) {
        id = new int[N];
        sz = new int[N];
        large = new int[N];
        for (int i = 0; i < N; ++i) {
            id[i] = i;
            sz[i] = 1;
            large[i] = i;
        }
    }
    
    private int root(int p) {
        while (id[p] != p) {
            id[p] = id[id[p]]; // path compression
            p = id[p];
        }
        return p;
    }
    
    // return the largest element in the connected component containing p
    public int find(int p) { 
        return large[root(p)];
    }
    
    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        if (rootp == rootq) return;
        int largestP = large[rootp];
        int largestQ = large[rootq];
        if (sz[rootp] < sz[rootq]) {
            id[rootp] = rootq;
            sz[rootq] += sz[rootp];
            
            if (largestP > largestQ)
                large[rootq] = largestP;
        } else {
            id[rootq] = rootp;
            sz[rootp] += sz[rootq];
            
            if (largestQ > largestP)
                large[rootp] = largestQ;
        }
    }
    
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}
