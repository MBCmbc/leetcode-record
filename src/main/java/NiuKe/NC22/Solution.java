package NiuKe.NC22;

/*
同leetcode P88
*/
public class Solution {
	public void merge(int A[], int m, int B[], int n) {
		int p1 = m-1, p2 = n-1, p = m+n-1;

		while(p1>=0 && p2>=0) A[p--] = A[p1] > B[p2] ? A[p1--] : B[p2--];

		System.arraycopy(B, 0, A, 0, p2+1);
	}
}
