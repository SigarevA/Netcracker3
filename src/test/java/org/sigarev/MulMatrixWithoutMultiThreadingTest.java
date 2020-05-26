package org.sigarev;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.sigarev.Lab1.MulMatrixWithMultiThreading;
import org.sigarev.Lab1.MulMatrixWithoutMultiThreading;

import static org.junit.Assert.*;

public class MulMatrixWithoutMultiThreadingTest {

    private static final Logger LOG = LogManager.getLogger(MulMatrixWithoutMultiThreadingTest.class);


    @Test
    public void multiplication() {
        int[][] matrix1 = { {5 , 6 , 7} , {8 , 6, 1}, {3, 4, 5}};
        int[][] matrix2 = {{4 , 5 , 6 , 7},{ 2, 3, 4, 4},{8,9,10,11}};
        MulMatrixWithoutMultiThreading mwot = new MulMatrixWithoutMultiThreading(matrix1, matrix2);
        int[][] truematrix = {{88,106,124,136},{52,67,82,91},{60,72,84,92}};
        int[][] resmatrix = mwot.multiplication();
        for (int i = 0 ; i < 3; i++) {
            for (int j = 0; j < 4; j++)
                assertTrue(truematrix[i][j] == resmatrix[i][j]);
        }
    }

    @Test
    public void multiplicationwithThread() throws InterruptedException {
        int[][] matrix1 = { {5 , 6 , 7} , {8 , 6, 1}, {3, 4, 5}};
        int[][] matrix2 = {{4 , 5 , 6 , 7},{ 2, 3, 4, 4},{8,9,10,11}};
        MulMatrixWithMultiThreading mwt = new MulMatrixWithMultiThreading(matrix1, matrix2, 2);
        int[][] truematrix = {{88,106,124,136},{52,67,82,91},{60,72,84,92}};
        int[][] resmatrix = mwt.multiplication();
        for (int i = 0 ; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                LOG.debug(resmatrix[i][j]);
                assertTrue(truematrix[i][j] == resmatrix[i][j]);
            }
        }
    }
}