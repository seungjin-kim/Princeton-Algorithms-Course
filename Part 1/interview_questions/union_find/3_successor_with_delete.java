public class SuccessorWithDelete {
    private boolean data[]; // data[i] == false if removed
    private UFWithFindLargest uf; // used to find largest unremoved element
    private int N; // N integers in S
    
    public SuccessorWithDelete(int N) {
        this.N = N;
        data = new boolean[N];
        for (int i = 0; i < N; ++i) 
            data[i] = true;
        uf = new UFWithFindLargest(N);
    }
    
    public void remove(int x) {
        data[x] = false;
        if (x > 0 && !data[x-1])
            uf.union(x, x-1);
        if (x < N - 1 && !data[x+1])
            uf.union(x, x+1);       
    }
    
    public int successor(int x) {
        if (data[x]) {
            return x;
        } else {
            int res = uf.find(x) + 1;
            if (res >= N) {
                StdOut.println("Error, no successor can be found");
                return -1;
            } else {
                return res;
            }
        }
    }
}