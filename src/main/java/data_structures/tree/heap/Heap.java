package main.java.data_structures.tree.heap;

public class Heap {

  private int[] array;
  private int sizeOfTree;

  private Heap(int size) {
    array = new int[size + 1];
    this.sizeOfTree = 0;
  }

  public int getSizeOfTree() {
    return this.sizeOfTree;
  }

  public int sizeOfArray() {
    return array.length;
  }

  public void insertIntoHeap(int value) {
    array[sizeOfTree + 1] = value;
    sizeOfTree++;
    HeapifyBottomToTop(sizeOfTree);
  }

  public int extractValuefromHeap() {
    if (sizeOfTree == 0) return -1;
    else {
      int extractedValue = array[1];
      array[1] = array[sizeOfTree];
      sizeOfTree--;
      HeapifyTopToBottom(1);
      return extractedValue;
    }
  }

  public void HeapifyBottomToTop(int index) {
    int parent = index / 2;
    if (index < 1) return;
    if (array[index] < array[parent]) {
      int temp = array[index];
      array[index] = array[parent];
      array[parent] = temp;
    }
    HeapifyBottomToTop(parent);
  }

  public void HeapifyTopToBottom(int index) {
    int left = index * 2;
    int right = (index * 2) + 1;
    int smallestChild = 0;
    if (sizeOfTree < left) return;
    else if (sizeOfTree < left) {
      if (array[index] < array[left]) {
        int temp = array[index];
        array[index] = array[left];
        array[left] = temp;
      }
      return;
    } else {
      if (array[left] < array[right]) smallestChild = left;
      else smallestChild = right;

      if (array[index] > array[smallestChild]) {
        int temp = array[index];
        array[index] = array[smallestChild];
        array[smallestChild] = temp;
      }
    }
    HeapifyTopToBottom(smallestChild);
  }

  public void levelOrder() {
    System.out.println(
        "Printing all the elements of this Heap..."); // Printing from 1 because 0th cell is dummy
    for (int i = 1; i <= sizeOfTree; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println("\n");
  }

  public void peek() {
    if (sizeOfTree == 0) {
      System.out.println("Heap is empty !");
    } else {
      System.out.println("Head of the Heap is: " + array[1]);
    }
  }

  public void deleteheap() {
    array = null;
    System.out.println("Heap has been deleted !");
  }
}
