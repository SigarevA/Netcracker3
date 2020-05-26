package org.sigarev;


import org.sigarev.Lab1.MulMatrixWithMultiThreading;
import org.sigarev.Lab1.MulMatrixWithoutMultiThreading;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);


    public static void main(String[] args) throws InterruptedException {
        System.out.print("Перемножение матриц AxB\n");
        System.out.print("Введите размерноть матрицы A : ");
        Scanner in = new Scanner(System.in);
        int numRows1 = in.nextInt();
        int numColums1 = in.nextInt();
        System.out.print("Введите размерность матрацы B : ");
        int numRows2 = in.nextInt();
        int numColums2 = in.nextInt();
        if ( numColums1 != numRows2 ) {
            System.out.print("Матрицы должны быть размерности : (n x m) ( m x k)");
            System.exit(0);
        }
        int[][] matrixA = new int[numRows1][numColums1];
        int[][] matrixB = new int[numRows2][numColums2];
        for ( int i = 0 ; i < numRows2; i++ ) {
            for ( int j = 0; j < numRows1; j++ ) {
                matrixA[j][i] = (int)(Math.random() * 100);
            }
            for (int j = 0; j < numColums2; j++ ) {
                matrixB[i][j] = (int) (Math.random() * 100);
            }
        }
        long start = System.currentTimeMillis();
        MulMatrixWithoutMultiThreading mwot = new MulMatrixWithoutMultiThreading(matrixA, matrixB);
        int[][] res = mwot.multiplication();
        long finish = System.currentTimeMillis();
        System.out.printf("Время выполнения %d\n", finish - start);
        start = System.currentTimeMillis();
        MulMatrixWithMultiThreading mwt = new MulMatrixWithMultiThreading(matrixA, matrixB, 2);
        res = mwt.multiplication();
        finish = System.currentTimeMillis();
        System.out.println("Время выполнения с потоками " + (finish - start));
    }
}
