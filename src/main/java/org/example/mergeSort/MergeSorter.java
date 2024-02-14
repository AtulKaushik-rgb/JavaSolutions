package org.example.mergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {
    private List<Integer> arrToSort;
    private ExecutorService executor;
    public MergeSorter(List<Integer> arrToSort, ExecutorService executor) {
        this.arrToSort = arrToSort;
        this.executor = executor;
    }

    @Override
    public List<Integer> call() throws Exception {
        if(arrToSort.size() <= 1)
            return arrToSort;

        int mid = arrToSort.size()/2;

        List<Integer> leftArr = new ArrayList<>();
        List<Integer> rightArr = new ArrayList<>();

        for(int i = 0; i<mid; i++)
        {
            leftArr.add(arrToSort.get(i));
        }
        for(int i = mid; i<arrToSort.size(); i++)
        {
            rightArr.add(arrToSort.get(i));
        }
        //create tasks for left and right
        MergeSorter leftmerger = new MergeSorter(leftArr, executor);
        MergeSorter rightmerger = new MergeSorter(rightArr, executor);
        //submit the tasks
        Future<List<Integer>> leftSortedFuture = executor.submit(leftmerger);
        Future<List<Integer>> rightSortedFuture = executor.submit(rightmerger);

        //Await till both of them are done
        List<Integer> leftSortedArray = leftSortedFuture.get();
        List<Integer> rightSortedArray = rightSortedFuture.get();

        //logic for merging the array.
        List<Integer> sorted = new ArrayList<>();

        int i = 0, j=0;
        while(i < leftSortedArray.size() && j< rightSortedArray.size()) {
            if(leftSortedArray.get(i) < rightSortedArray.get(j)) {
                sorted.add(leftSortedArray.get(i));
                i++;
            }
            else {
                sorted.add(rightSortedArray.get(j));
                j++;
            }
        }
        while(i < leftSortedArray.size()) {
            sorted.add(leftSortedArray.get(i));
            i++;
        }

        while(j < rightSortedArray.size()) {
            sorted.add(rightSortedArray.get(j));
            j++;
        }
        return sorted;
    }
}
