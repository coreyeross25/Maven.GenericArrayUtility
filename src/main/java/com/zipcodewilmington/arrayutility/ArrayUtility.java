package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */

public class ArrayUtility<T> {
    private T[] arr;


    public ArrayUtility(T[] inputArray) {
            arr = inputArray;
        }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
            mergeArrays(arrayToMerge);
            return getNumberOfOccurrences(valueToEvaluate);
        }

    Integer getNumberOfOccurrences(T valueToEvaluate) {
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals(valueToEvaluate)){
                count++;
            }
        }
        return count;
    }


    private void mergeArrays(T[] arrayToMerge) {
        T[] temp = Arrays.copyOf(arr, arr.length + arrayToMerge.length);
        System.arraycopy(arrayToMerge, 0, temp, arr.length, arrayToMerge.length);
        arr = temp;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        // now the arrays are merged
        mergeArrays(arrayToMerge);
        int mostCommon = -1;
        T mostCommonValue = null;

        // going through each of the values in the array to count their frequencies
        for (T currentValue : arr) {
            int count = getNumberOfOccurrences(currentValue);
            if (count > mostCommon) {
                mostCommonValue = currentValue;
                mostCommon = count;
            }
        }
        return mostCommonValue;

    }

    public T[] removeValue(T valueToRemove) {
        T[] temp = (T[]) Array.newInstance(valueToRemove.getClass(), arr.length - getNumberOfOccurrences(valueToRemove));
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals(valueToRemove)){
                continue;
            }
            temp[index] = arr[i];
            index++;
        }
        arr = temp;
        return temp;
    }
}


