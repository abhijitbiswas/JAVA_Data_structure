package Algo;
/*
Abhijit.Biswas
A Min-Heap is a complete binary tree in which the value in each internal node is greater than or equal to the values in the children of that node.
Mapping the elements of a heap into an array is trivial: if a node is stored a index k, then its left child is stored at index 2k + 1 and its right child at index 2k + 2.

Example of Min Heap:

            5                      13
         /      \               /       \
       10        15           16         31
      /                      /  \        /  \
    30                     41    51    100   41
How is Min Heap represented?
A Min Heap is a Complete Binary Tree. A Min heap is typically represented as an array. The root element will be at Arr[0]. For any ith node, i.e., Arr[i]:

Arr[(i -1) / 2] returns its parent node.
Arr[(2 * i) + 1] returns its left child node.
Arr[(2 * i) + 2] returns its right child node.
 */

public class MeanHeap {
}
