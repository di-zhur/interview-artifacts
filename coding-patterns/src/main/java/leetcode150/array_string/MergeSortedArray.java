package leetcode150.array_string;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

// https://tutorialcup.com/leetcode-solutions/merge-sorted-arrays-leetcode-solution.htm
public class MergeSortedArray {

    static void merge(int[] a , int m , int[] b , int n) {
        int i = m - 1 , j = n - 1 , idx = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (a[i] >= b[j]) {
                a[idx] = a[i];
                i--;
            } else {
                a[idx] = b[j];
                j--;
            }
            idx--;
        }
        while (i >= 0)
             a[idx--] = a[i--];
        while (j >= 0)
             a[idx--] = b[j--];
        return;
    }
    public static void main(String args[]) {
        Queue<String> q = new LinkedList<>();
        q.offer("root");
        q.offer(null);
        System.out.print(q.poll());


        int m = 3 , n = 3;
        int[] a = new int[m + n];
        a[0] = 3;
        a[1] = 8;
        a[2] = 9;
        int[] b = {2 , 6 , 7};
        merge(a , m , b , n);
        for(int i = 0 ; i < a.length ; i++)
            System.out.print(a[i] + " ");
    }
}
