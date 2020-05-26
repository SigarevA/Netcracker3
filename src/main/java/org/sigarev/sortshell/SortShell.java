package org.sigarev.sortshell;


import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * Класс, содержащий статичный метод(sort(int[])), который сортируте массив
 * по методу шелла
 */
public class SortShell {

    public static void sort(int[] arr) {
        int d = arr.length / 2;
        ExecutorService exs = Executors.newFixedThreadPool(4);
        while( d >= 1 ) {
            for ( int i = 0; i < arr.length - d; i++ ) {

                for (int j = i; j < arr.length - d; j+=d)
                {
                    if ( arr[j] > arr[j + d] ) {
                        int temp = arr[j];
                        arr[j] = arr[j + d];
                        arr[j + d] = temp;
                    }
                }
            }
            d /= 2;
        }
    }

}
