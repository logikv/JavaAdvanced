package heapOnArray;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Heap heap = new Heap(10);
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.remove(0);
        System.out.println(heap.toString());
        heap.add(6);
        System.out.println(heap.toString());
        heap.remove(0);
        System.out.println(heap.toString());

        System.out.println(heap.getParentIndex(0));
        System.out.println(heap.getLeftChildIndex(0));
        System.out.println(heap.getRightChildIndex(0));

    }


}

class Heap {

    private int[] data;
    private int heapSize = 0;

    public Heap(int heapSize) {
        this.data = new int[heapSize];
    }

    public void add(int v) {
        this.data[heapSize] = v;
        heapSize++;
        int i = heapSize - 1;
        int parent = (i - 1) / 2;

        while (i > 0 && data[parent] < data[i]) {
            int temp = data[i];
            data[i] = data[parent];
            data[parent] = temp;

            i = parent;
            parent = (i - 1) / 2;
        }

    }


    public void remove(int nodeIndex) {
        if (nodeIndex == 0) {
            data[0] = data[heapSize - 1];
        } else {
            data[nodeIndex] = 0;
        }
        heapSize--;
        heapify(nodeIndex);
    }

    public void heapify(int nodeIndex) {// перемещаем число из корня в ветки

        int largestNode;
        int leftNode;
        int rightNode;

        for (; ; ) {  // ищем большее число из двух

            leftNode = 2 * nodeIndex + 2;
            rightNode = 2 * nodeIndex + 1;
            largestNode = nodeIndex;

            if (leftNode < heapSize && data[leftNode] > data[largestNode]) {
                largestNode = leftNode;
            }

            if(rightNode < heapSize && data[rightNode] > data[largestNode]){
                largestNode = rightNode;
            }

            if(largestNode == nodeIndex){ break; }

            int temp = data[nodeIndex];
            data[nodeIndex] = data[largestNode];
            data[largestNode] = temp;
            nodeIndex = largestNode;

        }


    }

    public String toString(){
        return Arrays.toString(data);
    }

    public int getLeftChildIndex(int nodeIndex) {
        return data[2 * nodeIndex + 2];
    }

    public int getRightChildIndex(int nodeIndex) {
        return data[2 * nodeIndex + 1];
    }


    public int getParentIndex(int nodeIndex) {
        return data[(nodeIndex - 1) / 2];
    }

}
