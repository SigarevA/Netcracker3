package org.sigarev.sortshell;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortShellTest {

    @Test
    public void sort() {
        int[] arr = {1, 4, 6, 9, 2, 5, 11, 18};
        int[] orderarr = {1, 2, 4, 5, 6, 9, 11, 18};
        SortShell.sort(arr);
        System.out.print(Arrays.toString(arr));
        for ( int i = 0; i < arr.length; i++ ){
            Assert.assertTrue(arr[i] == orderarr[i]);
        }
    }

}